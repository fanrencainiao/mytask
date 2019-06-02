package com.qjxs.common.jpapage;

import org.springframework.data.domain.Sort;

/**
 * 单个排序字段
 */
public class OrderParam {

    private Sort.Direction direction;
    private String property;
    private Sort.NullHandling nullHandling;


    public OrderParam() {
        nullHandling = Sort.NullHandling.NULLS_LAST;
    }

    public static OrderParam of() {

        return new OrderParam();
    }

    public OrderParam withDirection(Sort.Direction direction) {
        this.direction = direction;
        return this;
    }

    public OrderParam withProperty(String property) {
        this.property = property;
        return this;

    }

    public OrderParam withNullHandling(Sort.NullHandling nullHandling) {
        this.nullHandling = nullHandling;
        return this;
    }

    public Sort.NullHandling getNullHandling() {
        return nullHandling;
    }

    public void setNullHandling(Sort.NullHandling nullHandling) {
        this.nullHandling = nullHandling;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
