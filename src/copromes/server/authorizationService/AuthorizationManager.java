package copromes.server.authorizationService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

import copromes.commonInterfaces.IAuthorizationManager;
import copromes.commonInterfaces.InvalidLoginException;
import copromes.commonInterfaces.InvalidRegistrationException;
import copromes.domainLayer.User;
import copromes.server.databaseService.DatabaseManager;
import copromes.server.networkService.Client;
import copromes.server.networkService.Server;

public class AuthorizationManager extends RemoteServer implements IAuthorizationManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Server server;
	private DatabaseManager dbManager;
	
	public AuthorizationManager(Server server, DatabaseManager dbManager) {
		super();
		this.server = server;
		this.server.setupAuthManager(this);
		
		this.dbManager = dbManager;
	}
	
	@Override
	public User doLogin(String name, String passwordHash) throws RemoteException, InvalidLoginException {
		try {
			User user = dbManager.doLogin(name, passwordHash);
			Client client = new Client(user, getClientHost());
			server.clients.add(client);
			return user;
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServerNotActiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void doLogout(User user) {
		dbManager.doLogout(user);
		server.clients.remove(user);
	}

	@Override
	public User registerUser(String login, String passwordHash,
			String passwordConfirmationHash, String name, String Bio)
			throws InvalidRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

}
