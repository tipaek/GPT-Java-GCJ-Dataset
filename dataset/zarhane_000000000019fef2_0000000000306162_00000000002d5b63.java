import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		// TEST CASES----------------------------------------------------
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			// READ----------------------------------------------------
		    
		    String ref = "";
		        
	        int lx = -5;
	        int ux = 5;
	        int ly = -5;
	        int uy = 5;
	        
	        for (int x = lx; x <= ux; x++) {
	            for (int y = ly; y <= uy ; y++) {
                    System.out.println(x + " " + y);
	                ref = s.next();
	                if("CENTER".equals(ref))
	                    break;
                }
	            if("CENTER".equals(ref))
                    break;
            }
		    
		    if("WRONG".equals(ref)) {
		        System.exit(0);
		    }
		}
		
		System.exit(0);
	}
}