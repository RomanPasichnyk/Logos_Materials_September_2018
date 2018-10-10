package ua.logos.service;

import java.util.List;

import ua.logos.entity.MakeEntity;

public interface MakeService {

	void saveMake(MakeEntity entity);
	
	MakeEntity getMakeById(Long id);
	
	List<MakeEntity> getAllMakes();
}
