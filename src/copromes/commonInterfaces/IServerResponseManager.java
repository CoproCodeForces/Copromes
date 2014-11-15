package copromes.commonInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public interface IServerResponseManager extends Remote{
	
	void recieveMessage(User user, Message message) throws RemoteException;
	void isConnected() throws RemoteException;
	void updateChatRoom(ChatRoom chatRoom) throws RemoteException;
	void removeChatRoom(ChatRoom chatRoom) throws RemoteException;
}
