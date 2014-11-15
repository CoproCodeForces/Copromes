package copromes.client.networkLayer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import copromes.client.serverResponseHandler.ResponseHandler;
import copromes.commonInterfaces.IServerResponseManager;

public class ServerResponseHost {

	private ResponseHandler responseHandler;
	private int port;
	private Registry registry;

	public ServerResponseHost(ResponseHandler responseHandler, int port) {
		this.responseHandler = responseHandler;
		this.port = port;
		try {
			registry = LocateRegistry.createRegistry(port);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setupClientHost() {
		try {
			IServerResponseManager servStub = (IServerResponseManager) UnicastRemoteObject
					.exportObject(responseHandler, port);
			registry.rebind("serverResponseManager", servStub);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
