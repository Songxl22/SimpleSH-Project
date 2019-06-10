package com.codingyun.core.entity.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

	@Entity
	@Table(name = "department")
	@DynamicUpdate(true)
	@DynamicInsert(true)
	@SuppressWarnings("serial")
	public class DepartmentVo {

		private int departmentId;
		private String departmentName="";
		private String task = "";
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name ="department_id",nullable=false,length=50)
		public int getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}

		@Column(name ="department_name",nullable=true,length=50)
		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		@Column(name ="task",nullable=true,length=50)
		public String getTask() {
			return task;
		}

		public void setTask(String task) {
			this.task = task;
		}
	}
