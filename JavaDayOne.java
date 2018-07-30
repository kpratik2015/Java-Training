import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class JavaDayOne {

	public static void main(String[] args) throws ParseException {
		
		System.out.println(cipher("Y"));
		
		// Get time of different timezone
		
		System.out.println("Available IDs:");
		for( String availID : TimeZone.getAvailableIDs()) {
			System.out.print(availID + " ");
		}
		System.out.println();
		
		TimeZone anotherTz = TimeZone.getTimeZone("Indian/Mauritius");
		Calendar currentdate = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
		formatter.setTimeZone(anotherTz);
		System.out.println(formatter.format(currentdate.getTime()));
		
		// ----------------------------
		
		System.out.println(DayOfWeek(10, 10, 2010));
		
		System.out.println(GetAge("12/03/1996"));

		System.out.println("Days to go: " + getDaysCountdown(2,8,2018));
	
		// ----------------------------
		
		System.out.println("Max Memory: " + getMaxMemory() / (1024*1024) + " mb");
		System.out.println("Total Memory: " + getTotalMemory() / (1024*1024) + " mb");
		System.out.println("Free Memory: " + getFreeMemory() / (1024*1024) + " mb");
		System.out.println("Used Memory: " + getUsedMemory() / (1024*1024) + " mb");
		
		// ----------------------------
		
		
		
		
		
	}
	
	public static char[] cipher( String text ) {
		char[] charArray = text.toCharArray();
		for(int i = 0 ; i < text.length(); i++) {
			if( text.charAt(i) == 'y' || text.charAt(i) == 'Y' )
				charArray[i] = (char)((int) text.charAt(i) - 24);
			else if(text.charAt(i) == 'z' || text.charAt(i) == 'Z' )
				charArray[i] = (char)((int) text.charAt(i) - 24);
			else 
				charArray[i] = (char) (text.charAt(i) + 2);
		}
		return charArray;
	}
	
	public static String GetAge( String dob ) {
		int age = 0;
		String[] parts = dob.split("/");
		Calendar dateOfBirth = Calendar.getInstance();
	    Calendar today = Calendar.getInstance();

	    dateOfBirth.set(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
	    
	    age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
	    
	    if (today.get(Calendar.DAY_OF_YEAR) < dateOfBirth.get(Calendar.DAY_OF_YEAR)){
	        age--; 
	    }

	    Integer ageInt = new Integer(age);
	    String ageS = ageInt.toString();
	    
		
		return ageS;
	}
	
	public static String DayOfWeek(int d, int m, int y) throws ParseException {
		
		String input_date = Integer.toString(d) + "/" + Integer.toString(m) + "/" + Integer.toString(y);

		Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(input_date);
		
		String finalDay = new SimpleDateFormat("EEEE").format(dt);
		
		return finalDay;
	}
	
	public static String getDaysCountdown(int d, int m, int y) throws ParseException {
		
		String input_date = Integer.toString(d) + "/" + Integer.toString(m) + "/" + Integer.toString(y);
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date1 = myFormat.parse(input_date);
		Date date2 = new Date();
		long diff = date1.getTime() - date2.getTime();
		
		return Float.toString(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		
	}
	
	
	public static long getMaxMemory() {
	    return Runtime.getRuntime().maxMemory();
	}

	public static long getUsedMemory() {
	    return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	public static long getTotalMemory() {
	    return Runtime.getRuntime().totalMemory();
	}

	public static long getFreeMemory() {
	    return Runtime.getRuntime().freeMemory();
	}
	
	
}
