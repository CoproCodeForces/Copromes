package copromes.commonInterfaces;

import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public interface IClientInterfaces {
	
	String sendMessage(User user, Message message);
	void isConnected();
}
