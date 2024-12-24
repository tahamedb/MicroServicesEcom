package com.taha.ecommerce.order;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService service;

  @QueryMapping
  public List<OrderResponse> orders() {
    return service.findAllOrders();
  }

  /**
   * Corresponds to:
   * type Query {
   *   order(orderId: Int!): OrderResponse!
   * }
   */
  @QueryMapping
  public OrderResponse order(@Argument Integer orderId) {
    return service.findById(orderId);
  }

  /**
   * Corresponds to:
   * type Mutation {
   *   createOrder(input: OrderRequestInput!): Int!
   * }
   */
  @MutationMapping
  public Integer createOrder(@Argument("input") @Valid OrderRequest request) {
    // The OrderService.createOrder(...) returns an Integer (the order ID),
    // which lines up with "Int!" in the GraphQL schema.
    return service.createOrder(request);
  }
}
