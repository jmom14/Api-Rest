package com.example.main.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class GenericDTO<T> implements Serializable {

	private static final long serialVersionUID = 7025993368158557934L;
	
	private T object;
	private boolean error;
	private String message;
}