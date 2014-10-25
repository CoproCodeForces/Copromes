package copromes.client.authorizationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import copromes.client.networkLayer.Server;
import copromes.commonInterfaces.IAuthorizationManager;
import copromes.commonInterfaces.InvalidLoginException;
import copromes.commonInterfaces.InvalidRegistrationException;
import copromes.domainLayer.User;

public class AuthorizationManager {

	private Server client;

	public AuthorizationManager(Server client) {
		this.client = client;
	}
	
	public User doLogin(String name, char[] passwordHash) throws RemoteException, InvalidLoginException {
		return client.authManager.doLogin(name, String.valueOf(passwordHash));
	}

	
	public void doLogout(User user) throws RemoteException {
		client.authManager.doLogout(user);

	}

	
	public User registerUser(String login, String passwordHash,
			String passwordConfirmationHash, String name, String Bio)
			throws InvalidRegistrationException, RemoteException {
		return client.authManager.registerUser(login, passwordHash, passwordConfirmationHash, name, Bio);
	}

}
