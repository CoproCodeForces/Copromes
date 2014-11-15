package copromes.commonInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public interface IMessengerManager extends Remote {
	void sendMessage(User author, String message, ChatRoom chatRoom) throws RemoteException;
	ChatRoom createChatRoom(User author, String name) throws RemoteException;
	void addUserToChatRoom(User user, ChatRoom chatRoom) throws RemoteException;
	void deleteUserFromChatRoom(User user, ChatRoom chatRoom) throws RemoteException;
	void deleteChatRoom(ChatRoom chatRoom) throws RemoteException;
	
}
