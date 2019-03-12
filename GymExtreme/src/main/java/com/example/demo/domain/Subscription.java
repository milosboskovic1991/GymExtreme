package com.example.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="subscription")
public class Subscription {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="sub_type", nullable=false)
	private String subType;
	
	@Column(name="price", nullable=false)
	private double price;

	@Column(name="valid_from", nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date validFrom;
	
	@Column(name="valid_to", nullable=false)
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date validTo;
	
	@OneToMany(targetEntity=Member.class,mappedBy="subscription")
	@JsonBackReference //prevents recursion 
	private List<Member> members = new ArrayList<Member>();

	public Subscription() {
		super();
	}

	public Subscription(Long id, String subType, double price, Date validFrom, Date validTo, List<Member> members) {
		super();
		this.id = id;
		this.subType = subType;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.members = members;
	}

	public Subscription(Long id, String subType, double price, Date validFrom, Date validTo) {
		super();
		this.id = id;
		this.subType = subType;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public Subscription(String subType, double price, Date validFrom, Date validTo, List<Member> members) {
		super();
		this.subType = subType;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.members = members;
	}

	public Subscription(String subType, double price, Date validFrom, Date validTo) {
		super();
		this.subType = subType;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", subType=" + subType + ", price=" + price + ", validFrom=" + validFrom + ", validTo=" + validTo + ", members=" + members + "]";
	}
		
}
