package copromes.client.contactsLayer;

import java.util.List;

import copromes.client.networkLayer.Client;
import copromes.commonInterfaces.IContactsManager;
import copromes.domainLayer.User;

public class contactsManager implements IContactsManager {
	private Client client;
	
	public contactsManager(Client client) {
		this.client = client;
	}

	@Override
	public List<User> getUsersOnline() {
		return client.contactsManager.getUsersOnline();
	}

	@Override
	public void addFriend(User friend) {
		client.contactsManager.addFriend(friend);
	}

	@Override
	public void deleteFriend(User friend) {
		client.contactsManager.deleteFriend(friend);

	}

	@Override
	public List<User> findUser(String name) {
		return client.contactsManager.findUser(name);
	}

}
