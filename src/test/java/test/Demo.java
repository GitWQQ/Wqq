package test;

public class Demo {
	
	public static void main(String[] args) {
		
		String strOne="1000";
		String strTwo="2000";
		String strThree=strOne;
		System.out.println("strOne"+strOne.hashCode());
		System.out.println("strTwo:"+strTwo.hashCode());
		System.out.println(strOne.equals(strThree));
		System.out.println("strThree:"+strThree.hashCode());
	}
}
