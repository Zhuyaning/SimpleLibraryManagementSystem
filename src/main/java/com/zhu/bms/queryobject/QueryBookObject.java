package com.zhu.bms.queryobject;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 11:39
 */

public class QueryBookObject {

    private String bookName;
    private String authorName;
    private String dirId;

    private Integer pageSize = 5;
    private Integer currentPage = 1;
    private Integer startIndex = 0;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
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
        return "QueryBookObject{" +
                "bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", dirId='" + dirId + '\'' +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", startIndex=" + getStartIndex() +
                '}';
    }
}
