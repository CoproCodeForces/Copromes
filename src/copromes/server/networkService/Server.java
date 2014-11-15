package copromes.server.networkService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import copromes.commonInterfaces.*;
import copromes.server.authorizationService.AuthorizationManager;
import copromes.server.contactsService.ContactsManager;
import copromes.server.messengerService.MessengerManager;

public class Server {

	private Registry registry;
	private int port;	
	public List<Client> clients;
	
	
	public Server(int port) throws RemoteException {
		this.port = port;
		registry = LocateRegistry.createRegistry(port);
		clients = new ArrayList<Client>();
		new Thread(new ClientChecker(clients)).start();
                

	}

	public void setupAuthManager(AuthorizationManager authManager) {
		try {
			IAuthorizationManager authStub = (IAuthorizationManager) UnicastRemoteObject
					.exportObject(authManager, port);
			registry.rebind("authorizationService", authStub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setupContactsManager(ContactsManager contactsManager) {
		try {
			IContactsManager contactsStub = (IContactsManager) UnicastRemoteObject
					.exportObject(contactsManager, port);
			registry.rebind("contactsService", contactsStub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setupMessengerManager(MessengerManager messengerManager) {
		try {
			IMessengerManager messengerStub = (IMessengerManager) UnicastRemoteObject
					.exportObject(messengerManager, port);
			registry.rebind("messengerService", messengerStub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

final class ClientChecker implements Runnable {

	private List<Client> clients;
	
	public ClientChecker(List<Client> clients) {
		this.clients = clients;
	}
	
	@Override
	public void run() {
            try{
            while(3<5)
            {
		for (Client client : clients) {
			try {
				client.client.isConnected();
			} catch (RemoteException e) {
				clients.remove(client);
			}
		}
                Thread.sleep(10000);
            }
            }catch(InterruptedException ex)
                    {
                        System.err.println("ClientChecker error");
                    }
	}
	
}
