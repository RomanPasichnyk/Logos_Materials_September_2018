package ua.logos.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import ua.logos.domain.ModelDTO;
import ua.logos.domain.filter.SearchFilter;

public interface ModelService {

	void saveModel(ModelDTO dto);
	
	ModelDTO findModelById(Long id);
	
	List<ModelDTO> findAllModels();
	
	List<ModelDTO> findBySearch(SearchFilter filter);
	
	List<ModelDTO> findByPage(Pageable pageable);
}
