package com.whx.pojo;

import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/10/5
 * @descriptions
 */
public class Page <T>{

    public static final Integer PAGE_SIZE = 4 ;

    private List<T> bookItems;
    private Integer totalCount;
    private Integer pageSize = PAGE_SIZE ;
    private Integer totalPageCount;
    private Integer noPage ;
    private String url ;

    public Page() {
    }

    public Page(List<T> bookItems, Integer totalCount, Integer pageSize, Integer totalPageCount, Integer noPage) {
        this.bookItems = bookItems;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPageCount = totalPageCount;

        if(noPage < 1 ){
            this.noPage = 1;
        }else if(noPage > totalPageCount){
            this.noPage = totalPageCount;
        }else {
            this.noPage = noPage;
        }

    }

    public List<T> getBookItems() {
        return bookItems;
    }

    public void setBookItems(List<T> bookItems) {
        this.bookItems = bookItems;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getnoPage() {
        return noPage;
    }

    public void setnoPage(Integer noPage) {
        this.noPage = noPage;
    }

    public Integer getNoPage() {
        return noPage;
    }

    public void setNoPage(Integer noPage) {
        this.noPage = noPage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "bookItems=" + bookItems +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPageCount=" + totalPageCount +
                ", noPage=" + noPage +
                '}';
    }


}
