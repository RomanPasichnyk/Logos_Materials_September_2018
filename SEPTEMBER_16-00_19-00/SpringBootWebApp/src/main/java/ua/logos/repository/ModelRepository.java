package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ua.logos.entity.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {

//	@Query("SELECT m FROM ModelEntity m WHERE m.name = :modelName")
//	ModelEntity findByModelName(@Param("modelName") String name);
	
	ModelEntity findByName(String name);
}
