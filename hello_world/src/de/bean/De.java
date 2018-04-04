package de.bean;

import java.util.Random;

public class De {
	protected int value;
	protected int nbFaces;

	public De(int value) {
		this.value = value;
		nbFaces = 6;
	}

	public De() {
		this(1);
	}

	public De(int value, int nbFaces) {
		this.value = value;
		this.nbFaces = nbFaces;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void lancer() {
		value = (new Random().nextInt(nbFaces)) + 1;
	}

	public void lancer(int maxValue) {
		value = new Random().nextInt(maxValue) + 1;
	}

}
