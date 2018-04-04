package de;

import java.awt.EventQueue;

import de.controllers.ControleurDe;
import de.view.GameView;

public class Main {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameView window = new GameView();
					ControleurDe ctrl = new ControleurDe();
					ctrl.startGame(window);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
