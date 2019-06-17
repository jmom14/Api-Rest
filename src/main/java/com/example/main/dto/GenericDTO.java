package com.example.main.dto;

import java.io.Serializable;

public class GenericDTO<T> implements Serializable {

	private static final long serialVersionUID = 7025993368158557934L;
	
	private T object;
	
	private boolean error;
	private String message;
	
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
