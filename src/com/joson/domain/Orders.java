package com.joson.domain;

import java.util.Date;
import java.util.List;

/*
 * 订单实体类
 */
public class Orders {
	private Integer orderId;			//订单ID
	private Double orderTotalMoney;		//总计金额
	private Date orderTime;				//下单时间
	private String orderStatus;			//订单状态
	private String orderDetail;			//订单详情
	private List<Product> oProducts;	//和产品一对多映射
	
	public List<Product> getoProducts() {
		return oProducts;
	}
	public void setoProducts(List<Product> oProducts) {
		this.oProducts = oProducts;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Double getOrderTotalMoney() {
		return orderTotalMoney;
	}
	public void setOrderTotalMoney(Double orderTotalMoney) {
		this.orderTotalMoney = orderTotalMoney;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderTotalMoney=" + orderTotalMoney + ", orderTime=" + orderTime
				+ ", orderStatus=" + orderStatus + ", orderDetail=" + orderDetail + ", oProducts=" + oProducts + "]";
	}

	
	
	
}
