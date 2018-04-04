package de.bean;

import java.util.Random;

public class HolyDe extends De {

	@Override
	public void lancer() {
		super.value = new Random().nextInt(2) < 1 ? (new Random().nextInt(super.nbFaces)) + 1 : 6;
		if (new Random().nextInt(2) < 1) {
			value = (new Random().nextInt(super.nbFaces)) + 1;

		} else {
			value = 6;
		}
	}

	@Override
	public void lancer(int maxValue) {
		super.value = new Random().nextInt(2) < 1 ? (new Random().nextInt(maxValue)) + 1 : maxValue;
		;
	}

}
