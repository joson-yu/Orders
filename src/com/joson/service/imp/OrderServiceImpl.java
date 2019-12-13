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
 * service层订单实现类
 */
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductService productServiceimpl;
	
	/*
	 * 查询所有的订单
	 */
	@Override
	public List<Orders> findAllOrder() {
		return orderDao.findAllOrder();
	}
	
	/*
	 * 根据订单id查找订单信息
	 */
	@Override
	public Orders findById(Integer oid) {
		return orderDao.findById(oid);
	}
	
	/*
	 * 往订单表中添加一个订单
	 */
	@Override
	public void addOrder(Orders order) {
		//将订单添加到订单表
		orderDao.addOrder(order);
		//将商品根据订单id添加到订单中
		productServiceimpl.addByOrder(order, order.getoProducts());
	}
	
	/*
	 * 在订单id中删除一个商品
	 */
	@Override
	public Orders deleteOrderProduct(Integer oId,String proName) {
		//根据订单id获取订单信息
		Orders tempOrder = orderDao.findById(oId);
		//根据订单id和商品名称获得商品信息
		Product product = productServiceimpl.findByName(tempOrder.getOrderId(),proName);
		//将商品冲订单中移除
		productServiceimpl.removeProduct(product.getProductId());
		//更新订单金额
		tempOrder.setOrderTotalMoney(tempOrder.getOrderTotalMoney() - product.getProductPrice());
		//跟新订单
		orderDao.updateProduct(tempOrder);
		return tempOrder;
	}
	
	
	/*
	 * 在订单id中添加一个商品
	 */
	@Override
	public void addOrderProduct(Integer oId, Product product) {
		List<Product> pList = new ArrayList<Product>();
		pList.add(product);
		//根据订单id获取订单信息
		Orders tempOrder = orderDao.findById(oId);
		//向订单中添加一个商品
		tempOrder.setoProducts(pList);
		//更新订单金额
		tempOrder.setOrderTotalMoney(product.getProductPrice()+tempOrder.getOrderTotalMoney());
		//将产品添加到产品表
		productServiceimpl.addProduct(product);
		//更新订单
		orderDao.updateProduct(tempOrder);
	}

	/*
	 * 删除订单时，里面的商品全部清空
	 */
	@Override
	public void deleteOrder(Integer oId) {
		//清空订单中的商品
		productServiceimpl.deleteProductByOid(oId);
		//清空订单
		orderDao.deleteOrder(oId);
	}
}
