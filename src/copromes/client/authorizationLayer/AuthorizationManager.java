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

	private Server server;

	public AuthorizationManager(Server server) {
		this.server = server;
	}

	public User doLogin(String name, char[] passwordHash)
			throws RemoteException, InvalidLoginException {
		return server.authManager.doLogin(name, String.valueOf(passwordHash));
	}

	public void doLogout(User user) throws RemoteException {
		server.authManager.doLogout(user);
	}

	public User registerUser(String login, char[] passwordHash,
			char[] passwordConfirmationHash, String name, String Bio, String email)
			throws InvalidRegistrationException, RemoteException {
		return server.authManager.registerUser(login,
				String.valueOf(passwordHash),
				String.valueOf(passwordConfirmationHash), name, Bio, email);
	}

}
