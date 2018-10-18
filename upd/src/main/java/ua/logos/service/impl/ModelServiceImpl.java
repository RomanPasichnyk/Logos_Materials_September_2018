package ua.logos.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.logos.domain.ModelDTO;
import ua.logos.domain.filter.SearchFilter;
import ua.logos.entity.ModelEntity;
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
		ModelEntity entity = modelMapper.map(dto, ModelEntity.class);
		modelRepository.save(entity);
	}

	@Override
	public ModelDTO findModelById(Long id) {
		ModelEntity entity = modelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Resource with id[" + id + "] not found"));

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

	@Override
	public List<ModelDTO> findBySearch(SearchFilter filter) {
		List<ModelEntity> entities = modelRepository.findAll(getSpecification(filter));
		return modelMapper.mapAll(entities, ModelDTO.class);
	}

	private Specification<ModelEntity> getSpecification(SearchFilter filter) {
		return new Specification<ModelEntity>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ModelEntity> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				if (filter.getSearch().isEmpty()) {
					return null;
				}

				Expression<String> nameExpression = root.get("name");
				Expression<BigDecimal> engineExpression = root.get("engineCapasity");

				Predicate namePredicate = criteriaBuilder.like(nameExpression, "%" + filter.getSearch() + "%");
				Predicate enginePredicate = criteriaBuilder.greaterThanOrEqualTo(engineExpression,
						new BigDecimal("2.5"));

				return criteriaBuilder.and(namePredicate, enginePredicate);
			}
		};
	}

	@Override
	public List<ModelDTO> findByPage(Pageable pageable) {
		PageRequest request = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
		return modelMapper.mapAll(modelRepository.findAll(request).getContent(), ModelDTO.class);
	}

}