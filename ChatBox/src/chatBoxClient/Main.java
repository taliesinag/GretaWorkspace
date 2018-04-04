package chatBoxClient;

import java.awt.EventQueue;

import ihm.ChatBoxClientIHM;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ChatBoxClientIHM window = new ChatBoxClientIHM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
