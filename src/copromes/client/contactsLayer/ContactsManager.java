package copromes.client.contactsLayer;

import java.rmi.RemoteException;
import java.util.List;

import copromes.client.networkLayer.Server;
import copromes.commonInterfaces.IContactsManager;
import copromes.domainLayer.User;

public class ContactsManager implements IContactsManager {
	private Server server;
	
	public ContactsManager(Server server) {
		this.server = server;
	}

	@Override
	public List<User> getUsersOnline() throws RemoteException {
		return server.contactsManager.getUsersOnline();
	}

	@Override
	public void addFriend(User friend) throws RemoteException {
		server.contactsManager.addFriend(friend);
	}

	@Override
	public void deleteFriend(User friend) throws RemoteException {
		server.contactsManager.deleteFriend(friend);

	}

	@Override
	public List<User> findUser(String name) throws RemoteException {
		return server.contactsManager.findUser(name);
	}

}
