package ua.logos;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.logos.model.FootballCoach;
import ua.logos.model.HockeyCoach;
import ua.logos.model.TennisCoach;
import ua.logos.service.Coach;

public class App {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext("applicationContainer.xml");
		
		// Coach footballCoach = (Coach) container.getBean("footballCoach");
		Coach footballCoach = container.getBean(FootballCoach.class);
		System.out.println(footballCoach.getDailyWorkout());
		System.out.println(footballCoach.getDailyFortune());
		
		Coach tennisCoach = container.getBean(TennisCoach.class);
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
		
		
		Coach hockeyCoach = container.getBean(HockeyCoach.class);
		System.out.println(hockeyCoach.getDailyWorkout());
		System.out.println(hockeyCoach.getDailyFortune());
		
		// FootballCoach footballCoach = new FootballCoach();
		// Coach footballCoach1 = new FootballCoach();
		
		container.close();
	}
}
