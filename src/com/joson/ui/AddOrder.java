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
 * 测试：添加订单和商品
 */
public class AddOrder {
	public static void main(String[] args) {
		//获取配置文件和控制层对象
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderController controller = ac.getBean(OrderController.class);
		//创建订单和商品
		Orders order = new Orders();
		List<Product> productsList = new ArrayList<Product>();
		Product product1 = new Product();
		Product product2 = new Product();
		
		product1.setProductName("钢琴");
		product1.setProductPrice(1500d);
		product1.setProductSum(8000);
		product1.setProductType("乐器");
		product1.setProductStatus("正常");
		
		product2.setProductName("吉他");
		product2.setProductPrice(500d);
		product2.setProductSum(33440);
		product2.setProductType("乐器");
		product2.setProductStatus("正常");
		
		//将商品添加到集合中
		productsList.add(product1);
		productsList.add(product2);
		
		order.setOrderId(1);
		order.setOrderTotalMoney(product1.getProductPrice()+product2.getProductPrice());
		order.setoProducts(productsList);
		order.setOrderTime(new Date());
		order.setOrderStatus("已支付");
		
		try {
			//添加订单到订单表中
			Orders orders = controller.addOrder(order);
			System.out.println(orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
