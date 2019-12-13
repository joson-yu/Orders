package com.joson.service;

import java.util.List;
import com.joson.domain.Orders;
import com.joson.domain.Product;

/*
 * service��������Ľӿ�
 */
public interface OrderService {
	/*
	 * ��ѯ���еĶ���
	 */
	List<Orders> findAllOrder();
	
	/*
	 * �������������һ������
	 */
	void addOrder(Orders order);
	
	/*
	 * ���ݶ���id���Ҷ�����Ϣ
	 */
	Orders findById(Integer oid);
	
	/*
	 * �ڶ���id��ɾ��һ����Ʒ
	 */
	Orders deleteOrderProduct(Integer oId,String proName);
	
	/*
	 * �ڶ���id�����һ����Ʒ
	 */
	void addOrderProduct(Integer oId,Product product);
	
	/*
	 * ɾ������ʱ���������Ʒȫ�����
	 */
	void deleteOrder(Integer oId);
	
}
