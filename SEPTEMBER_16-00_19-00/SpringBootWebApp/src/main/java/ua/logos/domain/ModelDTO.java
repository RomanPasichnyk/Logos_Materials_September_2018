package ua.logos.domain;

import java.math.BigDecimal;

import lombok.Data;
import ua.logos.entity.FuelType;

@Data
public class ModelDTO {

	private Long id;
	private String name;
	private String color;
	private BigDecimal engineCapasity;
	private FuelType fuel;
	private MakeDTO make;
}
