package com.bookstore.admin.products.handler;

import com.alipay.api.internal.util.codec.Base64;
import com.bookstore.admin.products.service.IAdminProductService;
import com.bookstore.commons.beans.Product;
import com.bookstore.commons.beans.ProductList;
import com.bookstore.utils.IdUtils;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/13
 */
@Controller
@RequestMapping("/admin/products")
public class AdminProductHandler {

    @Autowired
    IAdminProductService adminProductService;
    //获取商品列表，查询全部商品信息
    @RequestMapping("/listProduct")
    public String listProduct(Model model){

      List<Product> products= adminProductService.findProduct();
        model.addAttribute("products",products);
        // for (Product p:products){
        //     System.out.println(p);
        // }
        return "/admin/products/list.jsp";
    }
    //按多个条件查询商品信息
    @RequestMapping("/findProductByManyCondition")
    public String findProductByManyCondition(Product product,Double minprice,Double maxprice,Model model){
       List<Product> products= adminProductService.findProductByManyCandition(product,minprice,maxprice);
       model.addAttribute("products",products);
       model.addAttribute("product",product);
        model.addAttribute("minprice",minprice);
        model.addAttribute("maxprice",maxprice);
       return "/admin/products/list.jsp";
    }

    //添加商品
    @RequestMapping("/addProduct")
    public String addProduct(Product product, MultipartFile upload, HttpSession session) throws IOException {
        //保存图片
        String path1="C:\\Users\\29746\\Desktop\\bookstore\\src\\main\\webapp\\productImg";
        String path= session.getServletContext().getRealPath("/productImg");//获取的是项目发布的真实路径
        //System.out.println("文件上传路径"+path);
        File file=new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        String filename= IdUtils.getUUID()+"-" +upload.getOriginalFilename();
        upload.transferTo(new File(path,filename));
        //upload.transferTo(new File(path1,filename));
        //文件copy
        FileUtils.copyFile(new File(path,filename),new File(path1,filename));
        //数据库添加商品信息
        product.setId(IdUtils.getUUID());
        product.setImgurl("/productImg/"+filename);
        adminProductService.addProduct(product);
        return "redirect:/admin/products/listProduct";
    }

    //查找要修改商品的原始信息
    @RequestMapping("/findProductById")
    public String findProductById(String id,Model model){
      Product product= adminProductService.findProductById(id);
      model.addAttribute("p",product);
      return "/admin/products/edit.jsp";
    }
    //修改商品信息
    @RequestMapping("/editProduct")
    public String editProduct(Product product,MultipartFile upload,HttpSession session) throws IOException {
       if (!upload.isEmpty()){//如果上传的有新的图片
           //查找商品的原始信息
           Product target=adminProductService.findProductById(product.getId());
           //删除原始图片
           File targetFile= new File(session.getServletContext().getRealPath("/")+target.getImgurl());
           if (targetFile.exists()){
               targetFile.delete();
           }
           //保存新的图片
           String path1="C:\\Users\\29746\\Desktop\\bookstore\\src\\main\\webapp\\productImg";
           String path=session.getServletContext().getRealPath("/productImg");
           String filename=IdUtils.getUUID()+"-"+upload.getOriginalFilename();
           upload.transferTo(new File(path,filename));
           //文件copy
           FileUtils.copyFile(new File(path,filename),new File(path1,filename));
           //如果上传了新的图片，给product的Imgurl赋新的图片地址
           product.setImgurl("/productImg/"+filename);

       }
           //修改数据库信息
           adminProductService.editProduct(product);
           return "redirect:/admin/products/listProduct";
    }
    //删除商品
    @RequestMapping("/removeProduct")
    public String removeProduct(String id,HttpSession session){
        //System.out.println("删除方法被调用");
        Product target=adminProductService.findProductById(id);
        File targetFile=new File(session.getServletContext().getRealPath("/")+target.getImgurl());
        if (targetFile.exists()){
            targetFile.delete();
        }
        adminProductService.removeProduct(id);
        return "redirect:/admin/products/listProduct";
    }
    //销售榜单
    @RequestMapping("/download")
    public void download(String year, String month,HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<ProductList> plist=adminProductService.findProductSalList(year,month);
        for (ProductList pl:plist){
            System.out.println(pl);
        }
        String filename=year+"年"+month+"月销售榜单";
        String sheetName=month+"月销售榜单";
        String titleName=year+"年"+month+"月销售榜单";
        String[] columnName={"商品名称","商品销量"};

        String[][] dataList=new String[plist.size()][2];
        for (int i = 0; i <plist.size() ; i++) {
            dataList[i][0]=plist.get(i).getName();
            dataList[i][1]=plist.get(i).getSalnum();
        }

        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建excel中的sheet
        HSSFSheet sheet= wb.createSheet(sheetName);
        //创建对应的第一行
        HSSFRow row1=sheet.createRow(0);
        //创建第一行的第一个单元格
        HSSFCell cell= row1.createCell(0);
        //合并第一行的两个单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));//起始行，终止行，起始列，终止列
        //给第一行第一个合并后的单元格赋值
        cell.setCellValue(titleName);

        //创建第二行,并赋值
        HSSFRow row=sheet.createRow(1);
        for (int i=0 ;i<2;i++){
            row.createCell(i).setCellValue(columnName[i]);
        }
        //第三行往后，循环把数组内的数据放入表格
        for (int i = 0; i <dataList.length; i++) {
               row = sheet.createRow(i+2);
            for (int j=0;j<2;j++){
                row.createCell(j).setCellValue(dataList[i][j]);
            }
        }
        String fileName=filename+".xls";
        response.setContentType("application/ms-excel;charset=UTF-8");
        response.setHeader("content-Disposition","attachment;filename="+encodeChineseDownloadFileName(request,fileName));
        OutputStream out=response.getOutputStream();
        wb.write(out);
    }

    public static String encodeChineseDownloadFileName(HttpServletRequest request, String pFileName) throws UnsupportedEncodingException {
        String filename = null;
        String agent = request.getHeader("USER-AGENT");
        if (null != agent) {
            if (
                    -1 != agent.indexOf("Firefox")) {//Firefox

                filename = "=?UTF-8?B?" + (new String(Base64.encodeBase64(pFileName.getBytes("UTF-8")))) + "?=";
            } else if (-1 != agent.indexOf("Chrome")) {//Chrome
                filename = new String(pFileName.getBytes(), "ISO8859-1");
            } else {//IE7+
                filename = URLEncoder.encode(pFileName, "UTF-8");
                filename = StringUtils.replace(filename, "+", "%20");//替换空格
            }
        } else {
            filename = pFileName;
        }
        return filename;
    }

}
