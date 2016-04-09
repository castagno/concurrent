package tercerEjemplo;

public class Main {

	public static void main(String[] args) {
		PrimeGenerator primeGenerator = new PrimeGenerator();
		Thread task = new Thread(primeGenerator);
		task.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		task.interrupt();
	}

}
