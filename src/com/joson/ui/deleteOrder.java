package com.joson.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joson.controller.OrderController;

public class deleteOrder {
	public static void main(String[] args) {
		//��ȡ������Ϣ�Ϳ��Ʋ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderController controller = ac.getBean(OrderController.class);
		
		controller.deleteOrder(1);
	}
}
