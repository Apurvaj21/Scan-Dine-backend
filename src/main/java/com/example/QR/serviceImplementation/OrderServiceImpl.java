package com.example.QR.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.QR.entity.Customer;
import com.example.QR.entity.OrderItem;
import com.example.QR.entity.Orders;
import com.example.QR.repository.CustomerRepo;
import com.example.QR.repository.OrderRepo;
import com.example.QR.service.OrderService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<Orders> getCustomerOrders(Long customerId) {
        Customer customer = customerRepo.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));
        return orderRepo.findByCustomer(customer);
    }

    @Override
    public Orders placeOrder(Orders order) {
        Customer customer = order.getCustomer();

        if (customer == null) {
            throw new RuntimeException("Customer information is missing in the order.");
        }

        Customer managedCustomer = customerRepo.findById(customer.getCustomerId())
                .orElseGet(() -> customerRepo.save(customer)); // Save only if not found

        order.setCustomer(managedCustomer); // Set the managed entity

        // Ensure order items are linked properly
        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                item.setOrder(order);
            }
        }

        return orderRepo.save(order); // Save the order along with items
    }

    @Override
    public Orders placeOrder(Long customerId, List<Long> itemId) {
        return null;
    }

    @Override
    public boolean deleteOrder(long orderId) {
        Optional<Orders> orders = orderRepo.findById(orderId);
        if (!orders.isPresent()) {
            return false;
        }
        orderRepo.deleteById(orderId);
        return true;
    }

    @Override
    public Orders updateOrder(long orderId, Orders updateOrder) {
        Optional<Orders> orders = orderRepo.findById(orderId);
        if (!orders.isPresent()) {
            throw new EntityNotFoundException("Order not found");
        }
        orders.get().setOrderTime(updateOrder.getOrderTime());
        orders.get().setStatus(updateOrder.getStatus());
        orders.get().setTotalAmount(updateOrder.getTotalAmount());
        return orderRepo.save(orders.get());
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    public Orders saveOrder(Orders order) {
        for (OrderItem item : order.getOrderItems()) {
            item.setOrder(order); // Ensure OrderItem is linked
        }
        return orderRepo.save(order); // Save order + items
    }
}
