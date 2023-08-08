package com.mousatech.orderservice.service;

import com.mousatech.orderservice.dto.OrderItemsRequest;
import com.mousatech.orderservice.dto.OrderRequest;
import com.mousatech.orderservice.model.Order;
import com.mousatech.orderservice.model.OrderItems;
import com.mousatech.orderservice.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    public void placeOrder(OrderRequest orderRequest){
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .orderItems(mapToOrderItems(orderRequest.getOrderItems()))
                .build();
        orderRepo.save(order);
    }

    private List<OrderItems> mapToOrderItems(List<OrderItemsRequest> orderItems) {
        return orderItems.stream()
                .map(orderItemsRequest -> OrderItems.builder()
                        .sku(orderItemsRequest.getSku())
                        .price(orderItemsRequest.getPrice())
                        .quantity(orderItemsRequest.getQuantity())
                        .build())
                .toList();
    }
}
