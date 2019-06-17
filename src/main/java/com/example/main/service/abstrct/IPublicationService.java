package com.example.main.service.abstrct;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.main.dto.PublicationDTO;

@Service
public interface IPublicationService extends IServices<PublicationDTO>{
	
	List<PublicationDTO> getPaged(Pageable pageable);
}
