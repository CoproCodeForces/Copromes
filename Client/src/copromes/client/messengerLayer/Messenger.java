package copromes.client.messengerLayer;

import copromes.client.networkLayer.Client;
import copromes.commonInterfaces.IMessengerManager;
import copromes.domainLayer.ChatRoom;
import copromes.domainLayer.Message;

public class Messenger implements IMessengerManager {
	private Client client;

	public Messenger(Client client) {
		this.client = client;
	}

	@Override
	public Message sendMessage(String message, ChatRoom chatRoom) {
		// TODO Auto-generated method stub
		return null;
	}
}
