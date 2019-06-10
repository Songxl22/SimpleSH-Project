package com.codingyun.core.entity.vo;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "announcement")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class AnnouncementVo {
	private Integer id;
	private String theme;
	private String contents;
	private String createUser;
	private Date createDate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="id",nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name ="theme",nullable=true,length=100)
	public String getTheme() {
		return theme;
	}
	
	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Column(name ="contents",nullable=true,length=500)
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Column(name ="create_user",nullable=true,length=20)
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name ="create_date",nullable=true)
	@DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
	