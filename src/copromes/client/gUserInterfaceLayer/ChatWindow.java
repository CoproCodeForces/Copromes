package copromes.client.gUserInterfaceLayer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import copromes.domainLayer.User;

public class ChatWindow extends JFrame implements ActionListener {
	
	private WindowManager windowManager;
	private User user;
	
	public ChatWindow(WindowManager windowManager, User user) {
		this.windowManager = windowManager;
		this.user = user;
		initUI();
	}
	
	private void initUI(){
		setTitle("CHAT");
		setSize(1337, 1488);
		setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
