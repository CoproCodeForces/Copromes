package copromes.server.contactsService;

import java.util.List;

import copromes.commonInterfaces.IContactsManager;
import copromes.domainLayer.User;
import copromes.server.databaseService.DatabaseManager;
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
	public List<User> getUsersOnline() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFriend(User friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFriend(User friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
