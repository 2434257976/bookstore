package com.bookstore.commons.beans;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/25
 */
public class ProductList {
    private String name;
    private String salnum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalnum() {
        return salnum;
    }

    public void setSalnum(String salnum) {
        this.salnum = salnum;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "name='" + name + '\'' +
                ", salnum='" + salnum + '\'' +
                '}';
    }
}
