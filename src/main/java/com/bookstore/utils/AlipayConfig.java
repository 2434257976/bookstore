package com.bookstore.utils;

import java.io.FileWriter;
import java.io.IOException;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/29
 */


    /* *
     *类名：AlipayConfig
     *功能：基础配置类
     *详细：设置帐户有关信息及返回路径
     *修改日期：2017-04-05
     *说明：
     *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
     *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
     */

    public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

        // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
        public static String app_id = "2016102400748791";

        // 商户私钥，您的PKCS8格式RSA2私钥
        public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCKDteLcX9VutPJTVB1NhaCKNxYgWMrxOwuM2ZVx7/ysUltoah7EHgFOt8r0qxZHd302dRNr/JIZy40yN4dSTalhRostbERpP/p28GaK51SDO2MR8Jcnidxyososedrw20NpbuG18CX21t74ilOdUto2C/8aPWned+oaWDLMJSi8JhutrI/2y+fKcY1VhNLzRCBfi4GLTuZATbdaumvEHA5n8+LPGI760ZffQm9X7j1zdMbi8IMTfaB+bWtC2eej0Fc5yK7pB87l1h1Wb/3GLSCGebayBVEJM4RVknj3tXrJTbt+YqCP/i7QZyyTieY3Cwl/Rd5zL8Yrmw8xxVUgWotAgMBAAECggEAG6nVru9TII6LGW8QjCwGXpZpcKKciIyw9qD+BHo+EBdOK1WVOPOX2RRu240fU8wUSZfMXrS+y5tBOvp051FgTdJZ6FOP44U4clfCd2393A8TGmTWoVBffwGi2MitIn7KP03SQbbBtKwTrMMom7wNHDkVhHJTpvdYxZo39v8JCYz17R96sCoIygeHpNRQnbopaON/0A5BOCQ36R7AjGTI/KTUI1cQmhWBFukjBx483/sYVbAK9xHGBfojShU8Egub8hsZ5XZ+QupJdJdCDihTTMLkb/WDPIHrDOBD+0MesB+F798bbIJHu5n1i82f1koha13vn8o6lyUkduGElW2XUQKBgQD4yQsg5+DDDHx/+NQ41Ec1UA/pwqtRW06eZ8ZX1MgesQxjLPYzqvRrPSvJXVc/HGjwoQHE9J+yg4x0ey33I0QDnf3XEVD4vI8xO2AYRJcI1Xc/VnPntf1piZ0tsXH8usS19Hoog+vIWQPXz5YH4cOql9WMRT/K8zZO0bpShMKrfwKBgQCOD8Ul5c4dRMVqLU1sooMk0oOyYGWVlrhJcTllbBMIcNXYSShlSLdSCqWV1V1QyjBmUsNeCSmayaIFTcVNZ+I+peYtKkc5prYxEtEOIc/ahIMgy1QJpXJWcJO+AmiZfwNbyojo5ucEDk33TXyOXe3bqwTJFfKDDWEegmeJhMQwUwKBgQCK/o+4H7TEZIp+WQAAjCEImSV63acnehLvj10SHzB7bUFVe35GGaIa8/8trnebK/05S0sYxe8fJj3nqhZhOBO8zZ1Pdj496eM6h0jF5jRX3COWgG+bKmNdfmQRbk0X/ST/34oMbr/hnFH4VeMlni3adp/5kYr1kXJrEOO/TKsScwKBgFJVg36ObOH7vKrn7KqcmYNa2uckBVwoSVCPZaOJepJ2ywmahOYGufC7qPJpAbdUJ672IrK6frluSQ/n3gUZwz9p6Tid+z/Hhmp0rGMTZ6MPD+yOy3r3v4enoYkLXlIwEeM+RBEv2g44uCkvaJQejj+1I4XjyXT46SPEkntaTlZvAoGBAIephAOyLmglT/NynYdZRUKXPKIUCS+b+B2zalzBsO0zTw1C5wIr6POmBNh7aMbBGOGjZj+jIymw9oQLdlNsV8qMYrmNR0+cSnwk7+6frj0zH1zEFQOFjEM2InWvUwBUftj5/JbgXIe4grtpFwBD3nSWS5+2Kq6FpUiCTUAxjfqi";

        // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
        public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtfP599Eyo/9t7HYdoZziQew8J4tmb/If7R5urigsZGyHOC9tpkYuOHKuJnIETvDpxT8NSFZ5S8hQBSC+rC37bOdHjslAbfPQj39tL3rQzJzxdomg9MOP8DPmqX/mqQwWm2bu+3oc++A/cYhIpXYpuqct03IzbxcK3StuIAPd88GBUg9oAJO+EwCHnV8UNp2Ma5C8+BvXkqs5b4modlxsETKsb4CcYCe6KBvKpr+is5f57qBvPlE1yklYHVLadgbe13DQgmRCV1lJgsLTRymlAwlHN6z8QQtvRcm6NFEXkyJac7LTbZlEQ06m7xuOfECPPejOpNxVYueVX8UPRfqvBQIDAQAB";

        // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

        // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
        public static String return_url = "http://localhost:8080/bookstore_war/client/order/paysuccess";

        // 签名方式
        public static String sign_type = "RSA2";

        // 字符编码格式
        public static String charset = "utf-8";

        // 支付宝网关
        public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

        // 支付宝网关
        public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        /**
         * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
         * @param sWord 要写入日志里的文本内容
         */
        public static void logResult(String sWord) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
                writer.write(sWord);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



