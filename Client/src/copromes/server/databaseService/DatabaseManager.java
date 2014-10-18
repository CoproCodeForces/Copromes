package copromes.server.databaseService;

import java.util.List;

import copromes.commonInterfaces.IAuthorizationManager;
import copromes.commonInterfaces.IContactsManager;
import copromes.commonInterfaces.IMessengerManager;
import copromes.commonInterfaces.RegistrationException;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public class DatabaseManager implements IAuthorizationManager, IContactsManager, IMessengerManager {
	
	public DatabaseManager() {
		
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

	@Override
	public User doLogin(String name, String passwordHash) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doLogout(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User registerUser(String login, String passwordHash,
			String passwordConfirmationHash, String name, String Bio)
			throws RegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message sendMessage(String message) {
		// TODO Auto-generated method stub
		return null;
	}
}
