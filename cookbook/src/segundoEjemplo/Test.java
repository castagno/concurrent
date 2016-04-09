package segundoEjemplo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;

public class Test {
	
	public static void main(String[] args) {
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Calculator(i));
			if((i%2)==0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread"+i);
		}
		try {
			FileWriter file = new FileWriter(".\\data\\log.txt");
			PrintWriter printWriter = new PrintWriter(file);
			for(int i = 0; i < 10; i++){
				printWriter.println("Main: Status of Thread"+i+" :"+threads[i].getState());
				status[i]=threads[i].getState();
			}
			for(int i = 0; i < 10; i++){
				threads[i].start();
			}
			
			boolean finish = false;
			while(!finish){
				for(int i = 0; i < 10; i++){
					if(threads[i].getState()!=status[i]){
						writeThreadInfo(printWriter, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}
				finish = true;
				for(int i = 0; i < 10; i++){
					finish = finish && (threads[i].getState()==State.TERMINATED);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	private static void writeThreadInfo(PrintWriter printWriter, Thread thread, State state){
		printWriter.printf("Main :ID %d - %s\n", thread.getId(), thread.getName());
		printWriter.printf("Main :Priority: %d\n", thread.getPriority());
		printWriter.printf("Main :Old State: %s\n", state);
		printWriter.printf("Main :New State: %s\n", thread.getState());
		printWriter.printf("Main :*************************\n", thread.getId(), thread.getName());
	}
	
}