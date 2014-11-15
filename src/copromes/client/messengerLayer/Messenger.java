package copromes.client.messengerLayer;

import copromes.client.networkLayer.Server;
import copromes.commonInterfaces.IMessengerManager;
import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public class Messenger implements IMessengerManager {
	private Server server;

	public Messenger(Server server) {
		this.server = server;
	}

	@Override
	public void sendMessage(User author, String message, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChatRoom createChatRoom(User user, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserToChatRoom(User user, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserFromChatRoom(User user, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteChatRoom(ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		
	}
}
