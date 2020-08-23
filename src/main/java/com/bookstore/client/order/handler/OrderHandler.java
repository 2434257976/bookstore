package com.bookstore.client.order.handler;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.bookstore.client.order.service.IOrderService;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.Product;
import com.bookstore.commons.beans.User;
import com.bookstore.utils.AlipayConfig;
import com.bookstore.utils.IdUtils;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Controller
@RequestMapping("/client/order")
public class OrderHandler {
    @Autowired
    IOrderService orderService;

    @RequestMapping("/createOrder")
    public String createOrder(Order order, HttpSession session, Model model){
        System.out.println(order);

        order.setId(IdUtils.getUUID());
        //从session中获取登录用户，也就是提交订单的用户
       order.setUser((User) session.getAttribute("login_user"));
       //从session中获取购物车
        Map<Product,Integer> cart= (Map<Product, Integer>) session.getAttribute("cart");
        //调用service方法创建订单
        orderService.CreateOrder(order,cart);
        //把生成订单的购物车清空
        session.removeAttribute("cart");
        //把订单信息放到域对象中
        model.addAttribute("order",order);
        return "/client/confirm.jsp";
    }
    @RequestMapping("/pay")
    public void pay(String id, String money, HttpServletResponse response) throws AlipayApiException, IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no =id;
        //付款金额，必填
        String total_amount =money;
        //订单名称，必填
        String subject =id;
        //商品描述，可空
        String body =null;
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        //输出
        response.setContentType("text/html");
        response.getWriter().println(result);
    }

    //支付宝账号：eydefk1901@sandbox.com
    //密码；111111
    @RequestMapping("/paysuccess")
    public String paysuccess(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        //实现支付状态的改变
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String order_id = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            //实现支付状态的修改，改为已支付，paystate=1
            orderService.paySuccess(order_id);
            return "redirect:/client/paysuccess.jsp";
            // out.println("trade_no:"+trade_no+"<br/>out_trade_no:"+order_id+"<br/>total_amount:"+total_amount);
        }else {
            return "redirect:/client/fail.jsp";
            // out.println("验签失败");
        }
    }

}
