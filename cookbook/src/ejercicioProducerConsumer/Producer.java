package ejercicioProducerConsumer;

public class Producer implements Runnable {
	private EventStorage storage;
	
	public Producer(EventStorage storage){
		this.storage=storage;
	}
	
	@Override
	public void run() {
		for (int i=0; i<100; i++){
			storage.set();
			try {
//				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}