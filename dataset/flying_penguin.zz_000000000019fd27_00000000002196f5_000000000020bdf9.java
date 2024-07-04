
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int N = in.nextInt();
				boolean[] c = new boolean[24*60+1];
				boolean[] j = new boolean[24*60+1];
		    	
		    	String res = "";
		    	
		    	int s=0,e=0;
		    	boolean imp = false;
				for(int i=0; i<N;i++){
					s = in.nextInt();
					e = in.nextInt();
					
					if(!c[s] && !c[e]){
						for(int k=s+1; k<e; k++){ c[k]=true; }
						res += "C";
					}
					else if(!j[s] && !j[e]){
						for(int k=s+1; k<e; k++){ j[k]=true; }
						res += "J";
					}
					else { imp = true; }
					
					
				}
		    	if(imp) res = "IMPOSSIBLE";
		    	
		    	
		    	System.out.println("Case #"+t+ ": " + res);
		      
		    }

	}

	
	
	
}
