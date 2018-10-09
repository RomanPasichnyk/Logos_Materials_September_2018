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
		
		/*Category category = new Category();
		category.setName("Mobile");
		em.persist(category);*/
		
		
		// JPQL
		List<Category> categories = 
				em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
		categories.forEach(c -> System.out.println(c.getName()));
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
