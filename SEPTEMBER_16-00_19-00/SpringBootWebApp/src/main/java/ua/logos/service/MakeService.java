package ua.logos.service;

import java.util.List;

import ua.logos.domain.MakeDTO;

public interface MakeService {

	void saveMake(MakeDTO dto);
	
	MakeDTO getMakeById(Long id);
	
	List<MakeDTO> getAllMakes();
}
