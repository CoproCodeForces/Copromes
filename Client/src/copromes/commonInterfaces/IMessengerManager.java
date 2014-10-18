package copromes.commonInterfaces;

import java.rmi.Remote;

import copromes.domainLayer.Message;

public interface IMessengerManager extends Remote {
	Message sendMessage(String message);
	

}
