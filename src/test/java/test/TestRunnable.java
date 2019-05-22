package test;

/**
 * 测试Runnable类实现的多线程程序
 * @author 16406
 *
 */
public class TestRunnable {
	public static void main(String[] args) {
		RunnableDoString ds1=new RunnableDoString("阿三");
		RunnableDoString ds2=new RunnableDoString("李四");
		
		Thread t1=new Thread(ds1);
		Thread t2=new Thread(ds2);
		t1.start();
		t2.start();
		
	}
}
