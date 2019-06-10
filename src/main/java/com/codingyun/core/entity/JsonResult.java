package com.codingyun.core.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;
/**
 * 返回前台的json数据
 */
@Service
public class JsonResult implements Serializable{

	private static final long serialVersionUID = 4273005680206220420L;

	public JsonResult(){}

	public JsonResult(int resultCode, String resultMessage, Object data){
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.data = data;
	}

	public JsonResult(int resultCode, String resultMessage){
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}

	public JsonResult setCM(int resultCode, String resultMessage){
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		return this;
	}

	public JsonResult setCMD(int resultCode, String resultMessage, Object data){
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.data = data;
		return this;
	}

	/**
	 * 返回结果码
	 * 0成功，非0失败
	 */
	private int resultCode;
	/**
	 * 操作结果信息
	 */
	private String resultMessage = "获取数据成功";

	/**
	 * 返回的数据
	 */
	private Object data;
	
	
	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
