package copromes.client.contactsLayer;

import java.rmi.RemoteException;
import java.util.List;

import copromes.client.networkLayer.Client;
import copromes.commonInterfaces.IContactsManager;
import copromes.domainLayer.User;

public class ContactsManager implements IContactsManager {
	private Client client;
	
	public ContactsManager(Client client) {
		this.client = client;
	}

	@Override
	public List<User> getUsersOnline() throws RemoteException {
		return client.contactsManager.getUsersOnline();
	}

	@Override
	public void addFriend(User friend) throws RemoteException {
		client.contactsManager.addFriend(friend);
	}

	@Override
	public void deleteFriend(User friend) throws RemoteException {
		client.contactsManager.deleteFriend(friend);

	}

	@Override
	public List<User> findUser(String name) throws RemoteException {
		return client.contactsManager.findUser(name);
	}

}
