package ua.logos.domain;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import ua.logos.entity.FuelType;
import ua.logos.validation.CheckModelExists;

@Data
public class ModelDTO {

	private Long id;
	
	@CheckModelExists
	@NotNull(message = "Name cannot be null")
	@Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters")
	private String name;
	
	@NotNull(message = "Color cannot be null")
	private String color;
	
	@DecimalMin(value = "0.0")
	@DecimalMax(value = "9.9")
	private BigDecimal engineCapasity;
	
	@NotNull(message = "Fueld should be typed")
	private FuelType fuel;
	
	@NotNull(message = "Make cannot be null")
	private MakeDTO make;
	private String image;
}
