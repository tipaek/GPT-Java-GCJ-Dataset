import java.util.*;
import java.util.ArrayList; 
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; i++) {
      String str = "";
      String str1 = "IMPOSSIBLE"; 
      int n = in.nextInt();
      ArrayList<Integer> c = new ArrayList<>();
      ArrayList<Integer> j = new ArrayList<>();
      for(int k = 0; k<n; k++) {
    	  int d = in.nextInt();
    	  int e = in.nextInt();
    	  int f = e-d;
    	  if(k==0) {
    		   for(int l = 0; l<f; l++) {
    			   c.add(d);
    			   d++;
    		   }   
    		   str = str + "C";
    	   }
    	  else {
    		  if(c.contains(d) || c.contains(e)) {
    			  if(j.contains(d) || j.contains(e)) {
    				  str = "IMPOSSIBLE";
    			  }
    			  else {
    				  for(int l = 0; l<f; l++) {
    	    			   j.add(d);
    	    			   d++;
    	    		   }   
    				  str = str + "J";
    			  }
    		  }
    		  else if(j.contains(d) || j.contains(e)){
    			  for(int l = 0; l<f; l++) {
	    			   c.add(d);
	    			   d++;
	    		   }  
    			  str = str + "C";
    		  }
    		  else {
    			  for(int l = 0; l<f; l++) {
	    			   c.add(d);
	    			   d++;	    			   
	    		   }  
    			  str = str + "C";
    		  }
    	  }
      }
      System.out.println("Case #" + i + ": " + str);
    
  }
  }
}