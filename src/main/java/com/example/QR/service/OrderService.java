package com.example.QR.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.QR.entity.Orders;

@Service
public interface OrderService {

	Orders placeOrder(Long customerId, List<Long> itemId);

	List<Orders> getCustomerOrders(Long customerId);

	Orders placeOrder(Orders order);

	boolean deleteOrder(long orderId);

	Orders updateOrder(long orderId, Orders updateOrder);

	List<Orders> getAllOrders();
	
	 

}
