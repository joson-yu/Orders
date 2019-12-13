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
	 * ���Ӷ����Ͷ����е���Ʒ
	 */
	public Orders addOrder(Orders order) {
		//��ȡ��������Ʒ��Ϣ
		List<Product> products = order.getoProducts();
		if (products==null) {
			throw new NullPointerException("������Ʒ����Ϊ�գ�");
		}
		
		try {
			orderService.addOrder(order);
			System.out.println("��Ӷ����ɹ���");
			return order;
		} catch (Exception e) {
			System.out.println("�������ʧ�ܣ�");
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * �����������һ����Ʒ
	 */
	public Orders addProductInOrders(Integer oId,Product product) {
		//�ڶ��������һ����Ʒ
		Orders order = orderService.findById(oId);
		orderService.addOrderProduct(oId, product);
		return order;
	}
	
	/*
	 * �����м���һ����Ʒ
	 */
	public Orders removeProductInOrders(Integer oId,String proName) {
		
		Orders order = orderService.deleteOrderProduct(oId, proName);
		//�Ƴ���Ʒ��������������Ʒ
		if (order.getoProducts()==null) {
			//ɾ������
			return null;
		}
		return order;
	}
	
	/*
	 * ɾ������ʱ����Ʒȫ��ɾ��
	 */
	public void deleteOrder(Integer oId) {
		orderService.deleteOrder(oId);
	}

}
