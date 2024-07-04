import java.io.*;
import java.lang.*;
import java.util.*;
public class Solution {
    
    	public static void main (String[] args) throws IOException
	{     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int t = Integer.parseInt(br.readLine());
	      int no=1;
	      while(t-->0){
	           String s=br.readLine();
	           String y="";
	           int end=0;
	            int e=0;
	           for(int i=0;i<s.length();i++){
	           int x=Integer.parseInt(s.substring(i,i+1));
	          // System.out.println(x);
	          
	           if(x>end){
	               for(int j=0;j<x-end;j++){
	                   y=y+"(";
	                   e++;
	               }
	            //   System.out.println(e);
	               end=e;
	               y=y+s.charAt(i);
	           }
	               else{
	                   for(int j=0;j<end-x;j++){
	                       y=y+")";
	                       e--;
	                   }
	                   end=e;
	                   y=y+s.charAt(i);
	               }
	           }
	           for(int i=0;i<end;i++) y=y+")";
	      
	      System.out.println("Case #"+no+": "+y);
	      no++;
	  }
	  
		  
	}
}