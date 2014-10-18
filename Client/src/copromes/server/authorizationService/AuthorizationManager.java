package copromes.server.authorizationService;

import copromes.commonInterfaces.IAuthorizationManager;
import copromes.commonInterfaces.RegistrationException;
import copromes.domainLayer.User;

public class AuthorizationManager implements IAuthorizationManager {

	public AuthorizationManager() {
		super();
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

}
