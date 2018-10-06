package ua.logos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"courses", "teacherDetails"})

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false, length = 45)
	private String firstName; // first_name varchar(45) not null

	@Column(name = "last_name", nullable = false, length = 45)
	private String lastName; // last_name varchar(45) not null

	@Column(name = "email", nullable = false, unique = true, length = 100)
	private String email; // email varchar(100) not null unique

	@Column(name = "age", nullable = true)
	private int age; // age INT

	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;
	
	@OneToOne(mappedBy = "teacher")
	private TeacherDetails teacherDetails;
	
}
