package com.codingyun.core.entity.vo;
import java.io.Serializable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.util.Assert;

import com.codingyun.core.dao.IGenericBaseCommonDao; 

//分页请求信息
public class PagingInfo<T> implements Serializable{
	private T filters;
	private int pageNumber;
	private int pageSize;
	private String sortColumns;
	public PagingInfo(){
		this(0,0);
	}
	
	public PagingInfo(T filters){
		this(0,0,filters);
	}
	
	public PagingInfo(int pageNumber,int pageSize){
		this(pageNumber,pageSize,(T)null);
	}
	
	public PagingInfo(int pageNumber,int pageSize,T filters){
		this(pageNumber,pageSize,filters,null);
	}

	public PagingInfo(int pageNumber,int pageSize,String sortColumns){
		this(pageNumber,pageSize,null,sortColumns);
	}
	
	public PagingInfo(int pageNumber,int pageSize,T filters,String sortColumns){
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public T getFilters(){
		return filters;
	}
	public void setFilters(T filters) {
		this.filters = filters;
	}
	public int getPageNumber(){
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize(){
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortColumns() {
		return sortColumns;
	}
	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}
	
}