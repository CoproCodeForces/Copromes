package copromes.client.networkLayer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import copromes.commonInterfaces.IAuthorizationManager;
import copromes.commonInterfaces.IContactsManager;
import copromes.commonInterfaces.IMessengerManager;

public class Client {

	private final String host;
	private final int port;
	public IAuthorizationManager authManager;
	public IContactsManager contactsManager;
	public IMessengerManager messengerManager;

	public Client(int port, String host) {
		this.port = port;
		this.host = host;
	}

	public void setInterfaces() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(host, port);
		authManager = (IAuthorizationManager) registry
				.lookup("authorizationService");
		contactsManager = (IContactsManager) registry.lookup("contactsService");
		messengerManager = (IMessengerManager) registry
				.lookup("messengerSerivce");

	}
}
