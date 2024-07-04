
/*
ID: brianch4
LANG: JAVA
TASK: Solution
*/
import java.io.*;
import java.util.*;

class Solution {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("testing1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("testing1.out")));

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
    		if(temp>open)
    		{
                int temp2 = open; 
    			for(int j = 0; j < temp-temp2; j++) {
    				same.add(i+added,"("); 
    				added++; 
    				open++; 
    			}
    		}
    		if(temp<open)
    		{
                int temp2 = open; 
    			for(int j = 0; j < temp2-temp; j++) {
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
    	out.printf("Case #%d: %s\n",num+1,result); 

    }
    out.close(); 
    f.close(); 
  }
}