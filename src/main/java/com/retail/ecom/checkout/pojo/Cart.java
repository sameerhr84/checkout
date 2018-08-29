package com.retail.ecom.checkout.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private int id;
	private List<Offer> itemList ;
	private String status;
	private int paymentId;
	private Inventory inventory;
	private Payment payment;
	private String hostName;
	
	
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
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
}
