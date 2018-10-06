package ua.logos.service.impl;

import ua.logos.service.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Сьогодні буде дощ. Сидіть вдома";
	}

}
