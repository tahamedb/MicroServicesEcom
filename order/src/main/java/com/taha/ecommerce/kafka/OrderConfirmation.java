package com.taha.ecommerce.kafka;

import com.taha.ecommerce.customer.CustomerResponse;
import com.taha.ecommerce.order.PaymentMethod;
import com.taha.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
