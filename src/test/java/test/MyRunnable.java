package test;

public class MyRunnable implements Runnable{
	
	private Foo foo=new Foo();
	
	@Override
	public void run() {
		for(int i=0;i<3;i++){
			this.fix(30);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":当前Foo对象的x值="+foo.getX());
		}
		
	}
	
	public int fix(int y){
		return foo.fix(y);
	}
	
	public static void main(String[] args) {
		MyRunnable mR=new MyRunnable();
		Thread threadA=new Thread(mR);
		Thread threadB=new Thread(mR);
		threadA.start();
		threadB.start();
	}
}
