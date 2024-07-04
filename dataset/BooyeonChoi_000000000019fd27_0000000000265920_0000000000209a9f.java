/*
ID: brianch4
LANG: JAVA
TASK: Solution
*/
import java.io.*;
import java.util.*;

class Solution {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

    int numCases = Integer.parseInt(f.readLine()); 

    for(int num = 0; num < numCases; num++) {

    	String x = f.readLine(); 
    	ArrayList<String> casex = new ArrayList<String>(); 
    	for(int i = 0; i < x.length(); i++) {
    		casex.add(""+x.charAt(i));
    	}
    	ArrayList<String> same = new ArrayList<String>(); 
    	for(int i = 0; i < casex.size(); i++) {
    		same.add(casex.get(i)); 
    	}
    	int open = 0; 
    	int added=0; 
    	for(int i = 0; i < casex.size(); i++) {
    		int temp = Integer.parseInt(casex.get(i));
    		System.out.println(temp); 
    		if(temp>open)
    		{
    			for(int j = 0; j < temp-open; j++) {
    				same.add(i+added,"("); 
    				added++; 
    				open++; 
    			}
    		}
    		if(temp<open)
    		{
    			for(int j = 0; j < open-temp; j++) {
    				same.add(i+added,")"); 
    				added++; 
    				open--; 
    			}
    		}
    	}
    	while(open>0)
    	{
    		same.add(")"); 
    		open--; 
    	}
    	String result = ""; 
    	for(int i = 0; i < same.size(); i++) {
    		result+=same.get(i); 
    	}
    	System.out.printf("Case #%d: %s\n",num+1,result); 

    }

    f.close(); 
  }
}