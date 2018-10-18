package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import ua.logos.entity.ModelEntity;

@Repository
public interface ModelRepository 
	extends JpaRepository<ModelEntity, Long>, JpaSpecificationExecutor<ModelEntity> {

	ModelEntity findByName(String name);
	
}
