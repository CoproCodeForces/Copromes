package copromes.commonInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import copromes.domainLayer.User;

public interface IAuthorizationManager extends Remote {
	User doLogin(String name, String passwordHash) throws RemoteException, InvalidLoginException;

	void doLogout(User user) throws RemoteException;

	User registerUser(String login, String passwordHash,
			String passwordConfirmationHash, String name, String Bio)
			throws RemoteException, InvalidRegistrationException;
}
