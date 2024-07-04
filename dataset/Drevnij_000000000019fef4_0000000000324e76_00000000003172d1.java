
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    
		    int t = in.nextInt();  
		    for (int xx = 1; xx <= t; xx++) {
		    	int n = in.nextInt();  
		    	int d = in.nextInt();  
		    	
		    	boolean isDouble = false;
		    	boolean isTriple= false;
		    	long max=0;
		    	
		    	Map<Long, Integer> slices = new HashMap<>();
		    	Set<Long> set = new HashSet<>();
		    	for (int i=0; i<n; i++) {
		    		long cur = in.nextLong();
		    		set.add(cur);
		    		if (cur>max) max=cur;
		    		if (slices.containsKey(cur)) {
		    			int s = slices.get(cur);
		    			s++;
		    			if (s==2) isDouble=true;
		    			if (s==3) isTriple=true;
		    			slices.put(cur, s);
		    		} else slices.put(cur, 1);
		    	}
		    	
		    	int result=0;
		    	
		    	if (d==2) {
		    		if (!isDouble) result=1;
		    	} else {
		    		if (isTriple) result=0;
		    		else {
		    			result=2;
		    			for (Map.Entry<Long, Integer> e: slices.entrySet()) {
		    				if (e.getValue()==2 && e.getKey() != max) {
		    					result =1;
		    					break;
		    				}
		    				for (long i: set) {
		    					if (i/2 == e.getKey()) {
		    						result =1;
		    						break;
		    					}
		    				}
		    			}
		    		}
		    	}
		    	
		    	
		    	System.out.println("Case #"+ xx+": "+result);

		    }
		}
	  

	  

}