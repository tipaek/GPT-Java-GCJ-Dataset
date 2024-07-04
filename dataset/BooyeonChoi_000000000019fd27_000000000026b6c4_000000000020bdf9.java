
/*
ID: brianch4
LANG: JAVA
TASK: parenting
*/
import java.io.*;
import java.util.*;

class Solution {
	public static void main (String [] args) throws IOException {
	    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	    //BufferedReader f = new BufferedReader(new FileReader("parenting.in"));

	    int numCases = Integer.parseInt(f.readLine()); 

	    for(int num = 0; num < numCases; num++) {

	    	int numTests = Integer.parseInt(f.readLine()); 

	    	HashSet<Integer> j = new HashSet<Integer>(); 
	    	HashSet<Integer> c = new HashSet<Integer>(); 

	    	boolean finalCheck = true; 
	    	String result=""; 

	    	int[][] t = new int[numTests][2]; 

	    	for(int jc = 0; jc < numTests; jc++) {
	    		String[] times = f.readLine().split(" "); 
	    		t[jc][0] = Integer.parseInt(times[0]); 
	    		t[jc][1] = Integer.parseInt(times[1]); 
	    	}

	    	Arrays.sort(t,new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return a[0]-b[0]; 
				}
			});



	    	for(int tests = 0; tests < t.length; tests++) {
	    		boolean jCheck = true; 
	    		boolean cCheck = true; 
	    		
	    		ArrayList<Integer> time = new ArrayList<Integer>(); 
	    		time.add(t[tests][0]); 
	    		time.add(t[tests][1]); 

	    		for(int i = time.get(0); i < time.get(1); i++) {
	    			if(j.contains(i))
	    			{
	    				jCheck=false; 
	    				break; 
	    			}
	    		}
	    		if(jCheck)
	    		{
	    			for(int i = time.get(0); i < time.get(1); i++) {
	    				j.add(i); 
	    			}
	    		}

	    		if(!jCheck)
	    		{
	    			for(int i = time.get(0); i < time.get(1); i++) {
		    			if(c.contains(i))
		    			{
		    				cCheck=false; 
		    				break; 
		    			}
		    		}
		    		if(cCheck)
	    			{
		    			for(int i = time.get(0); i < time.get(1); i++) {
		    				c.add(i); 
		    			}
	    			}
	    		}
	    		if(jCheck)
	    		{
	    			result+="J"; 
	    		}
	    		else if(cCheck)
	    		{
	    			result+="C"; 
	    		}
	    		else
	    		{
	    			finalCheck=false; 
	    		}
	    	}
	    	if(!finalCheck) 
	    	{
	    		result = "IMPOSSIBLE"; 
	    	}
	    	System.out.printf("Case #%d: %s\n",num+1,result);  

	    }

	    f.close(); 
	}
}