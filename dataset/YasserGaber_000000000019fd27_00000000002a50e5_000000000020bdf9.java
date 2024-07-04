import java.util.*;

public class Solution {
	public static void main(String[] args) {
	    
	    Scanner scanner = new Scanner(System.in);
	    int T = scanner.nextInt();
	    String[] str = new String[T];
	   
	    for (int i = 0; i < T; i++) {
	        int N = scanner.nextInt();
	        byte[] schedule = new byte[1440];
	        str[i] = "";
	        
	        for (int j = 0; j < N; j++) {
	            int t1 = scanner.nextInt();
	            int t2 = scanner.nextInt();
	            boolean cFree = true;
	            boolean jFree = true;
	            
	            for (int k = t1; k < t2; k++) {
	                if ((schedule[k] % 10) != 0)
	                    cFree = false;
	                
	                if ((schedule[k] / 10) != 0)
	                    jFree = false;
	            }
	            
	            if (cFree) {
	                for (int k = t1; k < t2; k++) schedule[k] += 1;
	                str[i] += "C";
	                continue;
	            }
	            
	            if (jFree) {
	                for (int k = t1; k < t2; k++) schedule[k] += 10;
	                str[i] += "J";
	                continue;
	            }
	                str[i] = "IMPOSSIBLE";
	                break;
	        }
	   }
	    for (int i = 1; i <= T; i++) System.out.println("Case #" + i + ": " + str[i - 1]);
	}
}
