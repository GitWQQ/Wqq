package mytag;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimedTask2 {

	
	private static void userScheduledExecutorServiceImplTiemdTask(){
		ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
		// ��һ�����������񣬵ڶ�������Ϊ�״�ִ�е���ʱʱ�䣬����������Ϊ��ʱִ�еļ��ʱ��,���ĸ�������ʱ�䵥λ
		service.scheduleAtFixedRate(new RunnableDemo1(),0L,1L,TimeUnit.SECONDS);
		service.scheduleAtFixedRate(new RunnableDemo2(),0,1,TimeUnit.SECONDS);
	}
	public static void main(String[] args) {
		userScheduledExecutorServiceImplTiemdTask();
	}

}
