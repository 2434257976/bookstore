package com.bookstore.admin.products.dao;

import com.bookstore.commons.beans.Product;
import com.bookstore.commons.beans.ProductList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/13
 */
public interface IAdminProductDao {
    List<Product> selectProduct();

    List<Product> selectProductByManyCandition(Map map);

    void insertProduct(Product product);

    Product selectProductById(String id);

    void updateProduct(Product product);

    void deleteProduct(String id);

    List<ProductList> selectProductSalList(@Param("year") String year, @Param("month") String month);
}
