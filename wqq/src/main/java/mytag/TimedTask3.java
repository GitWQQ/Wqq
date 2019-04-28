package mytag;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

public class TimedTask3 {
	
	private static void useScheduledThreadPoolExecutorImplTimedTask(){
		
		ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=new ScheduledThreadPoolExecutor
				(1,new BasicThreadFactory.Builder().namingPattern("schedule-pool-%d").daemon(false).build());
		  scheduledThreadPoolExecutor.scheduleAtFixedRate(new Runnable() {
	            @Override
	            public void run() {
	                System.out.println("Local Time is " + new Date().toString());
	            }
	        }, 0L, 1L, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) {
		useScheduledThreadPoolExecutorImplTimedTask();
	}

}
