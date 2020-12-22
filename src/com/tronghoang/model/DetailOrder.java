package com.tronghoang.model;

public class DetailOrder {
	private int iddetailorder;
	private Order idorder;
	private Product product;
	private int amount;
	private float total_product;
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIddetailorder() {
		return iddetailorder;
	}

	public void setIddetailorder(int iddetailorder) {
		this.iddetailorder = iddetailorder;
	}

	public Order getIdorder() {
		return idorder;
	}

	public void setIdorder(Order idorder) {
		this.idorder = idorder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getTotal_product() {
		return total_product;
	}

	public void setTotal_product(float total_product) {
		this.total_product = total_product;
	}
	

}
