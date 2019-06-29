package com.example.main.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.main.entities.Author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private long idAutor;
	private String name;
	private String lastname;
	private Date birthDate;
	private Long nacionalityId;
	
	public AuthorDTO(Author author){
		this.idAutor = author.getAuthorId();
		this.name = author.getName();
		this.lastname = author.getLastname();
		this.birthDate = author.getBirthDate();
		this.nacionalityId = author.getNacionality().getNacionalityId();				
	}	
}