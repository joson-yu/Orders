package com.joson.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joson.controller.OrderController;

public class removeProductInOrder {

	public static void main(String[] args) {
		//��ȡ������Ϣ�Ϳ��Ʋ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderController controller = ac.getBean(OrderController.class);
		
		try {
			//�Ƴ���Ʒ�Ķ���id����Ʒ����
			controller.removeProductInOrders(1, "����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
