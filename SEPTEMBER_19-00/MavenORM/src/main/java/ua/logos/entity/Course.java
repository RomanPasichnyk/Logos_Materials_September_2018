package ua.logos.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"category", "teacher", "students"})
@AllArgsConstructor
@Builder

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

	@Column(name = "title", length = 120, nullable = false, unique = true)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String description;
	
	@Column(columnDefinition = "DECIMAL(6,2)", nullable = false)
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	@ManyToMany
	@JoinTable(name = "course_student", 
			joinColumns = @JoinColumn(name = "course_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
	)
	private List<Student> students;
}
