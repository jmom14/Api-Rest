package com.example.main.service;

import java.util.List;
import com.example.main.dto.NacionalidadDTO;

public interface INacionalidadService {
	
	public NacionalidadDTO create (NacionalidadDTO nacionalidad);
	
	public boolean delete (long id);
	
	public boolean update (long id, NacionalidadDTO nacionalidad);
	
	public List<NacionalidadDTO> findAll();
	
	public NacionalidadDTO findById(long id);

}
