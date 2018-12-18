package com.zhujun.tools;

import java.util.List;

public class Page<T> {
    //当前 页数
    private static int pageNumber;
    //每页显示条数
    private static int pageSize;
    //总记录数
    private static int totalRecode;
    //当前页内容
    private List<T> pagedata;

    //计算总页数
    public static int getTotalPage() {
        int totalPage = totalRecode / pageSize;
        return totalRecode % pageSize == 0 ? totalPage : totalPage + 1;
    }

    //从哪条开始查
    public static int getStart(int pageNumber, int pageSize) {
        return (pageNumber - 1) * pageSize;
    }

    public Page(int pageNumber, int pageSize, int totalRecode, List<T> pagedata) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalRecode = totalRecode;
        this.pagedata = pagedata;
    }

    public Page() {
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecode() {
        return totalRecode;
    }

    public void setTotalRecode(int totalRecode) {
        this.totalRecode = totalRecode;
    }

    public List<T> getPagedata() {
        return pagedata;
    }

    public void setPagedata(List<T> pagedata) {
        this.pagedata = pagedata;
    }
}
