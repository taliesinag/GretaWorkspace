package pkg_ex1_obj;

public class Maison {

	public int largeur = 20; // 20 sera la valeur par défaut
	public int longueur = 10;
	public String couleur;

	public Maison(int longueur, int largeur) {
		this.largeur = largeur;
		this.longueur = longueur;
	}

	public Maison(int longueur, int largeur, String couleur) {

		this.largeur = largeur;
		this.longueur = longueur;
		this.couleur = couleur;

	}

	public Maison() {
	}

	public int getSurface() {
		return (longueur * largeur);
	}

}
