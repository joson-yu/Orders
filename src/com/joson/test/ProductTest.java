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
	 * 查询所有
	 */
	@Test
	public void testfindAll(){
		List<Product> products = productServiceImpl.findAllProducts();
		for(Product product:products) {
			System.out.println(product);
		}
	}
	
	/*
	 * 添加商品
	 */
	@Test
	public void testaddProduct() {
		Product product = new Product();
		product.setProductName("空调");
		product.setProductOid(1);
		product.setProductPrice(2350d);
		product.setProductSum(1341);
		product.setProductType("家电");
		product.setProductStatus("正常");
		
		productServiceImpl.addProduct(product);
		
	}
	
	/*
	 * 更新商品名称
	 */
	@Test
	public void testupdate(){
		Product product = new Product();
		product.setProductId(2);
		product.setProductName("电脑");
		
		productServiceImpl.updateProduct(product);
	}
	
	/*
	 * 根据名称删除商品
	 */
	@Test
	public void testDeleteByName() {
		productServiceImpl.removeProduct(1);
	}
	/*
	 * 根据名称查询商品
	 */
	@Test
	public void testfindByName() {
		Product product =productServiceImpl.findByName(1,"篮球");
		System.out.println(product);
	}
	
}
