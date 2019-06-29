package com.example.main.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.main.dto.PublicationDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PUBLICACION")
public class Publication implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PUBLICACION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long publicationId;
	
	@Column(name="TITULO")
	private String title;
	
	@Column(name="FECHA_PUBLICACION")
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_AUTOR")
	private Author author;
	
	public Publication(PublicationDTO dto, Author author) {
		this.publicationId = dto.getPublicationId();
		this.title = dto.getTitle();
		this.publicationDate = dto.getPublicationDate();
		this.author = author;
	}
}