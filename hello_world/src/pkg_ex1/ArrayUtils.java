package pkg_ex1;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {

	public static void fillTab(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			tab[i] = new Random().nextInt(100);
		}
	}

	/** Affiche le tableau dans la console sur 1 seule ligne */
	public static void printTab(int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			System.out.print("[" + tab[i] + "]");
		}
		System.out.println();
	}

	/** Retourne la valeur maximum du tableau */
	public static int getMax(int[] tab) {
		int vmax = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] > vmax) {
				vmax = tab[i];
			}
		}
		return vmax;

	}

	public static int getMin(int[] tab) {
		int vmin = tab[0];
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] < vmin) {
				vmin = tab[i];
			}
		}
		return vmin;

	}

	public static int getIndexMin(int[] tab) {
		int vmin = tab[0];
		int index = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] < vmin) {
				vmin = tab[i];
				index = i;
			}
		}
		return index;

	}

	public static int getSomme(int[] tab) {
		int somme = 0;
		for (int i = 0; i < tab.length; i++) {
			somme += tab[i];
		}
		return somme;
	}

	public static int getMoyenne(int[] tab) {
		return getSomme(tab) / tab.length;
	}

	public static void displaySupMoyenne(int[] tab) {
		int moyenne = getMoyenne(tab);
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] > moyenne) {
				System.out.println("La valeur tab[" + i + "] : " + tab[i] + "est supérieur à la moyenne");
			}
		}
	}

	public static int getOccurenceMax(int[] tab) {
		int vmax = getMax(tab);
		int occurence = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == vmax) {
				occurence++;
			}
		}
		return occurence;
	}

	public static int getOccurenceMax2(int[] tab) {
		int vmax = tab[0];
		int occurence = 0;
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == vmax) {
				occurence++;
			} else if (tab[i] > vmax) {
				vmax = tab[i];
				occurence = 1;
			}
		}
		return occurence;
	}

	// • Retourne la somme
	// • Retourne la moyenne
	// • Affiche les valeurs supérieurs à la moyenne (ne retourne rien)
	// • Retourne le nombre d’occurrence de la valeur maximum (Version o(2n) et
	// O(n))
	/**
	 * Crée et retourne un nouveau tableau qui est la concaténation des 2
	 * tableaux
	 **/
	public static int[] fusion(int[] tab1, int[] tab2) {
		int[] tabResult = new int[(tab1.length + tab2.length)];
		for (int i = 0; i < tabResult.length; i++) {
			if (i < tab1.length) {
				tabResult[i] = tab1[i];
			} else {
				tabResult[i] = tab2[i - tab1.length];
			}

		}
		return tabResult;
	}

	/** Trie le tableau */
	public static void sortTab(int[] tab) {
		int indice;
		int temp;
		for (int i = 0; i < tab.length; i++) {
			indice = i;
			for (int j = 0; j < tab.length; j++) {
				if (tab[indice] < tab[j]) {
					temp = tab[j];
					tab[j] = tab[i];
					tab[i] = temp;
				}
			}

		}
	}

	/**
	 * Crée et retourne un tableau trié qui est la fusion des 2 tableaux triés
	 **/
	public static int[] fusion2(int[] sortTab1, int[] sortTab2) {
		int[] resultat = new int[sortTab1.length + sortTab2.length];
		int is1 = 0;
		int is2 = 0;
		for (int i = 0; i < resultat.length; i++) {
			if (is1 < sortTab1.length && is2 < sortTab2.length) {
				if (sortTab1[is1] <= sortTab2[is2]) {
					resultat[i] = sortTab1[is1];
					is1++;
				} else {
					resultat[i] = sortTab2[is2];
					is2++;
				}
			} else if (is1 >= sortTab1.length) {
				resultat[i] = sortTab2[is2];
				is2++;
			} else if (is2 >= sortTab2.length) {
				resultat[i] = sortTab1[is1];
				is1++;
			}

		}
		return resultat;
	}

	public static long sortTime() {
		long resultTime = 0;
		long start = 0;
		int[] bigTab = new int[10000];
		for (int i = 0; i < 100; i++) {
			fillTab(bigTab);
			start = System.currentTimeMillis();
			sortTab(bigTab);
			resultTime += (System.currentTimeMillis() - start);
		}

		return resultTime;
	}

	public static long sortTimeJava() {
		long resultTime = 0;
		long start = 0;
		int[] bigTab = new int[10000];
		for (int i = 0; i < 100; i++) {
			fillTab(bigTab);
			start = System.currentTimeMillis();
			Arrays.sort(bigTab);
			resultTime += (System.currentTimeMillis() - start);
		}

		return resultTime;
	}

	public enum Couleur {
		BLEU, BLANC, ROUGE
	};

	public static void drapeau() {
		Couleur[] myTab = new Couleur[15];
		int j = 0;
		int k = myTab.length - 1;
		for (int i = 0; i < myTab.length; i++) {
			myTab[i] = Couleur.values()[new Random().nextInt(3)];
			System.out.print("[" + myTab[i] + "]");
		}
		System.out.println();
		Couleur temp;
		for (int i = 0; i < myTab.length; i++) {
			if (myTab[i] == Couleur.BLEU) {
				temp = myTab[i];
				myTab[i] = myTab[j];
				myTab[j] = temp;
				j++;

			} else if (myTab[i] == Couleur.ROUGE) {
				temp = myTab[i];
				myTab[i] = myTab[k];
				myTab[k] = temp;
				k--;
			} else if (myTab[i] == Couleur.BLANC) {
				j++;
			}

		}

		for (int l = 0; l < myTab.length; l++) {
			System.out.print("[" + myTab[l] + "]");
		}

	}

}
