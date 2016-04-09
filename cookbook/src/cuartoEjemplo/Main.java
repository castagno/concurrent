package cuartoEjemplo;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		FileSearch searcher=new FileSearch("/","initrd.img");
		Thread thread=new Thread(searcher);
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
		
	}

}
