package test;

/**
 * 实现Runnable接口的类
 * @author 16406
 *
 */
public class RunnableDoString implements Runnable{

	private String name;
	
	public  RunnableDoString(String name) {
		this.name=name;
	}
	
	@Override
	public void run() {
		for (int i=0;i<5;i++){
			for(long k=0;k<2;k++){
				System.out.println(name+":"+i);
			}
		}
		
	}

}
