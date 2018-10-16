package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.MakeDTO;
import ua.logos.entity.MakeEntity;
import ua.logos.repository.MakeRepository;
import ua.logos.service.MakeService;
import ua.logos.utils.ObjectMapperUtils;

@Service
public class MakeServiceImpl implements MakeService {

	@Autowired
	private MakeRepository makeRepository;

	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Override
	public void saveMake(MakeDTO dto) {
//		MakeEntity entity = new MakeEntity();
//		entity.setName(dto.getName());
//		entity.setShortName(dto.getShortName());
		
		MakeEntity entity = modelMapper.map(dto, MakeEntity.class);
		makeRepository.save(entity);
	}

	@Override
	public MakeDTO getMakeById(Long id) {
		MakeEntity entity = makeRepository.findById(id).get();
		
		MakeDTO dto = modelMapper.map(entity, MakeDTO.class);
		return dto;
	}

	@Override
	public List<MakeDTO> getAllMakes() {
		List<MakeEntity> entities = makeRepository.findAll();
		List<MakeDTO> dtos = modelMapper.mapAll(entities, MakeDTO.class);
		return dtos;
	}
	
}
