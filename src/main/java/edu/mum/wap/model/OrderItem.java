package edu.mum.wap.model;

import java.util.Objects;

public class OrderItem {
	private String id;
	private int productQty;
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}



	public OrderItem(String id, int productQty, Product product) {
		this.id = id;
		this.productQty = productQty;
		this.product = product;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}


	@Override
	public boolean equals(Object obj) {
		if ( obj == null || !(obj instanceof OrderItem) ) {
			return false;
		}
		OrderItem orderItem = (OrderItem) obj;
		return this.getId() == orderItem.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.getId());
	}
}
