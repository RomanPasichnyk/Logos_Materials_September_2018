package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.entity.MakeEntity;
import ua.logos.repository.MakeRepository;
import ua.logos.service.MakeService;

@Service
public class MakeServiceImpl implements MakeService {

	@Autowired
	private MakeRepository makeRepository;
	
	@Override
	public void saveMake(MakeEntity entity) {
		makeRepository.save(entity);
	}

	@Override
	public MakeEntity getMakeById(Long id) {
		return makeRepository.findById(id).get();
	}

	@Override
	public List<MakeEntity> getAllMakes() {
		return makeRepository.findAll();
	}

}
