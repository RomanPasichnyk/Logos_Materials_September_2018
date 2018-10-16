package ua.logos.service;

import java.util.List;

import ua.logos.domain.ModelDTO;

public interface ModelService {

	void saveModel(ModelDTO dto);
	
	ModelDTO findModelById(Long id);
	
	List<ModelDTO> findAllModels();
}
