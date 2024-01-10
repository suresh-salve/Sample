package com.jbk.model;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ProductModel {

	private long productId;
	
	@NotBlank(message="Product name is mandatory")
	 @Pattern(regexp = "^[a-zA-Z\\s]{3,20}$",
     message = "Product name should not contain numbers and special characters")
	private String productName;
	
	@Min(1)
	private double productPrice;
	
	@Min(1)
	private int productQty;
	
	private LocalDate mfgDate;
	private LocalDate expDate;
	private LocalDate createdDate;
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductModel(long productId,
			@NotBlank(message = "Product name is mandatory") @Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Product name should not contain numbers and special characters") String productName,
			@Min(1) double productPrice, @Min(1) int productQty, LocalDate mfgDate, LocalDate expDate,
			LocalDate createdDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.createdDate = createdDate;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public LocalDate getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(LocalDate mfgDate) {
		this.mfgDate = mfgDate;
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productQty=" + productQty + ", mfgDate=" + mfgDate + ", expDate=" + expDate
				+ ", createdDate=" + createdDate + "]";
	}
	
	
	 
}
