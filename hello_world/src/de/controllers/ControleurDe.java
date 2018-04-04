package de.controllers;

import de.bean.Partie;
import de.view.GameView;

public class ControleurDe {

	public static boolean LOG = false;
	public static int NB_TOUR = 10;
	public static int SCOREAFAIRE = 7;
	private Partie partie;
	private GameView view;

	public ControleurDe() {

	}

	public void initializeView(GameView view) {
		this.view = view;
		view.setCtrl(this);
		view.refreshScreen();
		view.getFrame().setVisible(true);

	}

	public void startGame(GameView view) {
		partie = new Partie("Jean", "Robert");
		initializeView(view);

	}

	public void newGame() {
		partie = new Partie("Jean", "Robert");
	}

	private void endGame() {
		if (partie.getTourEnCours() > 10) {
			view.endGame();
		}
	}

	public void callBackLancer1() {
		partie.getJoueur1().setTricheur(view.getTglbtnDiceOnFireJoueur1().isSelected());
		partie.getJoueur1().lancer();

		partie.setJoueurActif(partie.getJoueur2());
		view.refreshScreen();

	}

	public void callBackLancer2() {
		partie.getJoueur2().setTricheur(view.getTglbtnDiceOnFireJoueur2().isSelected());
		partie.getJoueur2().lancer();

		partie.ajouter1Tour();

		partie.setJoueurActif(partie.getJoueur1());
		view.refreshScreen();
		endGame();
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public GameView getView() {
		return view;
	}

	public void setView(GameView view) {
		this.view = view;
	}

	public static void log(String trace) {
		if (LOG) {
			System.out.print(trace);
		}
	}

	public void callBackSaveGame() {
		if (partie.getId() == 0) {
			partie.savePartie();
		} else {
			partie.updatePartie();
		}
	}

	public void callBackLoadGame() {
		partie = new Partie("Jean", "Jacques");
		partie.setId(1);
		partie.getPartieBDD();

	}

	public void callBackRestart() {
		partie = new Partie("Jean", "Robert");
		view.setBtnRestartValue(false);
		view.refreshScreen();
	}

}
