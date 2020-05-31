package com.bookstore.client.products.service;

import com.bookstore.commons.beans.Notice;
import com.bookstore.commons.beans.Product;
import com.bookstore.utils.PageModel;


import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/20
 */

public interface IProductService {
    List<Product> findProductByCategory(String category, PageModel pageModel);

    int findProductCountByCategory(String category);


    List<Product> findProductByName(String name, PageModel pageModel);

    int findProductByNameCount(String name);

    Product findProductById(String id);

    Notice findNoticeRecent();

    List<Product> findWeekHotProduct();
}














