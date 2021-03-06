package com.bookstore.utils;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/2/24
 */
public class PageModel {
    //当前页面的页码
    private int pageIndex;
    //页面的大小
    private int pageSize=4;
    //总共的页码数
    private int totalSize;
    //总记录数
    private int rocordCount;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        if(rocordCount%pageSize==0){
            totalSize = rocordCount/pageSize;
        }else{
            totalSize =rocordCount/pageSize+1;
        }
        return totalSize;
    }

    // public void setTotalSize(int totalSize) {
    //     this.totalSize = totalSize;
    // }

    public int getRocordCount() {

        return rocordCount;
    }

    public void setRocordCount(int rocordCount) {

        this.rocordCount = rocordCount;
    }
    //获取当前页的起始索引
    public int getFirstLimitParam(){

        return (this.getPageIndex()-1)*this.pageSize;
    }

}
