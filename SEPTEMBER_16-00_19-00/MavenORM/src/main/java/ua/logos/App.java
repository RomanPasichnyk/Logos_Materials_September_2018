package ua.logos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.entity.Teacher;
import ua.logos.entity.TeacherDetails;

public class App {
	public static void main(String[] args) {
		
		/*
		DROP DATABASE IF EXISTS online_course;
		CREATE DATABASE online_course CHAR SET UTF8;
		*/
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql56");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		
		//List<Teacher> teachers = 
		//		em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
		//teachers.forEach(System.out::println);
		
		Teacher teacher = 
		em.createQuery("SELECT t FROM Teacher t WHERE t.id = :teacherId", Teacher.class)
				.setParameter("teacherId", 5L)
				.getSingleResult();
		System.out.println(teacher);
		
//		for(int i = 0; i < 100; i++) {
//			Teacher teacher = new Teacher();
//			teacher.setEmail("teacher@gmail.com" + i);
//			teacher.setFirstName("Teacher_F" + i);
//			teacher.setLastName("Teacher_L" + i);
//			teacher.setAge(34);
//			
//			em.persist(teacher);
//		}
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}

/*
Teacher teacher = new Teacher();
		teacher.setEmail("teacher7545@gmail.com");
		teacher.setFirstName("Teacher_F");
		teacher.setLastName("Teacher_L");
		teacher.setAge(34);
		System.out.println("ID: " + teacher.getId());
		
		TeacherDetails details = new TeacherDetails();
		details.setHobby("Programming");
		details.setSecondEmail("teacher2@gmail.com");
		em.persist(details); // ---
		
		teacher.setTeacherDetails(details);
		em.persist(teacher);
		System.out.println("ID: " + teacher.getId());

*/