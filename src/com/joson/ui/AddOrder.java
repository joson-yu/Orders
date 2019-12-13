package com.joson.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.joson.controller.OrderController;
import com.joson.domain.Orders;
import com.joson.domain.Product;

/*
 * ���ԣ���Ӷ�������Ʒ
 */
public class AddOrder {
	public static void main(String[] args) {
		//��ȡ�����ļ��Ϳ��Ʋ����
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderController controller = ac.getBean(OrderController.class);
		//������������Ʒ
		Orders order = new Orders();
		List<Product> productsList = new ArrayList<Product>();
		Product product1 = new Product();
		Product product2 = new Product();
		
		product1.setProductName("����");
		product1.setProductPrice(1500d);
		product1.setProductSum(8000);
		product1.setProductType("����");
		product1.setProductStatus("����");
		
		product2.setProductName("����");
		product2.setProductPrice(500d);
		product2.setProductSum(33440);
		product2.setProductType("����");
		product2.setProductStatus("����");
		
		//����Ʒ��ӵ�������
		productsList.add(product1);
		productsList.add(product2);
		
		order.setOrderId(1);
		order.setOrderTotalMoney(product1.getProductPrice()+product2.getProductPrice());
		order.setoProducts(productsList);
		order.setOrderTime(new Date());
		order.setOrderStatus("��֧��");
		
		try {
			//��Ӷ�������������
			Orders orders = controller.addOrder(order);
			System.out.println(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
