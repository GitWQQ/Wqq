package mytag;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class Helloworld extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int doEndTag() throws JspTagException{
		try {
			pageContext.getOut().write("Helloworld111");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new JspTagException("´íÎó");
		}
		return EVAL_PAGE;
	}

	public static String test(){
		
		
		try{
			System.out.println("one");
			int i=3/1;
			return "two";
		}catch(Exception exception){
			System.out.println("catch");
		}finally {
			System.out.println("three");
		}
		return "four";

	}
	
    public static String test(String aaa){
		
		try{
			System.out.println("one");
			int i=3/1;
			return "two";
		}catch(Exception exception){
			System.out.println("catch");
		}finally {
			System.out.println("three");
		}
		return "four";

	}
    
    

	public static void main(String[] args) {	
		System.out.println(test());
	}
	
	class hello implements Cloneable{
		
	}
}
