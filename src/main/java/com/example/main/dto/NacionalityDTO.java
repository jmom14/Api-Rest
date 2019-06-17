package com.example.main.dto;

import java.io.Serializable;

import com.example.main.entities.Nacionality;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NacionalityDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long nacionalityId;
	private String nacionality;
	private String country;
	
	public NacionalityDTO(Nacionality nacionality) {
		this.nacionalityId = nacionality.getNacionalityId();
		this.nacionality = nacionality.getNacionality();
		this.country = nacionality.getCountry();
	}
	
}
