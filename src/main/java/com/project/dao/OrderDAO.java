package com.project.dao;

import java.util.List;

import com.project.entities.Order;
import com.project.entities.OrderDetail;

public interface OrderDAO {
	public List<Order> getAll();
	public Boolean createOrder(Order order);
	public Order find(Integer orderId);
	public Boolean updateOrder(Order order);
	public Boolean deleteOrder(Integer orderId);
	
	public List<OrderDetail> listByOrder(Integer orderId);
	public OrderDetail findOrderDetail(Integer orderDetailId);
	public Boolean createOrderDetail(OrderDetail orderDetail);
	public Boolean deleteOrderDetail(Integer orderId);
}
