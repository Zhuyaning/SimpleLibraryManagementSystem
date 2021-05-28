package com.zhu.bms.result;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/21
 *   Time: 11:49
 */

public class ResultObject<T> {

    private Integer currentPage;

    private Integer pageSize;

    private Integer totalCount = 0;

    private List<T> resultDate;

    private Integer prevPage;

    private Integer nextPage;

    private Integer totalPage;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if (currentPage >= 1) {
            this.currentPage = currentPage;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        if (totalCount >= 0) {
            this.totalCount = totalCount;
        }
    }

    public Integer getPrevPage() {
        setPrevPage();
        return prevPage;
    }

    public void setPrevPage() {
        if (getCurrentPage() <= 1) {
            this.prevPage = getCurrentPage();
        } else {
            this.prevPage = getCurrentPage() - 1;
        }
    }

    public Integer getNextPage() {
        setNextPage();
        return nextPage;
    }

    public void setNextPage() {
        if (getCurrentPage() >= getTotalPage()) {
            this.nextPage = getCurrentPage();
        } else {
            this.nextPage = getCurrentPage() + 1;
        }
    }

    public Integer getTotalPage() {
        setTotalPage();
        return totalPage;
    }

    public void setTotalPage() {
        if (getTotalCount() % getPageSize() == 0) {
            this.totalPage = getTotalCount() / getPageSize();
        } else {
            this.totalPage = (getTotalCount() / getPageSize()) + 1;
        }
    }

    public List<T> getResultDate() {
        return resultDate;
    }

    public void setResultDate(List<T> resultDate) {
        this.resultDate = resultDate;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", prevPage=" + getPrevPage() +
                ", nextPage=" + getNextPage() +
                ", totalPage=" + getTotalPage() +
                ", resultDate=" + resultDate +
                '}';
    }
}
