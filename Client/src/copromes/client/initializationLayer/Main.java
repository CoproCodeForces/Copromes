package copromes.client.initializationLayer;

import copromes.client.gUserInterfaceLayer.*;

//Стоит подумать над именем базового класса
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Инициализируем гуи: пока не знаю, что там должно быть
		WindowManager windowManager = new WindowManager();
		windowManager.start();
		
		//Сейчас осознал, что вместо WindowManager должен быть интерфейс, который сначала будет реализовывать
		//какой-нибудь ConsoleManager, а затем и WindowManager. Кто-нибудь, поменяйте плиз потом

	}

}
