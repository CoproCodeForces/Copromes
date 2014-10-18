package copromes.server.messengerService;

import copromes.commonInterfaces.IMessengerManager;
import copromes.server.databaseService.DatabaseManager;
import copromes.server.networkService.Server;

public class MessengerManager implements IMessengerManager {
	
	private Server server;
	private DatabaseManager dbManager;
	
	public MessengerManager(Server server, DatabaseManager dbManager) {
		super();
		this.server = server;
		this.server.setupMessengerManager(this);
		
		this.dbManager = dbManager;
	}
}
