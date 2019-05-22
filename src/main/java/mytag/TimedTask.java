package mytag;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimedTask {
	
	
	
	private static void useTimerImplTimedTask(){
		//第一个参数是任务，第二个参数为首次执行的延时时间，第三个参数为执行的间隔时间，时间间隔单位为毫秒
		new Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				System.out.println("Location time is:"+new Date().toString());
			}
		},0,10);
	}
	public  static void main(String [] args){
		useTimerImplTimedTask();
	}
}
