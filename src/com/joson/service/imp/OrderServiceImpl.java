package com.joson.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joson.dao.OrderDao;
import com.joson.domain.Orders;
import com.joson.domain.Product;
import com.joson.service.OrderService;
import com.joson.service.ProductService;

/*
 * service�㶩��ʵ����
 */
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductService productServiceimpl;
	
	/*
	 * ��ѯ���еĶ���
	 */
	@Override
	public List<Orders> findAllOrder() {
		return orderDao.findAllOrder();
	}
	
	/*
	 * ���ݶ���id���Ҷ�����Ϣ
	 */
	@Override
	public Orders findById(Integer oid) {
		return orderDao.findById(oid);
	}
	
	/*
	 * �������������һ������
	 */
	@Override
	public void addOrder(Orders order) {
		//��������ӵ�������
		orderDao.addOrder(order);
		//����Ʒ���ݶ���id��ӵ�������
		productServiceimpl.addByOrder(order, order.getoProducts());
	}
	
	/*
	 * �ڶ���id��ɾ��һ����Ʒ
	 */
	@Override
	public Orders deleteOrderProduct(Integer oId,String proName) {
		//���ݶ���id��ȡ������Ϣ
		Orders tempOrder = orderDao.findById(oId);
		//���ݶ���id����Ʒ���ƻ����Ʒ��Ϣ
		Product product = productServiceimpl.findByName(tempOrder.getOrderId(),proName);
		//����Ʒ�嶩�����Ƴ�
		productServiceimpl.removeProduct(product.getProductId());
		//���¶������
		tempOrder.setOrderTotalMoney(tempOrder.getOrderTotalMoney() - product.getProductPrice());
		//���¶���
		orderDao.updateProduct(tempOrder);
		return tempOrder;
	}
	
	
	/*
	 * �ڶ���id�����һ����Ʒ
	 */
	@Override
	public void addOrderProduct(Integer oId, Product product) {
		List<Product> pList = new ArrayList<Product>();
		pList.add(product);
		//���ݶ���id��ȡ������Ϣ
		Orders tempOrder = orderDao.findById(oId);
		//�򶩵������һ����Ʒ
		tempOrder.setoProducts(pList);
		//���¶������
		tempOrder.setOrderTotalMoney(product.getProductPrice()+tempOrder.getOrderTotalMoney());
		//����Ʒ��ӵ���Ʒ��
		productServiceimpl.addProduct(product);
		//���¶���
		orderDao.updateProduct(tempOrder);
	}

	/*
	 * ɾ������ʱ���������Ʒȫ�����
	 */
	@Override
	public void deleteOrder(Integer oId) {
		//��ն����е���Ʒ
		productServiceimpl.deleteProductByOid(oId);
		//��ն���
		orderDao.deleteOrder(oId);
	}
}
