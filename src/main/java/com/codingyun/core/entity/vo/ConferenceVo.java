package com.codingyun.core.entity.vo;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "conference")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ConferenceVo {
  
	private int id;
	private String subject;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hour;
	private String site;
	private String person;
	private int state;

	public ConferenceVo(){}

	public ConferenceVo(int id, String subject, Date hour, String site, String person, int state){
		this.id = id;
		this.subject = subject;
		this.hour = hour;
		this.site = site;
		this.person = person;
		this.state = state;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Column(name="subject",nullable=true)
	public String getSubject(){
		return subject;
	}

	public void setSubject(String subject){
		this.subject = subject;
	}

	@Column(name="hour",nullable=true)
	public Date getHour() {
		return hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

	@Column(name="site",nullable=true)
	public String getSite(){
		return site;
	}

	public void setSite(String site){
		this.site = site;
	}

	@Column(name="person",nullable=true)
	public String getPerson(){
		return person;
	}

	public void setPerson(String person){
		this.person = person;
	}
	
	@Column(name="state",nullable=true)
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
