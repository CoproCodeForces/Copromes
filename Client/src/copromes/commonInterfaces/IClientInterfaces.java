package copromes.commonInterfaces;

import java.rmi.Remote;

import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public interface IClientInterfaces extends Remote{
	
	String sendMessage(User user, Message message);
	void isConnected();
}
