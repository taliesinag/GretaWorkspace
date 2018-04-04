package pkg_ex1;

public class Exo {
	static double photocopie(int nbPhoto) {

		if (nbPhoto <= 10) {
			return nbPhoto * 0.1;
		} else if (nbPhoto <= 30) {
			return 1 + (nbPhoto - 10) * 0.09;
		} else {
			return 2.8 + (nbPhoto - 30) * 0.08;
		}

	}

	static void exo1() {
		int i = 7;
		int j = 3;

		int divInt = i / j;
		int moduloDiv = i % j;
		double divDouble = (double) i / j;
		double somme = divInt + divDouble + moduloDiv;

		System.out.println("Division entière i/j = " + divInt + "\n" + "Reste de la division i/j = " + moduloDiv + "\n"
				+ "Division classique i/j = " + divDouble + "\n" + "La somme des trois résultats précédent = " + somme);
	}

	public static void exo2(String monParam) {
		System.out.println("Paramètre de exo2 : " + monParam);
	}

	public static void exo4(int monParam) {
		int resultat = monParam + 5;
		System.out.println("Mon résultat est : " + resultat);
	}

	public static void sub(int a, int b) {
		int resultat = a - b;
		System.out.println("a = " + a + "\n" + "b = " + b + "\n" + "a - b = " + resultat);
	}

	public static int multiplyAndAdd(int a, int b, int c) {
		return (a * (b + c));
	}

	public static void afficher(String message) {

		System.out.println(message);

	}

	public static int max(int a, int b, int c) {
		int resultat;
		if (a > b && a > c) {
			resultat = a;
		} else if (b > a && b > c) {
			resultat = b;
		} else {
			resultat = c;
		}
		System.out.println("Le plus grand est : " + resultat);
		return resultat;
	}

	public static void multiple47() {
		for (int i = 1; i <= 10000; i++) {
			if (i % 47 == 0) {
				System.out.println(i);
			}
		}
	}

	public static void boucle1() {
		int i = 1;
		while (((i % 7 == 0) && (i % 11 == 0) && (i % 5 == 0) && (((i + (i - 1)) % 36) == 1)) == false) {
			i++;

		}
		System.out.println(i);

	}

	public static String testFor(String maChaine) {
		String resultat = "";
		for (int i = 0; i < maChaine.length(); i++) {
			resultat += maChaine.charAt(i) + "\n";
		}
		return resultat;
	}

	// Nombre de 'a'
	public static int nbreA(String maChaine) {
		int resultat = 0;
		for (int i = 0; i < maChaine.length(); i++) {
			if (maChaine.charAt(i) == 'a') {
				resultat++;
			}
		}
		return resultat;
	}

	// La lettre la plus grande
	public static char lettreGrde(String maChaine) {
		char resultat = maChaine.charAt(0);
		for (int i = 0; i < maChaine.length(); i++) {
			if (maChaine.charAt(i) > resultat) {
				resultat = maChaine.charAt(i);
			}
		}
		return resultat;
	}

	// La lettre la plus petite
	public static char lettrePtite(String maChaine) {
		char resultat = maChaine.charAt(0);
		for (int i = 0; i < maChaine.length(); i++) {
			if (maChaine.charAt(i) < resultat) {
				resultat = maChaine.charAt(i);
			}
		}
		return resultat;
	}

	// Combien de fois la lettre la plus grande apparait
	public static int nbreGrde(String maChaine) {
		int resultat = 0;
		char Grde = lettreGrde(maChaine);
		for (int i = 0; i < maChaine.length(); i++) {
			if (maChaine.charAt(i) == Grde) {
				resultat++;
			}
		}
		return resultat;
	}

	// Inverser les caractères du string
	public static String reverse(String maChaine) {
		String resultat = "";
		for (int i = 0; i < maChaine.length(); i++) {
			resultat += maChaine.charAt(maChaine.length() - 1 - i);

		}
		return resultat;
	}

	// Supprimer les voyelles
	public static String noVoy(String maChaine) {
		String resultat = "";
		for (int i = 0; i < maChaine.length(); i++) {
			if (maChaine.charAt(i) != 'a' && maChaine.charAt(i) != 'e' && maChaine.charAt(i) != 'i'
					&& maChaine.charAt(i) != 'o' && maChaine.charAt(i) != 'u' && maChaine.charAt(i) != 'y') {
				resultat += maChaine.charAt(i);
			}

		}
		return resultat;
	}

	// Vérifier si les lettres sont triées dans l'ordre alpha
	public static boolean trierOk(String maChaine) {
		boolean resultat = true;
		for (int i = 1; i < maChaine.length(); i++) {
			if ((maChaine.charAt(i - 1) > maChaine.charAt(i)) && resultat) {
				resultat = false;
			}
		}
		return resultat;
	}

	// Est-ce qu'il n'y a que des minuscules
	public static boolean minusOnly(String maChaine) {
		boolean resultat = true;
		for (int i = 0; i < maChaine.length(); i++) {
			if ((maChaine.charAt(i) < 'a') || (maChaine.charAt(i) > 'z')) {
				resultat = false;
			}
		}
		return resultat;
	}

	public static int somme(String maChaine) {
		int resultat = 0;
		for (int i = 0; i < maChaine.length(); i++) {
			char c = maChaine.charAt(i);
			resultat += c;
		}

		return resultat;
	}

	public static char moyenne(String maChaine) {
		return (char) (somme(maChaine) / maChaine.length());
	}

	public static String premiereString(String s1, String s2) {
		String resultat = s1 == s2 ? s1 : null;
		for (int i = 0; i < s1.length(); i++) {
			if (resultat == null) {
				if (i < s2.length()) {
					if (s1.charAt(i) < s2.charAt(i)) {
						resultat = s1;
					} else if (s1.charAt(i) > s2.charAt(i)) {
						resultat = s2;
					} else if (s1.charAt(i) == s2.charAt(i)) {
						if (i == (s1.length() - 1) && s2.length() > s1.length()) {
							resultat = s1;
						}
					}
				} else {
					resultat = s2;
				}
			}
		}

		return resultat;
	}

	public static String fusiontrier(String s1, String s2) {
		// Fusion
		String resultat = s1 + s2;
		// Triage
		String temp = "";
		while (!resultat.isEmpty()) {
			for (int i = 0; i < resultat.length(); i++) {
				boolean boo = true;
				for (int j = 0; j < resultat.length(); j++) {
					if (resultat.charAt(i) > resultat.charAt(j)) {
						boo = false;
					}
				}
				if (boo) {
					temp += resultat.charAt(i);
					// System.out.println(temp);
					resultat = dropLettre(resultat, i);
					// System.out.println(resultat);
				}
			}
		}
		resultat = temp;
		return resultat;
	}

	public static String dropLettre(String myString, int i) {
		String resultat = "";
		for (int j = 0; j < myString.length(); j++) {
			resultat += i == j ? "" : myString.charAt(j);
		}
		return resultat;
	}
}
