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
 * 订单类的测试方法
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderTest {
	
	@Autowired
	OrderService orderServiceImpl;
	
	/*
	 * 测试：查询所有
	 */
	@Test
	public void testfindAll(){
		//查询
		List<Orders> orders = orderServiceImpl.findAllOrder();
		for(Orders order:orders) {
			System.out.println(order);
		}
	}
	
	/*
	 * 测试：根据订单ID值查找到订单
	 */
	@Test
	public void testfindById() {
		Orders orders = orderServiceImpl.findById(1);
		System.out.println(orders);
	}
	
	/*
	 *  测试：添加订单和商品
	 */
	@Test
	public void testadd() {
		Orders order =new Orders();
		Product product1 = new Product();
		Product product2 = new Product();
		List<Product> pList = new ArrayList<Product>();
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
		pList.add(product1);
		pList.add(product2);
		
		order.setOrderId(3);
		order.setOrderTotalMoney(product1.getProductPrice()+product2.getProductPrice());
		order.setoProducts(pList);
		order.setOrderTime(new Date());
		order.setOrderStatus("已支付");
		orderServiceImpl.addOrder(order);
	}

	/*
	 * 测试：给某个订单中添加一个商品
	 * 
	 */
	@Test
	public void testaddOrderProduct() {
		Product product = new Product();
		product.setProductName("吉他");
		product.setProductOid(2);
		product.setProductPrice(600d);
		product.setProductSum(9000);
		product.setProductType("文具");
		product.setProductStatus("正常");
		
		orderServiceImpl.addOrderProduct(product.getProductOid(), product);
	}
	
	/*
	 * 测试：给已知订单中删除某个产品
	 * 
	 */
	@Test
	public void testdeleteOrderProduct() {
		orderServiceImpl.deleteOrderProduct(2, "钢琴");
	}
	
	/*
	 * 测试：删除订单时，里面的商品全部清空
	 */
	@Test
	public void testdeleteOrder() {
		orderServiceImpl.deleteOrder(2);
	}
	
}
