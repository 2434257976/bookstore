package com.bookstore.commons.beans;

import java.util.Date;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/7
 */
public class Notice {
    private Integer id;
    private String title;
    private String details;
    private Date n_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getN_time() {
        return n_time;
    }

    public void setN_time(Date n_time) {
        this.n_time = n_time;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", n_time=" + n_time +
                '}';
    }
}
