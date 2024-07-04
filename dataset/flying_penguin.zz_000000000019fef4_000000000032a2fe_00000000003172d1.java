
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
			for (int t = 1; t <= T; t++) {
		    	int N = in.nextInt();
		    	int D = in.nextInt();
		    	//for(int i=0; i<len;i++) words[i] = in.next();
		    	
		    	long[] nano = new long[N];
		    	HashMap<Long,Integer> hm = new HashMap<>(); 
		    	for(int i=0; i<N; i++){
		    		nano[i]=in.nextLong();
		    		if(hm.containsKey(nano[i])) 
		                hm.put(nano[i],hm.get(nano[i]) + 1); 
		            else
		                hm.put(nano[i], 1);  
		    	}
		    	int res = 0;
		    	int max = 0;
		    	long maxval = 0;
		    	for (Map.Entry<Long,Integer> entry : hm.entrySet()){  
		            long l = entry.getKey(); 
		    		int n = entry.getValue();
		    		if(n==D) {res = 0;break;}
		    		if(n>max) {
		    			max=n;maxval = l;
		    		}
		    	}
		    	
		    	res = D/max;
		    	
		    	
		    	System.out.println("Case #"+t+": "+res);
		      
		    }

	}

}
