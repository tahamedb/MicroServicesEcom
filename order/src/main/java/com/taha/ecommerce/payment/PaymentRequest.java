package com.taha.ecommerce.payment;

import com.taha.ecommerce.customer.CustomerResponse;
import com.taha.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
