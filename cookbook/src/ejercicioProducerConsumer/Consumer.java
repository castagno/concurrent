package ejercicioProducerConsumer;

public class Consumer implements Runnable {
	private EventStorage storage;
	
	public Consumer(EventStorage storage){
		this.storage=storage;
	}
	
	@Override
	public void run() {
		for (int i=0; i<100; i++){
	    	storage.get();
			try {
//				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	}
}