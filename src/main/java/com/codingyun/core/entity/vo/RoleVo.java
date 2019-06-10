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
@Table(name = "role")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class RoleVo {

     private Integer roleId;
     private String roleName="";
     private String roleDescription="";

	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name ="role_id",nullable=false)
     public Integer getRoleId() {
 		return roleId;
 	}

 	public void setRoleId(Integer roleId) {
 		this.roleId = roleId;
 	}
     
	@Column(name ="role_name",nullable=true,length=20)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name ="role_description",nullable=true,length=500)
	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}
