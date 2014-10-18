package copromes.client.gUserInterfaceLayer;

import java.util.Random;

import copromes.client.authorizationLayer.*;
import copromes.client.contactsLayer.contactsManager;
import copromes.client.messengerLayer.*;


public class WindowManager {

	private Messenger messenger;
	private AuthorizationManager authManager;
	private contactsManager contactsManager;

	public WindowManager() {
		// Здесь должна проиходить подготовка к инициализации гуёв и должны
		// инициализироваться остальные слои - их методы будут дёргаться в
		// зависимости от юзер-инпута (см. ниже)
		messenger = new Messenger(null);
		authManager = new AuthorizationManager(null);

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

		// Повторюсь, что это даже не заготовка, а всего лишь псевдозаготовка -
		// нужно не просто посылать эти запросы другим слоям, но и обрабатывать
		// их корректно

		// Кроме того, надо будет добавить возможность внешних уведомлений -
		// например, о том, что пришло сообщение или ещё чо
		// Это можно сделать с помощью observer pattern, например

	}

}
