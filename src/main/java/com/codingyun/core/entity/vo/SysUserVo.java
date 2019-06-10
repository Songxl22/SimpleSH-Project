package com.codingyun.core.entity.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

	@Entity
	@Table(name = "sys_user")
	@DynamicUpdate(true)
	@DynamicInsert(true)
	@SuppressWarnings("serial")
	public class SysUserVo {
		
	/**
	 * 用户名
	 */
	
	private Integer id;
	private String userName = "";
	private String userPass = "";
	private String type = "";

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name ="id",nullable=false)
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		@Column(name ="user_name",nullable=true,length=20)
		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		@Column(name ="user_pass",nullable=true,length=50)
		public String getUserPass() {
			return userPass;
		}

		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}

		@Column(name ="type",nullable=true)
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	
}
