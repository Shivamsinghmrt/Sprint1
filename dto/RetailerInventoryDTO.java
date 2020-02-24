package com.capgemini.go.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RetailerInventoryDTO {
	String retailerID;
	String productCategory;
	String productID;
	String productUniqueID;
	Timestamp productReceiveTimeStamp;
	Timestamp productSaleTimeStamp;
	public RetailerInventoryDTO(String retailerID, String productCategory, String productID, String productUniqueID,
			Timestamp productReceiveTimeStamp, Timestamp productSaleTimeStamp) {
		super();
		this.retailerID = retailerID;
		this.productCategory = productCategory;
		this.productID = productID;
		this.productUniqueID = productUniqueID;
		this.productReceiveTimeStamp = productReceiveTimeStamp;
		this.productSaleTimeStamp = productSaleTimeStamp;
	}
public	RetailerInventoryDTO()
{}
	@Override
	public String toString() {
		return "[R_ID=" + retailerID + ", p_Cat=" + productCategory
				+ ", p_ID=" + productID + ", p_UniqueID=" + productUniqueID + ", p_RTS="
				+ productReceiveTimeStamp + ", p_STS=" + productSaleTimeStamp + "]";
	}
	public String getRetailerID() {
		return retailerID;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public String getProductID() {
		return productID;
	}
	public String getProductUniqueID() {
		return productUniqueID;
	}
	public Timestamp getProductReceiveTimeStamp() {
		return productReceiveTimeStamp;
	}
	public Timestamp getProductSaleTimeStamp() {
		return productSaleTimeStamp;
	}
	public void setRetailerID(String retailerID) {
		this.retailerID = retailerID;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public void setProductUniqueID(String productUniqueID) {
		this.productUniqueID = productUniqueID;
	}
	public void setProductReceiveTimeStamp(Timestamp timestamp) {
		this.productReceiveTimeStamp = timestamp;
	}
	public void setProductSaleTimeStamp(Timestamp productSaleTimeStamp) {
		this.productSaleTimeStamp = productSaleTimeStamp;
	}
	
	
}
	
