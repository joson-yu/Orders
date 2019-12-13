package com.joson.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.joson.controller.OrderController;
import com.joson.domain.Orders;
import com.joson.domain.Product;

public class addProductInOrder {
	public static void main(String[] args) {
		//��ȡ������Ϣ�Ϳ��Ʋ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderController controller = ac.getBean(OrderController.class);
		
		//�����Ʒ
		Product product = new Product();
		product.setProductName("С����");
		product.setProductOid(1);
		product.setProductPrice(600d);
		product.setProductSum(9000);
		product.setProductType("�ľ�");
		product.setProductStatus("����");
		
		try {
			//���ض������󣬲�������id ��Ʒ����
			Orders orders = controller.addProductInOrders(product.getProductOid(), product);
			System.out.println(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
