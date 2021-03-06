package ua.logos.model;

import ua.logos.service.Coach;
import ua.logos.service.FortuneService;

public class HockeyCoach implements Coach {

	private FortuneService fortuneService;

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Тренер по хокею: Катайся протягом 2год";
	}

	@Override
	public String getDailyFortune() {
		return "Тренер по хокею: " + fortuneService.getFortune();
	}

}
