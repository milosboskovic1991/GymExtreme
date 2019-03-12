package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="workout")
public class Workout {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name="date_workout", nullable=false)
	private Date dateWorkout;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(name="start_time", nullable=false)
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	@Column(name="end_time", nullable=false)
	private Date endTime;
	
	@Column(name="price", nullable=false)
	private double price=0.0;	
	
	@ManyToOne(targetEntity=Member.class)
	@JoinColumn(name="member_id", foreignKey=@ForeignKey(name="fk_member"))
	@JsonIgnoreProperties({"id","email","subscription"})
	private Member member;
	
	@ManyToOne(targetEntity=Trainer.class)
	@JoinColumn(name="trainer_id", foreignKey=@ForeignKey(name="fk_trainer"))
	@JsonIgnoreProperties({"id","price","workouts"})
	private Trainer trainer;
	
	@ManyToOne(targetEntity=Operator.class)
	@JoinColumn(name="operator_id", foreignKey=@ForeignKey(name="fk_operator"))
	@JsonIgnoreProperties({"id","email","operatorPassword"})
	private Operator operator;

	public Workout() {
		super();
	}

	public Workout(Date dateWorkout, Date startTime, Date endTime, double price, Member member, Operator operator) {
		super();
		this.dateWorkout = dateWorkout;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.member = member;
		this.operator = operator;
	}

	public Workout(Date dateWorkout, Date startTime, Date endTime, double price, Member member, Trainer trainer,
			Operator operator) {
		super();
		this.dateWorkout = dateWorkout;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.member = member;
		this.trainer = trainer;
		this.operator = operator;
	}

	public Workout(Long id, Date dateWorkout, Date startTime, Date endTime, double price, Member member,
			Operator operator) {
		super();
		this.id = id;
		this.dateWorkout = dateWorkout;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.member = member;
		this.operator = operator;
	}
	
	public Workout(Long id, Date dateWorkout, Date startTime, Date endTime, double price, Member member,
			Trainer trainer, Operator operator) {
		super();
		this.id = id;
		this.dateWorkout = dateWorkout;
		this.startTime = startTime;
		this.endTime = endTime;
		this.price = price;
		this.member = member;
		this.trainer = trainer;
		this.operator = operator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "Workout [id=" + id + ", dateWorkout=" + dateWorkout + ", startTime=" + startTime + ", endTime="
				+ endTime + ", price=" + price + ", member=" + member + ", trainer=" + trainer + ", operator="
				+ operator + "]";
	}

	

	
}
