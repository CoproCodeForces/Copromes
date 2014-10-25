package copromes.server.networkService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import copromes.commonInterfaces.IServerResponseManager;
import copromes.domainLayer.User;

public class Client extends Thread {
		
	private String host;
	private User user;
	private Registry registry;
	private final int port = 13337;
	
	public IServerResponseManager client;
	
	public Client(User user, String host) throws RemoteException, NotBoundException {
		this.user = user;
		this.host = host;		
	}
	
	@Override
	public void run() {
		try {
			getClientHost();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getClientHost() throws RemoteException, NotBoundException {
		registry = LocateRegistry.getRegistry(host, port);
		client = (IServerResponseManager) registry.lookup("serverResponseManager");
	}
}
