package com.codingyun.core.entity.vo;


import org.hibernate.dialect.SQLServer2008Dialect;

public class NewSQLServer2008Dialect extends SQLServer2008Dialect{
public NewSQLServer2008Dialect(){
	super();
	registerHibernateType(1, "string");   
    registerHibernateType(-9, "string");   
    registerHibernateType(-16, "string");   
    registerHibernateType(3, "double"); 
}
}
