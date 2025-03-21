package com.example.QR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.QR.entity.Orders;
import com.example.QR.service.OrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Orders placeOrder(@RequestBody Orders order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/{customerId}")
    public List<Orders> getCustomerOrders(@PathVariable Long customerId) {
        return orderService.getCustomerOrders(customerId);
    }

    @DeleteMapping("/orderId/{orderId}")
    public boolean deleteOrder(@PathVariable long orderId) {
        return orderService.deleteOrder(orderId);
    }

    @PutMapping("/orderId/{orderId}")
    public Orders updateOrder(@PathVariable long orderId, @RequestBody Orders updateOrder) {
        return orderService.updateOrder(orderId, updateOrder);
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }
}
