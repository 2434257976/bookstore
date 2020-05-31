package com.bookstore.utils;

import java.util.UUID;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/8
 */
public class IdUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
