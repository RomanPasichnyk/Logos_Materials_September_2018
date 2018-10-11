package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "teacher_details")
public class TeacherDetails extends BaseEntity {

	@Column(nullable = true)
	private String hobby;
	
	@Column(nullable = false)
	private String country;
	
	@OneToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
}
