package com.joson.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.joson.domain.Orders;
import com.joson.domain.Product;
import com.joson.service.OrderService;
import com.joson.service.ProductService;

@Controller
public class OrderController {
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;
	
	/*
	 * 增加订单和订单中的商品
	 */
	public Orders addOrder(Orders order) {
		//获取订单中商品信息
		List<Product> products = order.getoProducts();
		if (products==null) {
			throw new NullPointerException("订单商品不能为空！");
		}
		
		try {
			orderService.addOrder(order);
			System.out.println("添加订单成功！");
			return order;
		} catch (Exception e) {
			System.out.println("订单添加失败！");
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 订单的中添加一个商品
	 */
	public Orders addProductInOrders(Integer oId,Product product) {
		//在订单中添加一个产品
		Orders order = orderService.findById(oId);
		orderService.addOrderProduct(oId, product);
		return order;
	}
	
	/*
	 * 订单中减少一个商品
	 */
	public Orders removeProductInOrders(Integer oId,String proName) {
		
		Orders order = orderService.deleteOrderProduct(oId, proName);
		//移除商品后，若订单中无商品
		if (order.getoProducts()==null) {
			//删除订单
			return null;
		}
		return order;
	}
	
	/*
	 * 删除订单时，商品全部删除
	 */
	public void deleteOrder(Integer oId) {
		orderService.deleteOrder(oId);
	}

}
