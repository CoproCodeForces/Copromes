package copromes.commonInterfaces;

import java.rmi.Remote;

import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public interface IMessengerManager extends Remote {
	Message sendMessage(String message, ChatRoom chatRoom);
	ChatRoom createChatRoom(User user, String name);
	ChatRoom addUserToChatRoom(User user, ChatRoom chatRoom);
	ChatRoom deleteUserFromChatRoom(User user, ChatRoom chatRoom);
	void deleteChatRoom(ChatRoom chatRoom);
	
}
