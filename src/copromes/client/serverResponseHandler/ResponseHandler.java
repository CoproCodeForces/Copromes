package copromes.client.serverResponseHandler;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import copromes.commonInterfaces.IServerResponseManager;
import copromes.domainLayer.Message;
import copromes.domainLayer.User;

public class ResponseHandler implements IServerResponseManager {
	private final int port;
	private Registry registry;

	public ResponseHandler(int port) throws RemoteException {
		this.port = port;
		registry = LocateRegistry.createRegistry(port);
	}

	public void setupClientHost() {
		try {
			IServerResponseManager servStub = (IServerResponseManager) UnicastRemoteObject
					.exportObject(this, port);
			registry.rebind("serverResponseManager", servStub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void recieveMessage(User user, Message message) {
		// TODO Auto-generated method stub
	}

	@Override
	public void isConnected() {

	}

}
