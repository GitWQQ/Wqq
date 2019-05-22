package mytag;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimedTask2 {

	
	private static void userScheduledExecutorServiceImplTiemdTask(){
		ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
		// 第一个参数是任务，第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间,第四个参数是时间单位
		service.scheduleAtFixedRate(new RunnableDemo1(),0L,1L,TimeUnit.SECONDS);
		service.scheduleAtFixedRate(new RunnableDemo2(),0,1,TimeUnit.SECONDS);
	}
	public static void main(String[] args) {
		userScheduledExecutorServiceImplTiemdTask();
	}

}
