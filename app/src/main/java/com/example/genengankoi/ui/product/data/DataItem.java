package com.example.genengankoi.ui.product.data;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("gender")
	private String gender;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("avatar")
	private String avatar;

	@SerializedName("status2")
	private String status2;

	@SerializedName("product_name")
	private String productName;

	@SerializedName("token")
	private String token;

	@SerializedName("status1")
	private String status1;

	@SerializedName("size")
	private String size;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("price")
	private String price;

	@SerializedName("qty")
	private String qty;

	@SerializedName("admin_id")
	private int adminId;

	@SerializedName("id")
	private int id;

	public String getGender(){
		return gender;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public String getAvatar(){
		return avatar;
	}

	public String getStatus2(){
		return status2;
	}

	public String getProductName(){
		return productName;
	}

	public String getToken(){
		return token;
	}

	public String getStatus1(){
		return status1;
	}

	public String getSize(){
		return size;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getPrice(){
		return price;
	}

	public String getQty(){
		return qty;
	}

	public int getAdminId(){
		return adminId;
	}

	public int getId(){
		return id;
	}
}