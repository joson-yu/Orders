package com.joson.service;

import java.util.List;

import com.joson.domain.Orders;
import com.joson.domain.Product;


public interface ProductService {

	/*
	 *  ��ѯ���е���Ʒ
	 */
	List<Product> findAllProducts();
	
	/*
	 * ����Ʒ�������һ����Ʒ
	 */
	void addProduct(Product product);
	
	/*
	 * ������Ʒ������
	 */
	void updateProduct(Product product);
	
	/*
	 * ���ݶ�����Ӳ�Ʒ
	 */
	void addByOrder(Orders order,List<Product> products);
	
	/*
	 * ��������ɾ����Ʒ
	 */
	void removeProduct(Integer proId);
	
	
	/*
	 * �������Ʋ鵽�û�
	 */
	Product findByName(Integer orderId,String proName);
	
	/*
	 * ����oidɾ��������Ʒ
	 */
	void deleteProductByOid(Integer orderId);
}
