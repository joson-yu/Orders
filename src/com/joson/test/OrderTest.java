package com.joson.test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.joson.domain.Orders;
import com.joson.domain.Product;
import com.joson.service.OrderService;

/*
 * ������Ĳ��Է���
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderTest {
	
	@Autowired
	OrderService orderServiceImpl;
	
	/*
	 * ���ԣ���ѯ����
	 */
	@Test
	public void testfindAll(){
		//��ѯ
		List<Orders> orders = orderServiceImpl.findAllOrder();
		for(Orders order:orders) {
			System.out.println(order);
		}
	}
	
	/*
	 * ���ԣ����ݶ���IDֵ���ҵ�����
	 */
	@Test
	public void testfindById() {
		Orders orders = orderServiceImpl.findById(1);
		System.out.println(orders);
	}
	
	/*
	 *  ���ԣ���Ӷ�������Ʒ
	 */
	@Test
	public void testadd() {
		Orders order =new Orders();
		Product product1 = new Product();
		Product product2 = new Product();
		List<Product> pList = new ArrayList<Product>();
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
		pList.add(product1);
		pList.add(product2);
		
		order.setOrderId(3);
		order.setOrderTotalMoney(product1.getProductPrice()+product2.getProductPrice());
		order.setoProducts(pList);
		order.setOrderTime(new Date());
		order.setOrderStatus("��֧��");
		orderServiceImpl.addOrder(order);
	}

	/*
	 * ���ԣ���ĳ�����������һ����Ʒ
	 * 
	 */
	@Test
	public void testaddOrderProduct() {
		Product product = new Product();
		product.setProductName("����");
		product.setProductOid(2);
		product.setProductPrice(600d);
		product.setProductSum(9000);
		product.setProductType("�ľ�");
		product.setProductStatus("����");
		
		orderServiceImpl.addOrderProduct(product.getProductOid(), product);
	}
	
	/*
	 * ���ԣ�����֪������ɾ��ĳ����Ʒ
	 * 
	 */
	@Test
	public void testdeleteOrderProduct() {
		orderServiceImpl.deleteOrderProduct(2, "����");
	}
	
	/*
	 * ���ԣ�ɾ������ʱ���������Ʒȫ�����
	 */
	@Test
	public void testdeleteOrder() {
		orderServiceImpl.deleteOrder(2);
	}
	
}
