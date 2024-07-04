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

    int numCases = Integer.parseInt(f.readLine()); 

    for(int num = 0; num < numCases; num++) {

    	int numTests = Integer.parseInt(f.readLine()); 

    	HashSet<Integer> j = new HashSet<Integer>(); 
    	HashSet<Integer> c = new HashSet<Integer>(); 

    	boolean finalCheck = true; 
    	String result=""; 

    	for(int tests = 0; tests < numTests; tests++) {
    		boolean jCheck = true; 
    		boolean cCheck = true; 
    		String[] times = f.readLine().split(" "); 
    		ArrayList<Integer> time = new ArrayList<Integer>(); 
    		time.add(Integer.parseInt(times[0])); 
    		time.add(Integer.parseInt(times[1])); 

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
    	if(!finalCheck) System.out.println("IMPOSSIBLE"); 
    	else System.out.println(result); 
    }

    f.close(); 
  }
}