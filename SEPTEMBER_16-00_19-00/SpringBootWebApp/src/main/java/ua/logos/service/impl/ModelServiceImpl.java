package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.ModelDTO;
import ua.logos.entity.ModelEntity;
import ua.logos.exception.AlreadyExistsException;
import ua.logos.exception.ResourceNotFoundException;
import ua.logos.repository.ModelRepository;
import ua.logos.service.ModelService;
import ua.logos.utils.ObjectMapperUtils;

@Service
public class ModelServiceImpl implements ModelService {

	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;

	@Override
	public void saveModel(ModelDTO dto) {
		ModelEntity checkExistsModel = 
				modelRepository.findByName(dto.getName());
		if(checkExistsModel != null) {
			throw new AlreadyExistsException("Record with name[" + dto.getName() + "] already exists");
		}
		
		ModelEntity entity = modelMapper.map(dto, ModelEntity.class);
		modelRepository.save(entity);
	}

	@Override
	public ModelDTO findModelById(Long id) {
		ModelEntity entity = modelRepository
				.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Record with id[" + id + "] not found")
						);
		
		ModelDTO dto = modelMapper.map(entity, ModelDTO.class);
		return dto;
		// return modelMapper.map(modelRepository.findById(id).get(), ModelDTO.class);
	}

	@Override
	public List<ModelDTO> findAllModels() {
		List<ModelEntity> entities = modelRepository.findAll();
		List<ModelDTO> dtos = modelMapper.mapAll(entities, ModelDTO.class);
		return dtos;
	}
	
	
	
}
