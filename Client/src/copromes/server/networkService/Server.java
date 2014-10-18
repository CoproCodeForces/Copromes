package copromes.server.networkService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import copromes.commonInterfaces.*;
import copromes.server.authorizationService.AuthorizationManager;
import copromes.server.contactsService.ContactsManager;
import copromes.server.messengerService.MessengerManager;

public class Server {

	private Registry registry;
	private int port;
	private IAuthorizationManager authManager;
	private IContactsManager contactsManager;
	private IMessengerManager messengerManager;

	public Server(int port, AuthorizationManager authManager,
			ContactsManager contactsManager, MessengerManager messengerManager) {
		this.port = port;
		this.authManager = authManager;
		this.contactsManager = contactsManager;
		this.messengerManager = messengerManager;
	}

	public void setupServer() {
		try {
			registry = LocateRegistry.createRegistry(port);
			
			IAuthorizationManager authStub = (IAuthorizationManager) UnicastRemoteObject
					.exportObject(authManager, port);
			IContactsManager contactsStub = (IContactsManager) UnicastRemoteObject
					.exportObject(contactsManager, port);
			IMessengerManager messengerStub = (IMessengerManager) UnicastRemoteObject
					.exportObject(messengerManager, port);
			
			registry.rebind("authorizationService", authStub);
			registry.rebind("contactsService", contactsStub);
			registry.rebind("messengerSerivce", messengerStub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
