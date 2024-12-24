package com.taha.ecommerce.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    // Mutation: Create a Product
    @MutationMapping(name = "createProduct")
    public Integer createProduct(@Argument @Valid ProductRequestInput request) {
        return service.createProduct(request.toProductRequest());
    }

    // Mutation: Purchase Products
    @MutationMapping(name = "purchaseProducts")
    public List<ProductPurchaseResponse> purchaseProducts(@Argument List<ProductPurchaseRequestInput> request) {
        return service.purchaseProducts(request.stream()
                .map(ProductPurchaseRequestInput::toProductPurchaseRequest)
                .toList());
    }

    // Query: Find Product by ID
    @QueryMapping(name = "findProductById")
    public ProductResponse findById(@Argument Integer productId) {
        return service.findById(productId);
    }

    // Query: Find All Products
    @QueryMapping(name = "findAllProducts")
    public List<ProductResponse> findAll() {
        return service.findAll();
    }
}