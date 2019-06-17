package com.example.main.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.main.dto.AuthorDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="AUTOR")
public class Author implements Serializable{	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AUTOR")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long authorId;
	
	@Column(name="NOMBRE")
	private String name;
	
	@Column(name="APELLIDO")
	private String lastname;
	
	@Column(name="FECHA_NACIMIENTO")
	@Temporal(TemporalType.DATE)
	private Date birthDate;	
	
	@ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_NACIONALIDAD")
	private Nacionality nacionality;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="author")
	private List<Publication> publicaciones = new ArrayList<Publication>();	
	
	public Author(AuthorDTO dto, Nacionality nacionality) {
		this.name = dto.getName();
		this.lastname = dto.getLastname();
		this.birthDate = dto.getBirthDate();
		this.nacionality = nacionality;
	}

}
