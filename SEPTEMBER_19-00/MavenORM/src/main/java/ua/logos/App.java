package ua.logos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.entity.Category;

public class App {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
//		Category category = new Category();
//		category.setName("Angular 5");
//		System.out.println("ID: " + category.getId());
//		em.persist(category);
//		System.out.println("ID: " + category.getId());
//		category.setName("React");
//		em.persist(category);
		
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
		
		Category category = 
				em.createQuery("SELECT c FROM Category c WHERE c.id = :categoryId", Category.class)
				.setParameter("categoryId", 2L) // new Long(2)
				.getSingleResult();
			System.out.println(category);
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
