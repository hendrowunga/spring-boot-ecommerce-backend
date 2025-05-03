package com.hendro.ecommerce.service;

import com.hendro.ecommerce.dto.Purchase;
import com.hendro.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

     PurchaseResponse placeOrder(Purchase purchase);
}
