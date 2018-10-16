package ua.logos.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

	@Column(nullable = false)
	private String name;
	
	@Column(name = "color", nullable = false)
	private String color;
	
	@Column(name = "engine_capasity", columnDefinition = "DECIMAL(2,1)")
	private BigDecimal engineCapasity;
	
	@Enumerated(EnumType.STRING)
	private FuelType fuel;
	
	@ManyToOne
	@JoinColumn(name = "make_id")
	private MakeEntity make;
	
	private String image;
}
