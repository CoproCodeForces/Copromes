package copromes.server.messengerService;

import java.rmi.RemoteException;

import copromes.commonInterfaces.IMessengerManager;
import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;
import copromes.server.databaseService.DatabaseManager;
import copromes.server.networkService.Client;
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

	@Override
	public Message sendMessage(User author, String message, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		Message msg = dbManager.createMessage(author, message, chatRoom);
		for (Client client : server.clients) {
			try {
				client.client.recieveMessage(author, msg);
			} catch (RemoteException e) {
				server.clients.remove(client);
			}
		}

		return msg;
	}

	@Override
	public ChatRoom createChatRoom(User user, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChatRoom addUserToChatRoom(User user, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChatRoom deleteUserFromChatRoom(User user, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteChatRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub

	}
}
