package com.example.reponsemessage;

import java.util.List;

import lombok.Data;

@Data
public class reponsemessage {

	Integer status;
	String header;
	String message;
	Object data;
	List<?> allData;
	public reponsemessage(Integer status, String header, String message) {
		super();
		this.status = status;
		this.header = header;
		this.message = message;
	}
	public reponsemessage(Integer status, String header, String message, Object data) {
		super();
		this.status = status;
		this.header = header;
		this.message = message;
		this.data = data;
	}
	public reponsemessage(Integer status, String header, String message, List<?> allData) {
		super();
		this.status = status;
		this.header = header;
		this.message = message;
		this.allData = allData;
	}
	
	
}
