package com.amigoscode.models;

public record NewCustomerRequest(
        String name,
        String email,
        Integer age
) {
}
