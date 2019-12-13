package com.joson.domain;

/*
 * 产品的实体类
 */
public class Product {
	private Integer productId;           //产品ID
	private Integer productOid;           //产品ID
	private String productName;         //产品名称
	private Double productPrice;		//产品原价格
	private Integer productSum;			//产品销量
	private String productType;			//产品类型
	private String productStatus;		//产品状态
	private Orders pOrders;					//订单的映射
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductOid() {
		return productOid;
	}
	public void setProductOid(Integer productOid) {
		this.productOid = productOid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductSum() {
		return productSum;
	}
	public void setProductSum(Integer productSum) {
		this.productSum = productSum;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public Orders getpOrders() {
		return pOrders;
	}
	public void setpOrders(Orders pOrders) {
		this.pOrders = pOrders;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productOid=" + productOid + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productSum=" + productSum + ", productType=" + productType
				+ ", productStatus=" + productStatus + ", pOrders=" + pOrders + "]";
	}


	
}
