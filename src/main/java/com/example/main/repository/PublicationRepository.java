package com.example.main.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.main.entities.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
	
	Page<Publication> findAll(Pageable pageable);	
}