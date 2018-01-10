package com.tsl.emps.comon.util;

import java.util.Collection;

public class Page<T> {
    int pageCurrent;
    int pageSize;
    int pageCount;
    Collection<T> data;
    int total;
    int firstPage=1;
//    int nextPage;
//    int prevPage;
    int lasttPage ;

    public Page() {
    }

    public Page(int pageCurrent, int pageSize, Collection<T> data, int total) {
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
        this.pageCount = (total%pageSize==0)?total/pageSize:(total/pageSize)+1;
        this.firstPage = 1;
        this.lasttPage = pageCount;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getNextPage() {
        if ((pageCurrent + 1) <= pageCount) {
            return  pageCurrent+1;
        }
        return pageCurrent;
    }


    public int getPrevPage() {
        if ((pageCurrent -1) >= firstPage) {
            return  pageCurrent-1;
        }
        return firstPage;
    }



    public int getLasttPage() {
        return lasttPage;
    }

    public void setLasttPage(int lasttPage) {
        this.lasttPage = lasttPage;
    }
}
