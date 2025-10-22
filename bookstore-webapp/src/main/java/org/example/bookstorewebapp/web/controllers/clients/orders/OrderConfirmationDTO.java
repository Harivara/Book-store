package org.example.bookstorewebapp.web.controllers.clients.orders;

public record OrderConfirmationDTO(String orderNumber, OrderStatus status) {}
