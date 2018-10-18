package ua.logos.model;

import ua.logos.service.Coach;

public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Тренер по футболу: Бігайте протягом 1год";
	}

	@Override
	public String getDailyFortune() {
		return "Тренер по футболу: Сьогодні твій щасливий день";
	}

	
	
}
