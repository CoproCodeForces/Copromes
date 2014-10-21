package copromes.client.initializationLayer;

import copromes.client.authorizationLayer.AuthorizationManager;
import copromes.client.contactsLayer.ContactsManager;
import copromes.client.gUserInterfaceLayer.*;
import copromes.client.messengerLayer.Messenger;
import copromes.client.networkLayer.Client;
import copromes.client.serverResponseHandler.ResponseHandler;

public class Main {

	private final static int serverPort = 7331;
	private final static int clientPort = 13337;
	private final static String host = "192.168.0.0";
	
	public static void main(String[] args) {
		try {
			// Initializing access to server host
			//Client client = new Client(serverPort, host);
			Client client = null;
			// Accessing server remote interfaces 
			//client.setInterfaces();
			
			// Initializing local managers for GUI events handling
			AuthorizationManager authManager = new AuthorizationManager(client);
			ContactsManager contactsManager = new ContactsManager(client);
			Messenger messenger = new Messenger(client);

			// Initializing local manager for server event handling
			ResponseHandler responseHandler = new ResponseHandler(clientPort);
			responseHandler.setupClientHost();

			// Initializing GUI;
			WindowManager windowManager = new WindowManager(messenger,
					authManager, contactsManager);
			windowManager.start();
		} catch (Exception e) {
		}
	}
}
