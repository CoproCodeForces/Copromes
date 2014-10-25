package copromes.client.gUserInterfaceLayer;

import javax.swing.JOptionPane;

import copromes.client.authorizationLayer.*;
import copromes.client.contactsLayer.ContactsManager;
import copromes.client.messengerLayer.*;

public class WindowManager {

	public Messenger messengerManager;
	public AuthorizationManager authManager;
	public ContactsManager contactsManager;
	
	public WindowManager(Messenger messengerManager,
			AuthorizationManager authManager, ContactsManager contactsManager) {
		this.messengerManager = messengerManager;
		this.authManager = authManager;
		this.contactsManager = contactsManager;

	}

	public WindowManager() {
		
	}
	
	public void start() {
		initialize();
		startListening();
	}

	private void initialize() {
		LoginWindow welcomeWindow = new LoginWindow(authManager);
	}

	private void startListening() {

	}
	
	public void showError(String error) {
		JOptionPane.showMessageDialog(null, error);
	}
}
