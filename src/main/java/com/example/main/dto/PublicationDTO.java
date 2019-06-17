package com.example.main.dto;

import java.io.Serializable;
import java.util.Date;

import com.example.main.entities.Publication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long publicationId;
	private String title;
	private Date publicationDate;
	private long authorId;
	
	public PublicationDTO(Publication publication) {
		this.title = publication.getTitle();
		this.publicationDate = publication.getPublicationDate();
		this.authorId = publication.getAuthor().getAuthorId();
	}

}
