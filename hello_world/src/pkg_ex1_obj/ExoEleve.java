package pkg_ex1_obj;

import java.util.Random;

public class ExoEleve {
	/**
	 * Remplit le tableau d’élève avec des noms et une note aléatoire
	 */
	public static void createEleves(Eleve[] tab) {
		for (int i = 0; i < tab.length; i++) {
			tab[i] = new Eleve();
			tab[i].setNom(getRandomName());
			tab[i].setNote(new Random().nextInt(20) + 1);

		}
	}

	/** Affiche les élèves avec leur note */
	public static void printEleves(Eleve[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.println(tab[i].getNom() + " a eu la note de :" + tab[i].getNote());
		}
	}

	/** Retourne l’élève s’appelant bob ayant la meilleurs note */
	public static Eleve bestBob(Eleve[] tab) {
		int indice = -1;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i].getNom() == "Bob") {
				if (indice == -1) {
					indice = i;
				} else if (tab[i].getNote() > tab[indice].getNote()) {
					indice = i;
				}
			}
		}
		return indice == -1 ? null : tab[indice];
	}

	/** Retourne un prénom aléatoire */
	public static String getRandomName() {
		String[] name = new String[] { "Toto", "Tata", "Titi", "Bob", "Alfred" };
		return name[new Random().nextInt(name.length)];
	}

}
