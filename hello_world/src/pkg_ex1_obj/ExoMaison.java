package pkg_ex1_obj;

import java.util.Random;

public class ExoMaison {
	/** Affiche la largeur, longueur couleur de la maison */
	public static void printMaison(Maison m) {
		System.out.print(
				"La largeur : " + m.largeur + " La longueur : " + m.longueur + " La couleur : " + m.couleur + "");
		System.out.println();
	}

	/** Double les tailles de la maison */
	public static void doubleMaison(Maison m) {
		m.largeur = m.largeur * 2;
		m.longueur = m.longueur * 2;
	}

	/** Retourne la maison la plus grande */
	public static Maison big(Maison m1, Maison m2) {
		Maison result = null;
		if ((m1.largeur * m1.longueur) < (m2.largeur * m2.longueur)) {
			result = m2;
		} else if ((m1.largeur * m1.longueur) >= (m2.largeur * m2.longueur)) {
			result = m1;
		}
		return result;

	}

	/** Remplit le tableau de maison avec des tailles aléatoires */
	public static void createMaisons(Maison[] tab) {
		for (int i = 0; i < tab.length; i++) {
			tab[i] = new Maison();
			tab[i].largeur = (new Random().nextInt(20)) + 1;
			tab[i].largeur = (new Random().nextInt(10)) + 1;
		}
	}

	/** Affiche les maisons avec leur taille. 1 maison par ligne */
	public static void printMaisons(Maison[] tab) {
		for (int i = 0; i < tab.length; i++) {
			printMaison(tab[i]);
		}
	}

	/** Retourne la maison la plus grande (Longueur * largeur) */
	public static Maison bigMaison(Maison[] tab) {
		int indice = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i].largeur * tab[i].longueur < tab[indice].largeur * tab[indice].longueur) {
				indice = i;
			}
		}
		return tab[indice];
	}
}
