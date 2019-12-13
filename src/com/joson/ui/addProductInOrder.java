package com.joson.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joson.controller.OrderController;
import com.joson.domain.Orders;
import com.joson.domain.Product;

public class addProductInOrder {
	public static void main(String[] args) {
		//获取配置信息和控制层对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderController controller = ac.getBean(OrderController.class);
		
		//添加商品
		Product product = new Product();
		product.setProductName("小提琴");
		product.setProductOid(1);
		product.setProductPrice(600d);
		product.setProductSum(9000);
		product.setProductType("文具");
		product.setProductStatus("正常");
		
		try {
			//返回订单对象，参数订单id 产品对象
			Orders orders = controller.addProductInOrders(product.getProductOid(), product);
			System.out.println(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
