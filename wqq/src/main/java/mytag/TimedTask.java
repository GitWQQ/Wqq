package mytag;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimedTask {
	
	
	
	private static void useTimerImplTimedTask(){
		//��һ�����������񣬵ڶ�������Ϊ�״�ִ�е���ʱʱ�䣬����������Ϊִ�еļ��ʱ�䣬ʱ������λΪ����
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
