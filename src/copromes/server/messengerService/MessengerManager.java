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
	public void sendMessage(final User author, String message, ChatRoom chatRoom) {
		// database manager exceptions should be added here
		final Message msg = dbManager.createMessage(author, message, chatRoom);
		System.out.println("message created");
		for (final Client client : server.clients) {
			System.out.println("sending message for " + client.host + " "
					+ client.user.getName());
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						if (client.client == null) {
							System.out.println("client is null ffs");
						} else {
							client.client.recieveMessage(author, msg);
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						System.out.println("caught exception");
						e.printStackTrace();
						server.clients.remove(client);
					}
				}
			}).start();
		}
	}

	@Override
	public ChatRoom createChatRoom(User user, String name) {
		// database manager exceptions should be added here
		ChatRoom chatRoom = dbManager.createChatRoom(user, name);
		return chatRoom;
	}

	@Override
	public void addUserToChatRoom(User user, ChatRoom chatRoom) {
		// database manager exceptions should be added here
		dbManager.addUserToChatRoom(user, chatRoom);
		for (Client client : server.clients) {
			try {
				if (chatRoom.getUsers().contains(client.user)) {
					client.client.updateChatRoom(chatRoom);
				}
			} catch (RemoteException e) {
				server.clients.remove(client);
			}
		}
	}

	@Override
	public void deleteUserFromChatRoom(User user, ChatRoom chatRoom) {
		// database manager exceptions should be added here
		dbManager.deleteUserFromChatRoom(user, chatRoom);
		for (Client client : server.clients) {
			try {
				client.client.updateChatRoom(chatRoom);
			} catch (RemoteException e) {
				server.clients.remove(client);
			}
		}
	}

	@Override
	public void deleteChatRoom(ChatRoom chatRoom) {
		// database manager exceptions should be added here
		dbManager.deleteChatRoom(chatRoom);
		for (Client client : server.clients) {
			try {
				client.client.removeChatRoom(chatRoom);
			} catch (RemoteException e) {
				server.clients.remove(client);
			}
		}
	}
}
