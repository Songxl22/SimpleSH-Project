package com.codingyun.core.entity.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "leave_manage")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class LeaveVo {
	private int leaveId;
	private int leaveType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endTime;
	private String reason="";
	private String applyName="";
	private int status;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="leave_id",nullable=false)
	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	@Column(name ="leave_type",nullable=true)
	public Integer getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(int leaveType) {
		this.leaveType = leaveType;
	}

	@Column(name ="start_time",nullable=true)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@Column(name ="end_time",nullable=true)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Column(name ="reason",nullable=true,length=50)
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name ="apply_name",nullable=true,length=20)
	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}

	@Column(name ="status",nullable=true)
	public Integer getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}