package com.joson.domain;

import java.util.Date;
import java.util.List;

/*
 * ����ʵ����
 */
public class Orders {
	private Integer orderId;			//����ID
	private Double orderTotalMoney;		//�ܼƽ��
	private Date orderTime;				//�µ�ʱ��
	private String orderStatus;			//����״̬
	private String orderDetail;			//��������
	private List<Product> oProducts;	//�Ͳ�Ʒһ�Զ�ӳ��
	
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
