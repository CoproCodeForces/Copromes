package copromes.client.authorizationLayer;

import copromes.client.networkLayer.Client;
import copromes.commonInterfaces.IAuthorizationManager;
import copromes.commonInterfaces.RegistrationException;
import copromes.domainLayer.User;

public class AuthorizationManager implements IAuthorizationManager {

	private Client сlient;

	public AuthorizationManager(Client client) {
		this.сlient = client;
	}

	@Override
	public User doLogin(String name, String passwordHash) {
		return сlient.authManager.doLogin(name, passwordHash);
	}

	@Override
	public void doLogout(User user) {
		сlient.authManager.doLogout(user);

	}

	@Override
	public User registerUser(String login, String passwordHash,
			String passwordConfirmationHash, String name, String Bio)
			throws RegistrationException {
		return сlient.authManager.registerUser(login, passwordHash, passwordConfirmationHash, name, Bio);
	}

}
