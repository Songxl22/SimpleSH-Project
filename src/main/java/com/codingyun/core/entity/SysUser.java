package com.codingyun.core.entity;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable{
	
	private int id;
	private int empno;
	private String name;
	private String pwd;
	private int position;
	private String dept;
	private String sex;
	private String natives;
	private Date birth;
	private String email;
	private String tel;
	private String quan;
	private String nativeplace;
	private String address;
	private String idnum;
	private String pols;
	private String createuser;
	private Date createtime;
	private String updateuser;
	private Date updatetime;
	
	
	public SysUser(int id, int empno, String name, String pwd, int position, String dept, String sex, String natives,
			Date birth, String email, String tel, String quan, String nativeplace, String address, String idnum,
			String pols, String createuser, Date createtime, String updateuser, Date updatetime) {
		super();
		this.id = id;
		this.empno = empno;
		this.name = name;
		this.pwd = pwd;
		this.position = position;
		this.dept = dept;
		this.sex = sex;
		this.natives = natives;
		this.birth = birth;
		this.email = email;
		this.tel = tel;
		this.quan = quan;
		this.nativeplace = nativeplace;
		this.address = address;
		this.idnum = idnum;
		this.pols = pols;
		this.createuser = createuser;
		this.createtime = createtime;
		this.updateuser = updateuser;
		this.updatetime = updatetime;
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getNatives() {
		return natives;
	}


	public void setNatives(String natives) {
		this.natives = natives;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getQuan() {
		return quan;
	}


	public void setQuan(String quan) {
		this.quan = quan;
	}


	public String getNativeplace() {
		return nativeplace;
	}


	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getIdnum() {
		return idnum;
	}


	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}


	public String getPols() {
		return pols;
	}


	public void setPols(String pols) {
		this.pols = pols;
	}


	public String getCreateuser() {
		return createuser;
	}


	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public String getUpdateuser() {
		return updateuser;
	}


	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}


	public Date getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	
	
	

}
