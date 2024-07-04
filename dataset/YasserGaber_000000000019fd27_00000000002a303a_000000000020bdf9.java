/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;

public class Solution {
	public static void main(String[] args) {
	    
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
	    String[] str = new String[T];
	   
	    for (int i = 0; i < T; i++) {
	        int N = scanner.nextInt();
	        byte[] cSchedule = new byte[1440];
	        byte[] jSchedule = new byte[1440];
	        str[i] = "";
	        
	        for (int j = 0; j < N; j++) {
	            int t1 = scanner.nextInt();
	            int t2 = scanner.nextInt();
	            boolean cFree = true;
	            boolean jFree = true;
	            
	            for (int k = t1; k < t2; k++) {
	                if (cSchedule[k] != 0)
	                    cFree = false;
	                
	                if (jSchedule[k] != 0)
	                    jFree = false;
	            }
	            
	            if (cFree) {
	                for (int k = t1; k < t2; k++) cSchedule[k] = 1;
	                str[i] += "C";
	                continue;
	            }
	            
	            if (jFree) {
	                for (int k = t1; k < t2; k++) jSchedule[k] = 1;
	                str[i] += "J";
	                continue;
	            }
	                str[i] = "IMPOSSIBLE";
	                continue;
	        }
	   }
	    for (int i = 1; i <= T; i++) System.out.println("Case #" + i + ": " + str[i - 1]);
	}
}
