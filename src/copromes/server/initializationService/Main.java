package copromes.server.initializationService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import copromes.server.contactsService.*;
import copromes.server.authorizationService.AuthorizationManager;
import copromes.server.databaseService.DatabaseManager;
import copromes.server.messengerService.MessengerManager;
import copromes.server.networkService.Server;

final class kek {
	public List<String> l;
	
	public kek(List<String> t) {
		l = t;
	}
}

public class Main {

	private final static int port = 7331;
	
	public static void main(String[] args) {
		try {
			Server server = new Server(port);
			List<String> t = new ArrayList<String>();
			
			DatabaseManager dbManager = new DatabaseManager();			
			AuthorizationManager authorizationManager = new AuthorizationManager(server, dbManager);			
			ContactsManager contactsManager = new ContactsManager(server, dbManager);			
			MessengerManager messengerManager = new MessengerManager(server, dbManager);						
			
		} catch (RemoteException e) {

			e.printStackTrace();
		}

	}

}
