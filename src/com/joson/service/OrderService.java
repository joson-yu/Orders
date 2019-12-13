package com.joson.service;

import java.util.List;
import com.joson.domain.Orders;
import com.joson.domain.Product;

/*
 * service曾订单类的接口
 */
public interface OrderService {
	/*
	 * 查询所有的订单
	 */
	List<Orders> findAllOrder();
	
	/*
	 * 往订单表中添加一个订单
	 */
	void addOrder(Orders order);
	
	/*
	 * 根据订单id查找订单信息
	 */
	Orders findById(Integer oid);
	
	/*
	 * 在订单id中删除一个商品
	 */
	Orders deleteOrderProduct(Integer oId,String proName);
	
	/*
	 * 在订单id中添加一个商品
	 */
	void addOrderProduct(Integer oId,Product product);
	
	/*
	 * 删除订单时，里面的商品全部清空
	 */
	void deleteOrder(Integer oId);
	
}
