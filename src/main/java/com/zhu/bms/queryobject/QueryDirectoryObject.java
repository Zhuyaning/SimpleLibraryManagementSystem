package com.zhu.bms.queryobject;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/24
 *   Time: 12:33
 */

public class QueryDirectoryObject {

    private String keyWords;  //查询类别的关键词

    private Integer pageSize = 5;
    private Integer currentPage = 1;
    private Integer startIndex = 0;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize >= 1) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = 5;
        }
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage <= 1) {
            this.currentPage = 1;
        } else {
            this.currentPage = currentPage;
        }
    }

    public void setStartIndex() {
        this.startIndex = (currentPage - 1) * pageSize;
    }

    public Integer getStartIndex() {
        //查询启始值为 ：当前页数先减一再乘每页显示的数。
        return startIndex = (currentPage - 1) * pageSize;
    }

    @Override
    public String toString() {

        return "QueryDirectoryObject{" +
                "keyWords='" + keyWords + '\'' +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", startIndex=" + getStartIndex() +
                '}';
    }
}
