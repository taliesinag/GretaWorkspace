package de.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import de.controllers.ControleurDe;

public class GameView {

	private JFrame frame;
	private JLabel lvlScore1, lblJoueur1, lblTour, lblJoueur2, lblScore2;
	private JLabel lblDe2, lblDe1;
	private JButton btnLancerJ1, btnLancerJ2, btnRestart;
	private JTextField txtScore1;
	private JTextField txtScore2;
	private JLabel txtDe1;
	private JLabel txtDe2;

	private Icon[] iconDeFace;

	private JToggleButton tglbtnDiceOnFireJoueur1;
	private JToggleButton tglbtnDiceOnFireJoueur2;

	public JToggleButton getTglbtnDiceOnFireJoueur1() {
		return tglbtnDiceOnFireJoueur1;
	}

	public void setTglbtnDiceOnFireJoueur1(JToggleButton tglbtnDiceOnFireJoueur1) {
		this.tglbtnDiceOnFireJoueur1 = tglbtnDiceOnFireJoueur1;
	}

	public JToggleButton getTglbtnDiceOnFireJoueur2() {
		return tglbtnDiceOnFireJoueur2;
	}

	public void setTglbtnDiceOnFireJoueur2(JToggleButton tglbtnDiceOnFireJoueur2) {
		this.tglbtnDiceOnFireJoueur2 = tglbtnDiceOnFireJoueur2;
	}

	private JDialog dialogBox;
	private JLabel lblDialogBox;
	// private JButton btnDialogBoxOk;

	private ControleurDe ctrl;

	public ControleurDe getCtrl() {
		return ctrl;
	}

	public void setCtrl(ControleurDe ctrl) {
		this.ctrl = ctrl;
	}

	/**
	 * Create the application.
	 */
	public GameView() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void refreshScreen() {

		// Informations joueur 1

		txtDe1.setIcon(iconDeFace[((ctrl.getPartie().getJoueurActif() == ctrl.getPartie().getJoueur1()
				? ctrl.getPartie().getJoueur2() : ctrl.getPartie().getJoueur1()).getGobelet().getDe1Value()) - 1]);
		txtScore1.setText("" + ctrl.getPartie().getJoueur1().getScorePartie());

		lblJoueur1.setText(ctrl.getPartie().getJoueur1().getNom());
		// Informations joueur 2
		txtDe2.setIcon(iconDeFace[((ctrl.getPartie().getJoueurActif() == ctrl.getPartie().getJoueur1()
				? ctrl.getPartie().getJoueur2() : ctrl.getPartie().getJoueur1()).getGobelet().getDe2Value() - 1)]);
		txtScore2.setText("" + ctrl.getPartie().getJoueur2().getScorePartie());
		lblJoueur2.setText(ctrl.getPartie().getJoueur2().getNom());
		// Nombre de tours
		lblTour.setText("TOUR : " + ctrl.getPartie().getTourEnCours());
		// Affichage des boutons
		if (ctrl.getPartie().getJoueurActif() == ctrl.getPartie().getJoueur1()) {
			btnLancerJ1.setEnabled(true);
			btnLancerJ2.setEnabled(false);
		} else {
			btnLancerJ1.setEnabled(false);
			btnLancerJ2.setEnabled(true);
		}

	}

	public void endGame() {
		btnLancerJ1.setEnabled(false);
		btnLancerJ2.setEnabled(false);
		btnRestart.setEnabled(true);

		lblDialogBox.setText(
				(ctrl.getPartie().getJoueur1().getScorePartie() > ctrl.getPartie().getJoueur2().getScorePartie()
						? (ctrl.getPartie().getJoueur1().getNom() + " gagne la partie")
						: ctrl.getPartie().getJoueur1().getScorePartie() < ctrl.getPartie().getJoueur2()
								.getScorePartie() ? (ctrl.getPartie().getJoueur2().getNom() + " gagne la partie")
										: ctrl.getPartie().getJoueur1().getNom() + " et "
												+ ctrl.getPartie().getJoueur2().getNom() + " font égalités"));
		dialogBox.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lvlScore1 = new JLabel("Score :");
		lvlScore1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lvlScore1.setBounds(10, 90, 49, 14);
		frame.getContentPane().add(lvlScore1);

		lblJoueur1 = new JLabel("Joueur 1");
		lblJoueur1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJoueur1.setBounds(53, 32, 73, 30);
		frame.getContentPane().add(lblJoueur1);

		lblTour = new JLabel("Tour :");
		lblTour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTour.setBounds(212, 11, 95, 32);
		frame.getContentPane().add(lblTour);

		lblJoueur2 = new JLabel("Joueur 2");
		lblJoueur2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJoueur2.setBounds(378, 40, 79, 14);
		frame.getContentPane().add(lblJoueur2);

		lblScore2 = new JLabel("Score : ");
		lblScore2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblScore2.setBounds(356, 90, 56, 14);
		frame.getContentPane().add(lblScore2);

		lblDe2 = new JLabel("De2");
		lblDe2.setBounds(279, 133, 39, 14);
		frame.getContentPane().add(lblDe2);

		lblDe1 = new JLabel("De1");
		lblDe1.setBounds(181, 133, 24, 14);
		frame.getContentPane().add(lblDe1);

		btnLancerJ1 = new JButton("Lancer");
		btnLancerJ1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ctrl.callBackLancer1();
			}
		});
		btnLancerJ1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLancerJ1.setBounds(37, 174, 89, 23);
		frame.getContentPane().add(btnLancerJ1);

		btnLancerJ2 = new JButton("Lancer");
		btnLancerJ2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.callBackLancer2();

			}
		});
		btnLancerJ2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLancerJ2.setBounds(356, 174, 89, 23);
		frame.getContentPane().add(btnLancerJ2);

		btnRestart = new JButton("Restart");
		btnRestart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ctrl.callBackRestart();
			}
		});
		btnRestart.setBounds(196, 272, 89, 23);
		btnRestart.setEnabled(false);
		frame.getContentPane().add(btnRestart);

		txtScore1 = new JTextField();
		txtScore1.setEditable(false);
		txtScore1.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore1.setText("Score1");
		txtScore1.setBounds(62, 84, 49, 30);
		frame.getContentPane().add(txtScore1);
		txtScore1.setColumns(10);

		txtScore2 = new JTextField();
		txtScore2.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore2.setEditable(false);
		txtScore2.setText("Score2");
		txtScore2.setColumns(10);
		txtScore2.setBounds(406, 84, 49, 30);
		frame.getContentPane().add(txtScore2);

		txtDe1 = new JLabel();
		// txtDe1.setEditable(false);
		txtDe1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDe1.setText("De1");
		// txtDe1.setColumns(10);
		txtDe1.setBounds(163, 152, 60, 60);
		frame.getContentPane().add(txtDe1);

		txtDe2 = new JLabel();
		// txtDe2.setEditable(false);
		txtDe2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDe2.setText("De2");
		// txtDe2.setColumns(10);
		txtDe2.setBounds(269, 152, 60, 60);
		frame.getContentPane().add(txtDe2);

		tglbtnDiceOnFireJoueur1 = new JToggleButton("Dice on FIRE !!!");
		tglbtnDiceOnFireJoueur1.setBounds(20, 11, 114, 23);
		frame.getContentPane().add(tglbtnDiceOnFireJoueur1);

		tglbtnDiceOnFireJoueur2 = new JToggleButton("Dice on FIRE !!!");
		tglbtnDiceOnFireJoueur2.setBounds(356, 11, 114, 23);
		frame.getContentPane().add(tglbtnDiceOnFireJoueur2);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ctrl.callBackSaveGame();
			}
		});
		btnSave.setBounds(37, 260, 89, 23);
		frame.getContentPane().add(btnSave);

		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.callBackLoadGame();
			}
		});
		btnLoad.setBounds(356, 260, 89, 23);
		frame.getContentPane().add(btnLoad);

		dialogBox = new JDialog(frame, "Game Over", true);
		dialogBox.setBounds(200, 200, 300, 200);
		lblDialogBox = new JLabel("");
		lblDialogBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDialogBox.setBounds(396, 40, 79, 14);
		dialogBox.getContentPane().add(lblDialogBox);
		lblDialogBox.setHorizontalAlignment(SwingConstants.CENTER);

		iconDeFace = new Icon[6];
		iconDeFace[0] = new ImageIcon("C:/Users/JAVA/Documents/java/workspace/hello_world/src/de/images/deFace1.png");
		iconDeFace[1] = new ImageIcon("C:/Users/JAVA/Documents/java/workspace/hello_world/src/de/images/deFace2.png");
		iconDeFace[2] = new ImageIcon("C:/Users/JAVA/Documents/java/workspace/hello_world/src/de/images/deFace3.png");
		iconDeFace[3] = new ImageIcon("C:/Users/JAVA/Documents/java/workspace/hello_world/src/de/images/deFace4.png");
		iconDeFace[4] = new ImageIcon("C:/Users/JAVA/Documents/java/workspace/hello_world/src/de/images/deFace5.png");
		iconDeFace[5] = new ImageIcon("C:/Users/JAVA/Documents/java/workspace/hello_world/src/de/images/deFace6.png");

		// btnDialogBoxOk = new JButton("OK");
		// btnDialogBoxOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		// btnDialogBoxOk.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// dialogBox.setEnabled(false);
		// }
		// });
		//
		// btnDialogBoxOk.setBounds(50, 50, 4, 4);
		// dialogBox.getContentPane().add(btnDialogBoxOk);

	}

	public boolean getBtnRestartValue() {
		return btnRestart.isEnabled();
	}

	public void setBtnRestartValue(boolean bool) {
		btnRestart.setEnabled(bool);
	}
}
