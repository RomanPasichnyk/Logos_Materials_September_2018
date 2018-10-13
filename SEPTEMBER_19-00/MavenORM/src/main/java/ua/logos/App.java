package ua.logos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.entity.Course;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
//		Category category = Category.builder().name("Data Base").build();
//		em.persist(category);
//		
//		Teacher teacher = 
//				Teacher.builder()
//					.firstName("John")
//					.lastName("Doe")
//					.email("john.doe@gmail.com")
//					.age(34)
//					.build();
//		em.persist(teacher);
//		
//		Course course = 
//				Course.builder()
//					.title("MySQL 8")
//					.description("Nice MySQL 8 course")
//					.price(new BigDecimal(199.99))
//					.category(category)
//					.teacher(teacher)
//					.build();
//		em.persist(course);
		
//		Category category = 
//				em.createQuery("SELECT c FROM Category c WHERE c.id = :categoryId", Category.class)
//				.setParameter("categoryId", 1L)
//				.getSingleResult();
//		System.out.println(category);
//		
//		Teacher teacher = 
//				em.createQuery("SELECT t FROM Teacher t WHERE t.id = :teacherId", Teacher.class)
//				.setParameter("teacherId", 1L)
//				.getSingleResult();
//		System.out.println(teacher);
//		
//		for(int i = 0; i < 15; i++) {
//			Course course = Course
//					.builder()
//						.title("Course title# " + i)
//						.description("Course descr#" + i)
//						.price(new BigDecimal("9" + i + ".99"))
//						.category(category)
//						.teacher(teacher)
//					.build();
//			em.persist(course);
//		}
		
		/*List<Course> courses = 
				em.createQuery("SELECT c FROM Course c", Course.class)
				.getResultList();
		courses.forEach(System.out::println);*/
		
		/*em.createQuery("SELECT c FROM Course c WHERE c.id >= :param1 AND c.id <= :param2", Course.class)
			.setParameter("param1", 5L)
			.setParameter("param2", 10L)
			.getResultList().forEach(System.out::println);*/
		
		/*em.createQuery("SELECT c FROM Course c WHERE c.title LIKE :likePatter", Course.class)
			.setParameter("likePatter", "%# _")
			.getResultList().forEach(System.out::println);*/
		
		/*em.createQuery("SELECT c FROM Course c WHERE c.price BETWEEN :start AND :finish", Course.class)
		.setParameter("start", new BigDecimal("90.00"))
		.setParameter("finish", new BigDecimal("98.00"))
		.getResultList().forEach(System.out::println);*/
		
		/*em.createQuery("SELECT c FROM Course c WHERE c.id IN (:ids)", Course.class)
		.setParameter("ids", Arrays.asList(3L, 5L, 7L, 10L))
		.getResultList().forEach(System.out::println);*/

//		em.createQuery("SELECT c FROM Course c INNER JOIN c.category cc WHERE c.id = :courseId", Course.class)
//			.setParameter("courseId", 5L).getResultList().forEach(System.out::println);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}

//Category category = new Category();
//category.setName("Angular 5");
//System.out.println("ID: " + category.getId());
//em.persist(category);
//System.out.println("ID: " + category.getId());
//category.setName("React");
//em.persist(category);

// JPQL
/*List<Category> categories = 
		em.createQuery("SELECT c FROM Category c", Category.class)
		.getResultList();
categories.forEach(System.out::println);*/

/*Category category = 
	em.createQuery("SELECT c FROM Category c WHERE c.id = ?1", Category.class)
	.setParameter(1, 2L) // new Long(2)
	.getSingleResult();
System.out.println(category);*/

/*List<Category> categories = 
		em.createQuery("SELECT c FROM Category c WHERE c.id = ?1 OR c.id = ?2", Category.class)
		.setParameter(1, 2L)
		.setParameter(2, 5L)
		.getResultList();
categories.forEach(System.out::println);*/

/*Category category = 
		em.createQuery("SELECT c FROM Category c WHERE c.id = :categoryId", Category.class)
		.setParameter("categoryId", 2L) // new Long(2)
		.getSingleResult();
	System.out.println(category);*/
