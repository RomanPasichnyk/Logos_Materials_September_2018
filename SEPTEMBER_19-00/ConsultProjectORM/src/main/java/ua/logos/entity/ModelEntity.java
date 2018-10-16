package ua.logos.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.logos.entity.enums.FuelType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

	@Column(nullable = false)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private FuelType fuel;
	
	@Column(columnDefinition = "DECIMAL(2,1)", nullable = false)
	private BigDecimal engine;
	
	@Column(nullable = false)
	private LocalDate year;
}
