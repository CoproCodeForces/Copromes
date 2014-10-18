package copromes.server.authorizationService;

import copromes.commonInterfaces.IAuthorizationManager;
import copromes.commonInterfaces.RegistrationException;
import copromes.domainLayer.User;
import copromes.server.databaseService.DatabaseManager;
import copromes.server.networkService.Server;

public class AuthorizationManager implements IAuthorizationManager {

	private Server server;
	private DatabaseManager dbManager;
	
	public AuthorizationManager(Server server, DatabaseManager dbManager) {
		super();
		this.server = server;
		this.server.setupAuthManager(this);
		
		this.dbManager = dbManager;
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
