package demo;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		demo();
		
		
		try {
			demo2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void demo() {
		

		try {
			
			System.out.println("Helol world ....");
			int i = 1/0;
			System.out.println("Completed");
			
		} catch (Exception e) {
			
			System.out.println("I am inside the catch block");
			System.out.println("Message is: "+e.getMessage());
			System.out.println("Cause is: "+ e.getCause());
			e.printStackTrace();
		}finally {
			System.out.println("I am inside finally block");
		}
		
		
	}
	
public static void demo2() throws Exception{
		
			
			System.out.println("Helol world ....");
			int i = 1/0;
			System.out.println("Completed");
		
		
	}
	
}
