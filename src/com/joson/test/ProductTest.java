package com.joson.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joson.domain.Product;
import com.joson.service.ProductService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ProductTest {
	
	
	@Autowired
	ProductService productServiceImpl;
	/*
	 * ��ѯ����
	 */
	@Test
	public void testfindAll(){
		List<Product> products = productServiceImpl.findAllProducts();
		for(Product product:products) {
			System.out.println(product);
		}
	}
	
	/*
	 * �����Ʒ
	 */
	@Test
	public void testaddProduct() {
		Product product = new Product();
		product.setProductName("�յ�");
		product.setProductOid(1);
		product.setProductPrice(2350d);
		product.setProductSum(1341);
		product.setProductType("�ҵ�");
		product.setProductStatus("����");
		
		productServiceImpl.addProduct(product);
		
	}
	
	/*
	 * ������Ʒ����
	 */
	@Test
	public void testupdate(){
		Product product = new Product();
		product.setProductId(2);
		product.setProductName("����");
		
		productServiceImpl.updateProduct(product);
	}
	
	/*
	 * ��������ɾ����Ʒ
	 */
	@Test
	public void testDeleteByName() {
		productServiceImpl.removeProduct(1);
	}
	/*
	 * �������Ʋ�ѯ��Ʒ
	 */
	@Test
	public void testfindByName() {
		Product product =productServiceImpl.findByName(1,"����");
		System.out.println(product);
	}
	
}
