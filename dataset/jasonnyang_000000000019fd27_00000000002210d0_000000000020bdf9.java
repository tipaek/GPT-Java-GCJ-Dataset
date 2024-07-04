

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Solution
{
    public static void main (String[] args) 
	{
    	 Scanner in = new Scanner(System.in);
		 int t = in.nextInt();
       for(int a = 1 ; a <= t; a++){
    	   int x = in.nextInt();
    	   String s = "";
    	   int[] arr = new int [x];
    	   int[] arr2 = new int [x];
    	   Set<Integer> set = new HashSet<Integer>();
    	   Set<Integer> set2 = new HashSet<Integer>();
    	   boolean test = false;
    	  
    	   for (int i=0; i<x; i++) {
    		   arr[i] = in.nextInt();
    		   arr2[i]= in.nextInt();
    	   }
    	   for (int i=0; i<x; i++) {
    		   boolean s1=false;
	    	   boolean s2=false;
    		   for (int c = arr[i]; c<=arr2[i]; c++) {
    			  
    			   if (set.contains(c)==false) {
    			   }
    			   else if (set2.contains(c)==false) {
    				   s1=true;
    			   }
    			   else {
    				   s1=true; 
    				   s2=true;
    			   }
    			   }
    		   if (s1 == false && s2 == false) {
				   for (int g = arr[i]; g<arr2[i]; g++) {
					   set.add(g);
					   
				   }
				   s=s+"J";
    		   }
			   else if (s1==true && s2 == false) {
					   for (int g = arr[i]; g<arr2[i]; g++) {
						   set2.add(g);
						   
					   }
					   s=s+"C";
				   }
			   else {
					   System.out.println ("Case #" + a +": IMPOSSIBLE" );
					   test=true;
				   }
    		   }
    	   if (test ==false) {
    	   System.out.println ("Case #" + a +": " + s );
    	   }
    	}
    }    
}
