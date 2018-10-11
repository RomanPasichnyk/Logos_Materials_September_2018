package ua.logos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity {

	@Column(name = "first_name", length = 45, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 45, nullable = false)
	private String lastName;

	@Column(length = 80, nullable = false, unique = true)
	private String email;
	
	private int age;
	
	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;
	
	@OneToOne(mappedBy = "teacher")
	private TeacherDetails teacherDetails;
}
