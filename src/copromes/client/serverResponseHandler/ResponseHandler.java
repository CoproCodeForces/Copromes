package copromes.client.serverResponseHandler;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;

import javafx.beans.InvalidationListener;
import copromes.client.gUserInterfaceLayer.WindowManager;
import copromes.client.networkLayer.ServerResponseHost;
import copromes.commonInterfaces.IServerResponseManager;
import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public class ResponseHandler implements IServerResponseManager {
	public WindowManager windowManager;

	public ResponseHandler() throws RemoteException {
		super();
	}

	@Override
	public void recieveMessage(User user, Message message) {
		windowManager.chatWindow.printMessage(message);
	}

	@Override
	public void isConnected() {

	}

	@Override
	public void updateChatRoom(ChatRoom chatRoom) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeChatRoom(ChatRoom chatRoom) throws RemoteException {
		// TODO Auto-generated method stub

	}
}
