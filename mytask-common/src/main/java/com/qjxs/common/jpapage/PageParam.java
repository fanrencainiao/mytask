package com.qjxs.common.jpapage;

/**
 * 翻页查询条件
 */
public class PageParam {

    private int page;
    private int size;
    private SortParam sortParam;

    public static final int DEFAULT_PAGE = 0;  // spring data page start with 0
    public static final int DEFAULT_SIZE = 10;

    public PageParam() {
        page = DEFAULT_PAGE;
        size = DEFAULT_SIZE;
    }

    public void setFirstSize(int first, int size) {
        if (size < 1) {
            return;
        }
        int pageSize = size;
        int page = first / pageSize;
        if (page < 0) {
            page = DEFAULT_PAGE;
        }
        this.page = page;
        this.size = size;

    }

    public void setFirstSizeSort(int first, int size, SortParam sortParam) {
        setFirstSize(first, size);
        setSortParam(sortParam);
    }

    public static PageParam of() {
        return new PageParam();
    }

    public PageParam withFirstSize(int first, int size) {
        this.setFirstSize(first, size);
        return this;
    }

    public PageParam withFirstSizeSort(int first, int size, SortParam sortParam) {
        this.setFirstSizeSort(first, size, sortParam);
        return this;
    }


    public SortParam getSortParam() {
        return sortParam;
    }

    public void setSortParam(SortParam sortParam) {
        this.sortParam = sortParam;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
