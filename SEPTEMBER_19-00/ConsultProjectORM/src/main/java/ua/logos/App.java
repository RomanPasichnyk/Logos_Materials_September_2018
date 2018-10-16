package ua.logos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.logos.entity.CountryEntity;
import ua.logos.entity.MakeEntity;
import ua.logos.entity.ModelEntity;
import ua.logos.entity.enums.FuelType;

public class App {
	
	private static final String PATH = System.getProperty("user.dir");
	private static final String SEPARATOR = System.getProperty("file.separator");
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("logos");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
/*		readFile("country").forEach(c -> {
			CountryEntity country = CountryEntity.builder().name(c).build();
			em.persist(country);
		});*/
		
		/*List<CountryEntity> countryEntities = em.createQuery("SELECT c FROM CountryEntity c", CountryEntity.class)
			.getResultList();
		
		for (int i = 0; i < countryEntities.size(); i++) {
			MakeEntity make = MakeEntity
						.builder()
							.name("make name#" + i)
							.country(countryEntities.get(i))
						.build();
			em.persist(make);
		}*/
		
		/*em.createQuery("SELECT m FROM MakeEntity m", MakeEntity.class)
			.getResultList().forEach(m -> {
				System.out.println(m);
				System.out.println(m.getCountry());
			});*/
		
		/*ModelEntity model = new ModelEntity();
		model.setName("ASDFGHJ");
		model.setEngine(new BigDecimal("2.0"));
		model.setFuel(FuelType.PETROL);
		model.setYear(LocalDate.of(1994, 9, 25)); // LocalDate.of(1994, 9, 25); // 2018-10-13
		em.persist(model);*/
		
		em.createQuery("SELECT m FROM MakeEntity m JOIN FETCH m.country c", MakeEntity.class)
			.getResultList().forEach(m -> {
				System.out.println(m);
				System.out.println(m.getCountry());				
			});
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	
	private static List<String> readFile(String fileName) {
		List<String> countries = new ArrayList<>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(PATH + SEPARATOR + fileName + ".txt"));
			
			while (true) {
				String line = reader.readLine();
				if(line != null) {
					countries.add(line);
				} else {
					break;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return countries;
	}
}
