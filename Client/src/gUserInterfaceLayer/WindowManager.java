package gUserInterfaceLayer;

import java.util.Random;

import networkLayer.Client;
import authorizationLayer.*;
import messengerLayer.*;

public class WindowManager {

	private Messenger messenger;
	private AuthorizationManager authorizator;
	private Client client;

	public WindowManager() {
		// Здесь должна проиходить подготовка к инициализации гуёв и должны
		// инициализироваться остальные слои - их методы будут дёргаться в
		// зависимости от юзер-инпута (см. ниже)
		client = new Client();
		messenger = new Messenger(client);
		authorizator = new AuthorizationManager(client);

	}

	public void start() {
		// 1) Инициализируем гуи, будь то окна или консоль
		initialize();
		// 2) Начниаем слушать то или иное событие - в зависимости от него мы
		// реагируем тем или иным образом
		startListening();
	}

	private void initialize() {
		// Осуществляем инициализацию; вполне возможно, что этого метода потом
		// не будет, и мы запихнём его содержимое в start()
	}

	private void startListening() {
		// В зависимости от того, какой библиотекой будем пользоваться,
		// реализация может значительно меняться

		// Пока наивный, грубый метод выглядит примерно так:

		int eventType;
		Object eventData = null;

		while (3 < 5) {
			eventType = new Random().nextInt(5);

			switch (eventType) {
			case 1:
				authorizator.authorize(eventData);
				break;
			case 2:
				authorizator.register(eventData);
				break;
			case 3:
				messenger.sendMessage(eventData);
				break;
			default:
				break;
			}
		}

		// Повторюсь, что это даже не заготовка, а всего лишь псевдозаготовка -
		// нужно не просто посылать эти запросы другим слоям, но и обрабатывать
		// их корректно

		// Кроме того, надо будет добавить возможность внешних уведомлений -
		// например, о том, что пришло сообщение или ещё чо
		// Это можно сделать с помощью observer pattern, например

	}

}
