package test;

/**
 * 测试扩展Thread类实现的多线程程序
 * @author 16406
 */
public class TestThread extends Thread {
	
	public TestThread(){
		
	}
	public TestThread(String name){
		super(name);
	}
	
	/*public void run(){
		for(int i=0;i<5;i++){
			for(long k=0;k<100000;k++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(this.getName()+" :"+i);
			}
		}
	}*/
	
	public void run(){
		for(int i=0;i<100;i++){
			if(i%10==0){
				System.out.println("----"+i);
			}
			System.out.print(i);
			try {
				Thread.sleep(1000);
				System.out.println(" 线程睡眠100毫秒!\n");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		/*Thread thread=new TestThread("葛柳");
		Thread thread2=new TestThread("张营");
		 System.err.println(thread.currentThread().getName());
		 try {
			thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			thread.start();
		}
		//thread2.start();*/
		new TestThread().start();
	}
		
}
