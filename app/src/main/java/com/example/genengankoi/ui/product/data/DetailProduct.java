package com.example.genengankoi.ui.product.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailProduct{
	@SerializedName("product")
	private Product product;

	@SerializedName("products")
	private List<ProductsItem> products;

	public Product getProduct(){
		return product;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}
}