package copromes.commonInterfaces;

import java.rmi.Remote;

import copromes.domainLayer.User;

public interface IAuthorizationManager extends Remote {
	User doLogin(String name, String passwordHash);

	void doLogout(User user);

	User registerUser(String login, String passwordHash,
			String passwordConfirmationHash, String name, String Bio)
			throws RegistrationException;
}
