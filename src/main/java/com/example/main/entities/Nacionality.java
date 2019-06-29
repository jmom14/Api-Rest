package com.example.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.main.dto.NacionalityDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NACIONALIDAD")
public class Nacionality implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_NACIONALIDAD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nacionalityId;

	@Column(name = "PAIS")
	private String country;

	@Column(name = "NACIONALIDAD")
	private String nacionality;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "nacionality")
	private List<Author> autores = new ArrayList<Author>();
	
	public Nacionality(NacionalityDTO dto) {
		this.country = dto.getCountry();
		this.nacionality = dto.getNacionality();
	}
}