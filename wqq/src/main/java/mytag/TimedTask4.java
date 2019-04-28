package mytag;

import java.util.Date;

public class TimedTask4 {
	
	
	
	private static void useThreadImplTimedTask(){
		Runnable runnable=new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					System.out.println(new Date());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread thread=new Thread(runnable);
		thread.start();
	}
	public static void main(String[] args) {
		useThreadImplTimedTask();
	}
}
