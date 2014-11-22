package copromes.server.initializationService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import copromes.server.contactsService.*;
import copromes.server.authorizationService.AuthorizationManager;
import copromes.server.databaseService.DatabaseManager;
import copromes.server.messengerService.MessengerManager;
import copromes.server.networkService.Server;

public class Main {

	private final static int port = 1488;
	
	public static void main(String[] args) {
		try {
			Server server = new Server(port);			
                        System.out.println("[server] Starting server");
			DatabaseManager dbManager = new DatabaseManager();			
			AuthorizationManager authorizationManager = new AuthorizationManager(server, dbManager);			
			ContactsManager contactsManager = new ContactsManager(server, dbManager);			
			MessengerManager messengerManager = new MessengerManager(server, dbManager);						
                        System.out.println("[server] Server started");
                        
		} catch (RemoteException e) {

			e.printStackTrace();
		}

	}

}
