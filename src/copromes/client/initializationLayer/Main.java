package copromes.client.initializationLayer;

import copromes.client.authorizationLayer.AuthorizationManager;
import copromes.client.contactsLayer.ContactsManager;
import copromes.client.gUserInterfaceLayer.*;
import copromes.client.messengerLayer.Messenger;
import copromes.client.networkLayer.Server;
import copromes.client.serverResponseHandler.ResponseHandler;

public class Main {

	private final static int serverPort = 7331;
	private final static int clientPort = 13337;
	private final static String host = "192.168.1.136";
	
	public static void main(String[] args) {
		
		WindowManager windowManager = new WindowManager(); 
		
		try {			
			// Initializing access to server host			
			Server server = new Server(serverPort, host);			
			// Accessing server remote interfaces 
			server.setInterfaces();
			
			// Initializing local managers for GUI events handling
			AuthorizationManager authManager = new AuthorizationManager(server);
			ContactsManager contactsManager = new ContactsManager(server);
			Messenger messenger = new Messenger(server);

			// Initializing local manager for server event handling
			ResponseHandler responseHandler = new ResponseHandler(clientPort);
			responseHandler.setupClientHost();

			// Initializing GUI;
			windowManager = new WindowManager(messenger,
					authManager, contactsManager);
			windowManager.start();
		} catch (Exception e) {
			windowManager.showError(e.getMessage());		
		}
	}
}
