package pkg_ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import pkg_ex1_obj.Maison;

public class CollectionUtils {

	private static final Random rand = new Random();

	/** Remplis la liste de maison de largeur et longueur aléatoires */
	public static void fillList(ArrayList<Maison> maisonArrayList, int nbMaison) {
		if (nbMaison > 0) {
			for (int i = 0; i < nbMaison; i++) {
				maisonArrayList.add(new Maison(rand.nextInt(10) + 1, rand.nextInt(20) + 1));

			}
		}

	}

	/** Affiche la liste dans la console */
	public static void printList(ArrayList<Maison> maisonArrayList) {
		for (Iterator<Maison> iterator = maisonArrayList.iterator(); iterator.hasNext();) {
			Maison maison = iterator.next();
			System.out.println("Largeur : " + maison.largeur + " , longueur : " + maison.longueur + " ; couleur : "
					+ maison.couleur);

		}
	}

	/** Affiche et retourne la maison la plus grande */
	public static Maison getMax(ArrayList<Maison> maisonArrayList) {
		Maison resultat = null;
		if (!maisonArrayList.isEmpty()) {
			for (Iterator<Maison> iterator = maisonArrayList.iterator(); iterator.hasNext();) {
				Maison maison = iterator.next();
				if (resultat == null) {
					resultat = maison;
				} else {
					resultat = resultat.getSurface() > maison.getSurface() ? resultat : maison;
				}

			}
		}

		return resultat;
	}

	/** Retire les maisons de surface impaire */
	public static void supImpaire(ArrayList<Maison> maisonArrayList) {
		if (!maisonArrayList.isEmpty()) {
			int j = 0;
			while (j < maisonArrayList.size()) {
				maisonArrayList.remove(maisonArrayList.get(j));
				j++;

			}
		}

	}

}
