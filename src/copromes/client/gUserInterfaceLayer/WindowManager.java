package copromes.client.gUserInterfaceLayer;

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import copromes.client.authorizationLayer.*;
import copromes.client.contactsLayer.ContactsManager;
import copromes.client.messengerLayer.*;
import copromes.domainLayer.User;

public class WindowManager {

	public Messenger messengerManager;
	public AuthorizationManager authManager;
	public ContactsManager contactsManager;
	private User user;
	
	public WindowManager(Messenger messengerManager,
			AuthorizationManager authManager, ContactsManager contactsManager) {
		this.messengerManager = messengerManager;
		this.authManager = authManager;
		this.contactsManager = contactsManager;

	}

	public WindowManager() {
		
	}
	
	public void start() {
		showLoginWindow();
	}

	private void showLoginWindow() {
		ChatWindow chatWindow = new ChatWindow(this, user );
	}
	
	public void showError(String error) {
		JOptionPane.showMessageDialog(null, error, "Copromes error", 0);
	}
}
