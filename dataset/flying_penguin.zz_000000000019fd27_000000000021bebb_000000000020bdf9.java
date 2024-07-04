
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int N = in.nextInt();
				boolean[] cs = new boolean[24*60+1];
				boolean[] ce = new boolean[24*60+1];
				boolean[] js = new boolean[24*60+1];
				boolean[] je = new boolean[24*60+1];
		    	
		    	String res = "";
		    	
		    	int s=0,e=0;
		    	boolean imp = false;
				for(int i=0; i<N;i++){
					s = in.nextInt();
					e = in.nextInt();
					//0 1, 2 3, 1 2, 0 2 
					// 0=0~1, 1=1~2, 2=2~3, 3=3~4, 4=4~5
					if(!cs[s] && !ce[e]){
						cs[s]=true; ce[e]=true;
						for(int k=s+1; k<e; k++){ 
							cs[k]=true; ce[k]=true;}
						res += "C";
					}
					else if(!js[s] && !je[e]){
						js[s]=true; je[e]=true;
						for(int k=s+1; k<e; k++){ 
							js[k]=true; je[k]=true;}
						res += "J";
					}
					else { imp = true; }
					
					
				}
		    	if(imp) res = "IMPOSSIBLE";
		    	
		    	
		    	System.out.println("Case #"+t+ ": " + res);
		      
		    }

	}

	
	
	
}
