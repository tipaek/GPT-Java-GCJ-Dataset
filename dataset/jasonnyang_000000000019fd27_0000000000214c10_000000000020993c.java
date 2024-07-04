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
    	   int sum = 0;
    	   int rows=0;
    	   int col = 0;
    	   boolean dupe = false;
    	   int[][] arr = new int[x][x];
    	   	for (int i = 0; i<x; i++) {
    	   		for (int j=0; j<x; j++) {
    	   			arr[i][j] = in.nextInt();
    	   		}
    	   	}
    	   	//trace
    	   for (int b=0; b<x; b++) {
    		   sum = sum+arr[b][b];
    	   }
    	   //horizontal
    	   for (int g=0; g<x; g++) {
	    	   for (int i = 0; i <x; i++) { 
	    		   for (int j = i + 1; j < x; j++) { 
	    			   if (arr[i][g]==(arr[j][g]) ) 
	    			   {  dupe = true;
	    				   }
	    		   	} 
	    		}
	    	   if (dupe == true) {
	    		   rows++;
	    		   dupe = false;
	    	   }
	    	}
    	   //vertical
    	   for (int g=0; g<x; g++) {
	    	   for (int i = 0; i <x; i++) { 
	    		   for (int j = i + 1; j < x; j++) { 
	    			   if (arr[g][i]==(arr[g][j]) ) 
	    			   {  dupe = true;
	    				   }
	    		   	} 
	    		}
	    	   if (dupe == true) {
	    		   col++;
	    		   dupe = false;
	    	   }
	    	}
    	   System.out.println ("Case #" + a +":" + sum + col + rows);
    	}
    }    
}
