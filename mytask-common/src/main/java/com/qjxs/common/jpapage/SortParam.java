package com.qjxs.common.jpapage;

import java.util.ArrayList;
import java.util.List;

public class SortParam {

    private List<OrderParam> orders;

    public SortParam() {

    }

    public void addOrder(OrderParam order) {
        if (orders == null) {
            orders = new ArrayList<>();
        }
        if (order == null) return;
        orders.add(order);

    }

    public List<OrderParam> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderParam> orders) {
        this.orders = orders;
    }
}
