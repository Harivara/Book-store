package org.example.bookstorewebapp.web.controllers.clients.orders;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.bookstorewebapp.web.controllers.clients.orders.Address;
import org.example.bookstorewebapp.web.controllers.clients.orders.Customer;
import org.example.bookstorewebapp.web.controllers.clients.orders.OrderItem;

import java.io.Serializable;
import java.util.Set;

public record CreateOrderRequest(
        @NotEmpty(message = "Items cannot be empty.") @NotNull(message = "Items cannot be null.") Set<OrderItem> items,
        @Valid Customer customer,
        @Valid Address deliveryAddress)
        implements Serializable {}