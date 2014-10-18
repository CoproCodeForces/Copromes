package copromes.client.initializationLayer;

import copromes.client.authorizationLayer.AuthorizationManager;
import copromes.client.contactsLayer.ContactsManager;
import copromes.client.gUserInterfaceLayer.*;
import copromes.client.messengerLayer.Messenger;
import copromes.client.networkLayer.Client;
import copromes.client.serverResponseHandler.ResponseHandler;

//Стоит подумать над именем базового класса
public class Main {

	private final static int serverPort = 7331;
	private final static int clientPort = 13337;
	private final static String host = "192.168.0.0";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Client client = new Client(serverPort, host);
			client.setInterfaces();
			AuthorizationManager authManager = new AuthorizationManager(client);
			ContactsManager contactsManager = new ContactsManager(client);
			Messenger messenger = new Messenger(client);
			ResponseHandler responseHandler = new ResponseHandler(clientPort);
			responseHandler.setupClientHost();
		} catch (Exception e) {
		}

		// Инициализируем гуи: пока не знаю, что там должно быть
		WindowManager windowManager = new WindowManager();
		windowManager.start();

		// Сейчас осознал, что вместо WindowManager должен быть интерфейс,
		// который сначала будет реализовывать
		// какой-нибудь ConsoleManager, а затем и WindowManager. Кто-нибудь,
		// поменяйте плиз потом

	}
}
