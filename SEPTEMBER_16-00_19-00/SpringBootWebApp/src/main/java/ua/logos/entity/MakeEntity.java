package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "makes")
public class MakeEntity extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(name = "short_name", nullable = false)
	private String shortName;
	
}
