package com.joson.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joson.dao.ProductDao;
import com.joson.domain.Orders;
import com.joson.domain.Product;
import com.joson.service.ProductService;

/*
 * service�Ľӿ�ʵ��
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
	/*
	 *  ��ѯ���е���Ʒ
	 */
	@Override
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}

	/*
	 * ����Ʒ�������һ����Ʒ
	 */
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	/*
	 * ������Ʒ������
	 */
	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}
	
	/*
	 * ����orderID�����Ʒ
	 */
	@Override
	public void addByOrder(Orders order,List<Product> products) {
		//��ȡ������id
		Integer orderid = order.getOrderId();
		for(Product product:products) {
			//������id��ÿ����Ʒ
			product.setProductOid(orderid);
			//����Ʒ��ӵ���Ʒ����
			addProduct(product);
		}
	}
	
	/*
	 * ��������ɾ����Ʒ
	 */
	@Override
	public void removeProduct(Integer proId) {
		productDao.deleteProduct(proId);
	}

	/*
	 * �������Ʋ�ѯ��Ʒ
	 */
	@Override
	public Product findByName(Integer orderId,String proName) {
		return productDao.findByName(orderId,proName);
	}

	/*
	 * ����oidɾ��������Ʒ
	 */
	@Override
	public void deleteProductByOid(Integer orderId) {
		productDao.deleteProducts(orderId);
	}
}
