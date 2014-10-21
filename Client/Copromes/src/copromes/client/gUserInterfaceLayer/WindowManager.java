package copromes.client.gUserInterfaceLayer;

import copromes.client.authorizationLayer.*;
import copromes.client.contactsLayer.ContactsManager;
import copromes.client.messengerLayer.*;

public class WindowManager {

	private Messenger messengerManager;
	private AuthorizationManager authManager;
	private ContactsManager contactsManager;

	public WindowManager(Messenger messengerManager,
			AuthorizationManager authManager, ContactsManager contactsManager) {
		this.messengerManager = messengerManager;
		this.authManager = authManager;
		this.contactsManager = contactsManager;

	}

	public void start() {
		initialize();
		startListening();
	}

	private void initialize() {
		LoginWindow welcomeWindow = new LoginWindow();
	}

	private void startListening() {

	}

}
