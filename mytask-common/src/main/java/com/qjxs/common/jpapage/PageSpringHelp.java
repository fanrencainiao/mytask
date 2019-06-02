package com.qjxs.common.jpapage;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

public class PageSpringHelp {

    public static Pageable convert(PageParam page) {
        if (page == null) page = new PageParam().withFirstSize(0, 10);
        Pageable result = null;

        Sort sort = convert(page.getSortParam());

        if (sort == null) {
            result = new PageRequest(page.getPage(), page.getSize());
        } else {
            result = new PageRequest(page.getPage(), page.getSize(), sort);
        }

        return result;
    }


    public static Sort convert(SortParam sort) {
        if (sort == null) return null;
        if (CollectionUtils.isEmpty(sort.getOrders())) return null;
        List<Sort.Order> orders = convert(sort.getOrders());
        if (CollectionUtils.isEmpty(orders)) return null;
        Sort result = new Sort(orders);

        return result;
    }

    private static Sort.Order convert(OrderParam order) {
        if (order == null) return null;
        Sort.Order result = new Sort.Order(order.getDirection(), order.getProperty(), order.getNullHandling());

        return result;
    }

    private static List<Sort.Order> convert(List<OrderParam> orders) {
        if (CollectionUtils.isEmpty(orders)) return null;
        List<Sort.Order> resultList = orders.stream().map(o -> convert(o)).filter(r -> r != null).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(resultList)) return null;

        return resultList;
    }
}
