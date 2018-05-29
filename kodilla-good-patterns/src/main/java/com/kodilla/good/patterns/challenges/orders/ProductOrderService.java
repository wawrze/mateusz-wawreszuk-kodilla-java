package com.kodilla.good.patterns.challenges.orders;

import com.kodilla.good.patterns.challenges.orders.confirmation.OrderConfirmationService;
import com.kodilla.good.patterns.challenges.orders.orderable.Orderable;
import com.kodilla.good.patterns.challenges.orders.ordersdb.OrderRepository;

public class ProductOrderService {

    private OrderConfirmationService orderConfirmationService;
    private Orderable orderItem;
    private OrderRepository orderRepository;

    public ProductOrderService(final OrderConfirmationService orderConfirmationService,
                               final Orderable orderItem,
                               final OrderRepository orderRepository) {
        this.orderConfirmationService = orderConfirmationService;
        this.orderItem = orderItem;
        this.orderRepository = orderRepository;
    }

    public OrderDto order (final OrderRequest orderRequest){
        boolean isOrdered = orderItem.order();
        if(isOrdered) {
            orderConfirmationService.send(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getOrderNumber(),orderRequest.getOrderItem());
            return new OrderDto(orderRequest.getOrderNumber(), true);
        } else {
            return new OrderDto(orderRequest.getOrderNumber(), false);
        }
    }

}