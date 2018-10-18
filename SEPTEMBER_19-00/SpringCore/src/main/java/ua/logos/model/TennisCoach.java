package ua.logos.model;

import ua.logos.service.Coach;
import ua.logos.service.FortuneService;

public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Тренер по тенісу: Відпрацьовуйте подачі протягом 40хв";
	}

	@Override
	public String getDailyFortune() {
		return "Тренер по тенісу: " + fortuneService.getFortune();
	}

}
