package com.codingyun.core.exception;

public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = -3418272280398021636L;
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(String message, Throwable throwable){
		super(message, throwable);
	}

}
