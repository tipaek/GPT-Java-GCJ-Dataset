

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
    	   String x = in.next();
    	   int[]diffarr = new int [x.length() + 1];
   		char[] arr = x.toCharArray();
   		int[] intarr = new int[x.length()];
   		for (int i = 0; i < x.length(); i++) {
   			intarr[i] = (int)arr[i] - 48;
   		}
   		diffarr[0] = intarr[0];
   		diffarr[x.length()] = -1* intarr[x.length()-1];
   		for (int i = 1; i<intarr.length; i++) {
   			diffarr[i] = intarr[i]-intarr[i-1];
   		}
   		//diffarr good ^
   		//convert diffarr into ()
   		String[] strArray = new String[diffarr.length];
   		for (int b=0; b<strArray.length; b++) {
   			strArray[b] = "";
   		}
   		for (int i = 0; i<diffarr.length; i++) {
   			if (diffarr[i]>0) {
   				while (diffarr[i] > 0)
   	   			{
   	   				strArray[i] = strArray[i] + "(";
   	   				diffarr[i]--;
   	   			}
   			}
   			else if (diffarr[i]==0) {
   				strArray[i] = "";
   			}
   			else 
   			{
   				while (diffarr[i] < 0)
   	   			{
   					strArray[i] = strArray[i] + ")";
   					diffarr[i]++;
   	   			}
   			}
   		}
   		String str = "";
   		for (int i = 0; i<diffarr.length-1; i++) {
   			str = str + strArray[i]+ intarr[i]; 
   		}
   		str = str + strArray[strArray.length-1];
	    	System.out.println ("Case #" + a +": " + str);
    	}
    }    
}
