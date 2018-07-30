package com.retail.ecom.checkout.pojo;

public class Inventory {
	
	private String id;
	private int inventoryCount;
	private int reservationID;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getInventoryCount() {
		return inventoryCount;
	}
	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}
	public int getReservationID() {
		return reservationID;
	}
	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}
}
