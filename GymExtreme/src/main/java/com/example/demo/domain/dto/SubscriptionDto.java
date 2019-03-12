package com.example.demo.domain.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SubscriptionDto {
	
	private String subType;	
	private double price;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date validFrom;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date validTo;
	
	public SubscriptionDto() {
		super();
	}

	public SubscriptionDto(String subType, double price, Date validFrom, Date validTo) {
		super();
		this.subType = subType;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	
	@Override
	public String toString() {
		return "SubscriptionDto [subType=" + subType + ", price=" + price + ", validFrom=" + validFrom + ", validTo="
				+ validTo + "]";
	}
	
}
