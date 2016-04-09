package sextoEjemplo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainFile {
	private class DataSourceLoader implements Runnable {
		public void run() {
			System.out.printf("Beginning data sources loading: %s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Data sources loading has finished: %s\n", new Date());
		}
	}

	private class NetworkConectionsLoader implements Runnable {
		public void run() {
			System.out.printf("Connecting network loading: %s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(6);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Network connection has finished: %s\n", new Date());
		}
	}

	public static void main(String[] args) {
		MainFile mainFile = new MainFile();
		DataSourceLoader dataSourceLoader = mainFile.new DataSourceLoader();
		Thread thread1 = new Thread(dataSourceLoader);
		NetworkConectionsLoader networkConectionsLoader = mainFile.new NetworkConectionsLoader();
		Thread thread2 = new Thread(networkConectionsLoader);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main: Configuration has been loaded: %s\n", new Date());
	}
}
