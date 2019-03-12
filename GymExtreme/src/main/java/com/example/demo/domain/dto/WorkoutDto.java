package com.example.demo.domain.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class WorkoutDto {
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateWorkout;
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date startTime;
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date endTime;
	private double price;
	private Long member_id;
	private Long trainer_id;
	private Long operator_id;
	
	public WorkoutDto() {
		super();
	}

	public WorkoutDto(Date dateWorkout, Date startTime, Date endTime, double price, Long member_id, Long operator_id) {
		super();
		this.dateWorkout = dateWorkout;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.member_id = member_id;
		this.operator_id = operator_id;
	}

	public WorkoutDto(Date dateWorkout, Date startTime, Date endTime, double price, Long member_id, Long trainer_id,
			Long operator_id) {
		super();
		this.dateWorkout = dateWorkout;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.member_id = member_id;
		this.trainer_id = trainer_id;
		this.operator_id = operator_id;
	}

	public WorkoutDto(Date dateWorkout, Date startTime, Date endTime, double price, Long trainer_id) {
		super();
		this.dateWorkout = dateWorkout;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.trainer_id = trainer_id;
	}

	public Date getDateWorkout() {
		return dateWorkout;
	}

	public void setDateWorkout(Date dateWorkout) {
		this.dateWorkout = dateWorkout;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getMember_id() {
		return member_id;
	}

	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}

	public Long getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(Long trainer_id) {
		this.trainer_id = trainer_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Long getOperator_id() {
		return operator_id;
	}

	public void setOperator_id(Long operator_id) {
		this.operator_id = operator_id;
	}

	@Override
	public String toString() {
		return "WorkoutDto [dateWorkout=" + dateWorkout + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", price=" + price + ", member_id=" + member_id + ", trainer_id=" + trainer_id + ", operator_id="
				+ operator_id + "]";
	}

}
