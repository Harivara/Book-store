package org.example.orderservice.domain.models;


public record OrderSummary(String orderNumber, OrderStatus status) {}