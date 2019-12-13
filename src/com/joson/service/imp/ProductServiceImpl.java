package com.joson.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joson.dao.ProductDao;
import com.joson.domain.Orders;
import com.joson.domain.Product;
import com.joson.service.ProductService;

/*
 * service的接口实现
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDao productDao;
	
	/*
	 *  查询所有的商品
	 */
	@Override
	public List<Product> findAllProducts() {
		return productDao.findAllProducts();
	}

	/*
	 * 在商品表中添加一个商品
	 */
	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	/*
	 * 更新商品的名称
	 */
	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}
	
	/*
	 * 根据orderID添加商品
	 */
	@Override
	public void addByOrder(Orders order,List<Product> products) {
		//获取订单的id
		Integer orderid = order.getOrderId();
		for(Product product:products) {
			//将订单id给每个产品
			product.setProductOid(orderid);
			//将产品添加到产品表中
			addProduct(product);
		}
	}
	
	/*
	 * 根据名称删除商品
	 */
	@Override
	public void removeProduct(Integer proId) {
		productDao.deleteProduct(proId);
	}

	/*
	 * 根据名称查询商品
	 */
	@Override
	public Product findByName(Integer orderId,String proName) {
		return productDao.findByName(orderId,proName);
	}

	/*
	 * 根据oid删除所有商品
	 */
	@Override
	public void deleteProductByOid(Integer orderId) {
		productDao.deleteProducts(orderId);
	}
}
