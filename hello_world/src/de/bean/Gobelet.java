
package de.bean;

import java.util.ArrayList;

public class Gobelet {

	private ArrayList<De> deList;
	private int nbDes = 2;

	public Gobelet() {

		deList = new ArrayList<>(nbDes);
		for (int i = 0; i < deList.size(); i++) {
			deList.add(new De());
		}

	}

	public Gobelet(boolean holy) {
		deList = new ArrayList<>(nbDes);
		for (int i = 0; i < deList.size(); i++) {
			deList.add(i == 0 ? holy ? new HolyDe() : new De() : new De());
		}

	}

	public void lancer() {
		for (De de : deList) {
			de.lancer();
		}

	}

	public int getScoreDe() {
		int resultat = 0;
		for (De de : deList) {
			resultat += de.getValue();
		}
		return resultat;
	}

	public int getDe1Value() {
		return deList.get(0).getValue();
	}

	public int getDe2Value() {
		return deList.get(1).getValue();
	}
}
