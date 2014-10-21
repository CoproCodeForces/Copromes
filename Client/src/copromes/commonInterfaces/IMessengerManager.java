package copromes.commonInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public interface IMessengerManager extends Remote {
	Message sendMessage(String message, ChatRoom chatRoom) throws RemoteException;
	ChatRoom createChatRoom(User user, String name) throws RemoteException;
	ChatRoom addUserToChatRoom(User user, ChatRoom chatRoom) throws RemoteException;
	ChatRoom deleteUserFromChatRoom(User user, ChatRoom chatRoom) throws RemoteException;
	void deleteChatRoom(ChatRoom chatRoom) throws RemoteException;
	
}
