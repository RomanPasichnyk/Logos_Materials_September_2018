package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.logos.entity.MakeEntity;

@Repository
public interface MakeRepository extends JpaRepository<MakeEntity, Long> {

}
