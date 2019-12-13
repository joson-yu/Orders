package com.joson.service;

import java.util.List;

import com.joson.domain.Orders;
import com.joson.domain.Product;


public interface ProductService {

	/*
	 *  查询所有的商品
	 */
	List<Product> findAllProducts();
	
	/*
	 * 在商品表中添加一个商品
	 */
	void addProduct(Product product);
	
	/*
	 * 更新商品的名称
	 */
	void updateProduct(Product product);
	
	/*
	 * 根据订单添加产品
	 */
	void addByOrder(Orders order,List<Product> products);
	
	/*
	 * 根据名称删除商品
	 */
	void removeProduct(Integer proId);
	
	
	/*
	 * 根据名称查到用户
	 */
	Product findByName(Integer orderId,String proName);
	
	/*
	 * 根据oid删除所有商品
	 */
	void deleteProductByOid(Integer orderId);
}
