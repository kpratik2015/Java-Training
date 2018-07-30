

public class HowStringWorks {
		
	/*
	 * THEORY
	 * 
	 * Heap is where all the objects are kept
	 * 
	 * s1 and s2 point to same java in STRING POOL
	 * The strings that are hardcoded in code are put into string pool
	 * 
	 * s3 and s4 are differently allocated memory in heap
	 * Dynamic string i.e. string content produced at runtime will be on heap or one with new
	 */
	
	
	public static void main(String[] args) {
		
		
		// One object and sharing of memory address
		String s1 = "Java";
		String s2 = "Java";
		
		// Two objects.
		String s3 = new String("Java");
		String s4 = new String("Java");
		
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		
		String s5 = s1.toUpperCase();
		String s6 = "JAVA";
		System.out.println(s5 == s6);
	
	}
	
}
