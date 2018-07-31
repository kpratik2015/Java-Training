
public class DisplayDataSqlTable {

	public static void main(String[] args) {
		String[][] data = {
				{"P101", "Nokia Handset", "Some Description", "2000.0"},
				{"P102", "Samsung Handset", "Description", "20000.0"},
				{"P103", "Sony Ericsson Handset", "Again Some Description", "1500.0"},
				{"P104", "LG Handset", "No Description", "1000.0"},
		};
		
		String[] colNames = {"ID", "Name", "Description", "Price"};

		int[] maxlen = new int[colNames.length];
		
		for(int i = 0; i < colNames.length ; i++) {
			
			for(int j = 0 ; j < colNames.length ; j++) {
				
				if(data[j][i].length() > maxlen[i])
					maxlen[i] = data[j][i].length();
				
			}
			
		}
		
		printBoundry(maxlen);
		
		ColRow(colNames, maxlen);
		
		printBoundry(maxlen);
		
		DataRow(data, maxlen);
				
		printBoundry(maxlen);
		
	}
	
	public static String padRight(String s, int n) {
	     return String.format("%1$" + n + "s", s);  
	}

	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}
	
	public static void printBoundry(int[] maxlen) {
		System.out.print("+-");
		for(int i = 0 ; i < maxlen.length ; i++) {
			if( i == maxlen.length-1) {
				System.out.print(
						String.format("%"+maxlen[i]+"s", "").replace(' ', '-') + 
						"-+");
				break;
			}
				
			
			System.out.print(
					String.format("%"+maxlen[i]+"s", "").replace(' ', '-') + 
					"-+-");
		}
		System.out.println();
		
	}
	
	public static void DataRow(String[][] arr, int[] maxlen) {
		for(int i = 0; i < maxlen.length ; i++) {
			
			for(int j = 0 ; j < maxlen.length ; j++) {
				System.out.print(
						"| " + arr[i][j]+ 
				
				padRight("", maxlen[j] - arr[i][j].length() + 1 ) );
			}
			
			System.out.print("|");
			System.out.println();
			
		}
	}
	
	public static void ColRow(String[] arr, int[] maxlen) {
		for(int i = 0 ; i < arr.length ; i++) {
			
			System.out.print(
			"| " 
			+ arr[i] 
			+ padRight("", maxlen[i] - arr[i].length() ) 
			+ " "
			);
			
		}
		System.out.print("|");
		System.out.println();
		
	}
	
}
