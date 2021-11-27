package com.example.genengankoi.ui.product.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResponse{
	@SerializedName("productResponse")
	private List<ProductResponseItem> productResponse;

	public List<ProductResponseItem> getProductResponse(){
		return productResponse;
	}
}