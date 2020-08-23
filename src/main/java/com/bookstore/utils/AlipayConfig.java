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
        public static String app_id = "2016102200738642";

        // 商户私钥，您的PKCS8格式RSA2私钥
//GmTWoVBffwGi2MitIn7KP03SQbbBtKwTrMMom7wNHDkVhHJTpvdYxZo39v8JCYz17R96sCoIygeHpNRQnbopaON/0A5BOCQ36R7AjGTI/KTUI1cQmhWBFukjBx483/sYVbAK9xHGBfojShU8Egub8hsZ5XZ+QupJdJdCDihTTMLkb/WDPIHrDOBD+0MesB+F798bbIJHu5n1i82f1koha13vn8o6lyUkduGElW2XUQKBgQD4yQsg5+DDDHx/+NQ41Ec1UA/pwqtRW06eZ8ZX1MgesQxjLPYzqvRrPSvJXVc/HGjwoQHE9J+yg4x0ey33I0QDnf3XEVD4vI8xO2AYRJcI1Xc/VnPntf1piZ0tsXH8usS19Hoog+vIWQPXz5YH4cOql9WMRT/K8zZO0bpShMKrfwKBgQCOD8Ul5c4dRMVqLU1sooMk0oOyYGWVlrhJcTllbBMIcNXYSShlSLdSCqWV1V1QyjBmUsNeCSmayaIFTcVNZ+I+peYtKkc5prYxEtEOIc/ahIMgy1QJpXJWcJO+AmiZfwNbyojo5ucEDk33TXyOXe3bqwTJFfKDDWEegmeJhMQwUwKBgQCK/o+4H7TEZIp+WQAAjCEImSV63acnehLvj10SHzB7bUFVe35GGaIa8/8trnebK/05S0sYxe8fJj3nqhZhOBO8zZ1Pdj496eM6h0jF5jRX3COWgG+bKmNdfmQRbk0X/ST/34oMbr/hnFH4VeMlni3adp/5kYr1kXJrEOO/TKsScwKBgFJVg36ObOH7vKrn7KqcmYNa2uckBVwoSVCPZaOJepJ2ywmahOYGufC7qPJpAbdUJ672IrK6frluSQ/n3gUZwz9p6Tid+z/Hhmp0rGMTZ6MPD+yOy3r3v4enoYkLXlIwEeM+RBEv2g44uCkvaJQejj+1I4XjyXT46SPEkntaTlZvAoGBAIephAOyLmglT/NynYdZRUKXPKIUCS+b+B2zalzBsO0zTw1C5wIr6POmBNh7aMbBGOGjZj+jIymw9oQLdlNsV8qMYrmNR0+cSnwk7+6frj0zH1zEFQOFjEM2InWvUwBUftj5/JbgXIe4grtpFwBD3nSWS5+2Kq6FpUiCTUAxjfqi";
          public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDieqZr4eneg0ns/I9/BKRw2qL3bBkBlAAWol0QMtVFSrd/ugGosDdbBewAbJ+O/nmzx/J0mfVGe4frZpcLYdbq978R9VISfO0kyGXKvWeGcPIc72M1ew072sl7wM6Zf1dG0IGWOOKoNX9SNMxIDkPwK1RNkBwtr/7u3qbXS9qp0Rf9dVhggRGOy4WJgHkHtBw/1kFPoaFEdzg6vSLOq/LQKXJKvwvL0XrY/zQjn6yji6r1nCMoteiLmaylzkJTiL/pjoO6Y3lALff/YQNNsPGKReDx4EG7+ytlCZbJOmo2l4QDPW2g7/pX3OIZTeGFvIk6R/CD0e3Q5S1dvvZ4yKjfAgMBAAECggEASYHTeBp4BK+KE/AZRvmjwblEwZeFOjzmFnKWUAafsADDNCKUHUMshE+UvMKEuy2fJJnV+MBrmnfHssC2b4xO7C6DBnogLD393j1oxHfbHQiVnIyaH6aTsgSd9puqsqlhE2vjU3WdI0lRzMW0NALlTBNUJmSKsM15qd/8OM625vyJQdsgADQKcSSC21KKM30bzsnV+y1iFnbTZlRjCBZER+IHEcYKfjf4J0xJ5aQfByNtjjyuY5VN8gWIdSHeQMBKxuZ9+Nh26uOslN64Cx24nZaHoGhwHwNodBxx5bYd8xXB113P6iiIDwKgXih+g8v39oKmOwTA0IHbNtakCfjwYQKBgQD0MHGRN7A+BtpxKu7kKG3gSXTx88HFgmFQEZbIvHrlAoT81aTPwAAgyBzwHrNlWcxDMaUWza3s8P1Lw6B0gv0mk/j5ep6hxnS5RWXMx2oT55AbRFVyyciT1kPiCNNJ/yz042BqmsQOIAmPrsHJ/CRBo6OLDf/SlUa1BCqJb6EwDwKBgQDtbutTAQ0RCmEggLtTQY/TYMmMoTd4o2vHiBLf5Xo2FUvL3DsAyz5Zjqh1XT+yvCLthC0BpB/arxCbujr0Kcqh/1AWLYrb769oGMpsaG60lHVq5bvPKEPnrnx1vt/LY+PEIDdtum3M9MscAf/ZoAXHSa6UyVhQAQMA0gFhujQqMQKBgQDgH/acyvhAdhnY9Qb+8vymd8WWrZyUo+6dhwdWh2hk+cMGLTFwXVHAxOuKmSMfSyRoKBDWtUGF0EssVwnW5sNjvT0v/pPK+FP6GPAu3HlIe6mQ3U9wZDRtPKRhuqfzqvqganH8ZsC8FjuwXT4RHhRJCuD4qIi9x7V2P7SrIIJZkQKBgBDbeC+7el8EWqMBIMuncvux+n1WkOaqy6MuAREObN/cITaHG1VSGMoo+8LhbP1WqDAu2zcrnOtc1JQJ49ekA/P+eYQplZtJ6C0+3VhXDc0aYT/Gsc/ibvfLBqEhfSgmnmw1UVokC1mq46TIa47a8q4UiCWeKfv8JmdvgZObscpxAoGADpev1XvR3wCwulEU1lx1lS3kNdBClAdnO2gc0RlvPlb+EOZ6WIE5KCMoVLoMyjWrd9/p+UnAPek7GdcC7qshHLnlMHJ5aC92EIQ3zH6Pkxc8ehd97Ka6mr/a0WuRfm+suLZk/2U73At+my++HTX45nnNFOEjYjnOXmzxC1uO0Q8=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
//        public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtfP599Eyo/9t7HYdoZziQew8J4tmb/If7R5urigsZGyHOC9tpkYuOHKuJnIETvDpxT8NSFZ5S8hQBSC+rC37bOdHjslAbfPQj39tL3rQzJzxdomg9MOP8DPmqX/mqQwWm2bu+3oc++A/cYhIpXYpuqct03IzbxcK3StuIAPd88GBUg9oAJO+EwCHnV8UNp2Ma5C8+BvXkqs5b4modlxsETKsb4CcYCe6KBvKpr+is5f57qBvPlE1yklYHVLadgbe13DQgmRCV1lJgsLTRymlAwlHN6z8QQtvRcm6NFEXkyJac7LTbZlEQ06m7xuOfECPPejOpNxVYueVX8UPRfqvBQIDAQAB";
         public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4nqma+Hp3oNJ7PyPfwSkcNqi92wZAZQAFqJdEDLVRUq3f7oBqLA3WwXsAGyfjv55s8fydJn1RnuH62aXC2HW6ve/EfVSEnztJMhlyr1nhnDyHO9jNXsNO9rJe8DOmX9XRtCBljjiqDV/UjTMSA5D8CtUTZAcLa/+7t6m10vaqdEX/XVYYIERjsuFiYB5B7QcP9ZBT6GhRHc4Or0izqvy0ClySr8Ly9F62P80I5+so4uq9ZwjKLXoi5mspc5CU4i/6Y6DumN5QC33/2EDTbDxikXg8eBBu/srZQmWyTpqNpeEAz1toO/6V9ziGU3hhbyJOkfwg9Ht0OUtXb72eMio3wIDAQAB";
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



