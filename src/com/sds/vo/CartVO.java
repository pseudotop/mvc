package com.sds.vo;

public class CartVO {

	CustomerVO customer = new CustomerVO();
	ItemVO item = new ItemVO();
	private int quantity;

	public CartVO() {
		super();
	}

	public CartVO(CustomerVO customer, ItemVO item, int quantity) {
		this.customer = customer;
		this.item = item;
		this.quantity = quantity;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public ItemVO getItem() {
		return item;
	}

	public void setItem(ItemVO item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartVO [customer=" + customer + ", item=" + item + ", quantity=" + quantity + "]";
	}

}
