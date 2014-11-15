package copromes.client.gUserInterfaceLayer;

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

import copromes.client.authorizationLayer.*;
import copromes.client.contactsLayer.ContactsManager;
import copromes.client.messengerLayer.*;
import copromes.client.serverResponseHandler.ResponseHandler;
import copromes.domainLayer.User;

public class WindowManager {

	public Messenger messengerManager;
	public AuthorizationManager authManager;
	public ContactsManager contactsManager;
	public ResponseHandler responseHandler;
	public LoginWindow loginWindow; 
	public ChatWindow chatWindow;
	public RegistrationWindow registrationWindow;
	private User user;

	public WindowManager(Messenger messengerManager,
			AuthorizationManager authManager, ContactsManager contactsManager,
			ResponseHandler responseHandler) {
		this.messengerManager = messengerManager;
		this.authManager = authManager;
		this.contactsManager = contactsManager;
		this.responseHandler = responseHandler;
		this.responseHandler.windowManager = this;
	}

	public WindowManager() {

	}

	public void start() {
		showLoginWindow();
	}

	private void showLoginWindow() {
		loginWindow = new LoginWindow(this);
	}

	public void showError(String error) {
		JOptionPane.showMessageDialog(null, error, "Copromes error", 0);
	}
}
