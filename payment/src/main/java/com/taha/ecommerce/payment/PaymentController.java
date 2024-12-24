package com.taha.ecommerce.payment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentController {

  private final PaymentService paymentService;

  @GraphQLMutation(name = "createPayment")
  public Integer createPayment(@GraphQLArgument(name = "request") @Valid PaymentRequest request) {
    return paymentService.createPayment(request);
  }
}