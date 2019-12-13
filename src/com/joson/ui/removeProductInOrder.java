package com.joson.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joson.controller.OrderController;

public class removeProductInOrder {

	public static void main(String[] args) {
		//获取配置信息和控制层对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderController controller = ac.getBean(OrderController.class);
		
		try {
			//移除商品的订单id和商品名称
			controller.removeProductInOrders(1, "吉他");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
