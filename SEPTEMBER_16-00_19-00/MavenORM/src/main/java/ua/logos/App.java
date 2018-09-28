package ua.logos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		
		/*
		DROP DATABASE IF EXISTS online_course;
		CREATE DATABASE online_course CHAR SET UTF8;
		*/
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql56");
		EntityManager em = factory.createEntityManager();
		
		
		em.close();
		factory.close();
	}
}
