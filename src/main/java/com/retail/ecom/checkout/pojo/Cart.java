package com.retail.ecom.checkout.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private int id;
	private List<Offer> itemList ;
	private String status;
	private int paymentId;
	public List<Offer> getItemList() {
		if(null==itemList)
		{
			itemList=new ArrayList<Offer>();
		}
		return itemList;
	}
	public void setItemList(List<Offer> itemList) {
		this.itemList = itemList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
}
