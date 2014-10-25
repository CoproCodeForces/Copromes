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
	public Message sendMessage(String message, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return null;
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
