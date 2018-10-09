package ua.logos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

	@Column(nullable = false, length = 50, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Course> courses;
}
