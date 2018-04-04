package pkg_ex1_obj;

public class Eleve {
	private int note;
	private String nom;
	private long id;

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id : " + id + " nom : " + nom + "note : " + note;
	}

}
