package copromes.client.messengerLayer;

import copromes.client.networkLayer.Client;
import copromes.commonInterfaces.IMessengerManager;

public class Messenger implements IMessengerManager {
	private Client client;
	public Messenger(Client client){
		this.client = client;
	}
}
