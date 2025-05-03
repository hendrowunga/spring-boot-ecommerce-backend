package com.hendro.ecommerce.dto;

import com.hendro.ecommerce.entity.Address;
import com.hendro.ecommerce.entity.Customer;
import com.hendro.ecommerce.entity.Order;
import com.hendro.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
