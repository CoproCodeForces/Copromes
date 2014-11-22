package copromes.server.contactsService;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import copromes.commonInterfaces.IContactsManager;
import copromes.domainLayer.User;
import copromes.server.databaseService.DatabaseManager;
import copromes.server.networkService.Client;
import copromes.server.networkService.Server;

public class ContactsManager implements IContactsManager {

	private Server server;
	private DatabaseManager dbManager;
	
	public ContactsManager(Server server, DatabaseManager dbManager) {
		super();
		this.server = server;
		this.server.setupContactsManager(this);
		
		this.dbManager = dbManager;
	}
	
	@Override
	public List<User> getUsersOnline() throws RemoteException {
		List<User> users = new ArrayList<User>();
		for (Client client : server.clients) {
			users.add(client.user);
		}
		return users;
	}

	@Override
	public void addFriend(User friend) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFriend(User friend) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findUser(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
