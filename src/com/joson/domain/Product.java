package com.joson.domain;

/*
 * ��Ʒ��ʵ����
 */
public class Product {
	private Integer productId;           //��ƷID
	private Integer productOid;           //��ƷID
	private String productName;         //��Ʒ����
	private Double productPrice;		//��Ʒԭ�۸�
	private Integer productSum;			//��Ʒ����
	private String productType;			//��Ʒ����
	private String productStatus;		//��Ʒ״̬
	private Orders pOrders;					//������ӳ��
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
