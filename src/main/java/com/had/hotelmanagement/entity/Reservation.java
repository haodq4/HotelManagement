package com.had.hotelmanagement.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	private int reservationid;
	private int customerid;
	private int roomtypeid;
	private Date expectedcheckdate;
	private int expectedroom;
	private double isdeposit;
	private String reservationstatus;
	
	public Reservation() {
	}

	public Reservation(int reservationid, int customerid, int roomtypeid, Date expectedcheckdate, int expectedroom,
			double isdeposit, String reservationstatus) {
		super();
		this.reservationid = reservationid;
		this.customerid = customerid;
		this.roomtypeid = roomtypeid;
		this.expectedcheckdate = expectedcheckdate;
		this.expectedroom = expectedroom;
		this.isdeposit = isdeposit;
		this.reservationstatus = reservationstatus;
	}
	
	

	@Override
	public String toString() {
		return "Reservation [reservationid=" + reservationid + ", customerid=" + customerid + ", roomtypeid="
				+ roomtypeid + ", expectedcheckdate=" + expectedcheckdate + ", expectedroom=" + expectedroom
				+ ", isdeposit=" + isdeposit + ", reservationstatus=" + reservationstatus + "]";
	}

	public int getReservationid() {
		return reservationid;
	}

	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getRoomtypeid() {
		return roomtypeid;
	}

	public void setRoomtypeid(int roomtypeid) {
		this.roomtypeid = roomtypeid;
	}

	public Date getExpectedcheckdate() {
		return expectedcheckdate;
	}

	public void setExpectedcheckdate(Date expectedcheckdate) {
		this.expectedcheckdate = expectedcheckdate;
	}

	public int getExpectedroom() {
		return expectedroom;
	}

	public void setExpectedroom(int expectedroom) {
		this.expectedroom = expectedroom;
	}

	public double getIsdeposit() {
		return isdeposit;
	}

	public void setIsdeposit(double isdeposit) {
		this.isdeposit = isdeposit;
	}

	public String getReservationstatus() {
		return reservationstatus;
	}

	public void setReservationstatus(String reservationstatus) {
		this.reservationstatus = reservationstatus;
	}

	
}
