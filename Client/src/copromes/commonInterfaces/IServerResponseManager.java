package copromes.commonInterfaces;

import java.rmi.Remote;

import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public interface IServerResponseManager extends Remote{
	
	void recieveMessage(User user, Message message);
	void isConnected();
}
