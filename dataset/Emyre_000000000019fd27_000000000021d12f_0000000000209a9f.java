/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
		    
		    String S=br.readLine();
		    String S1="";
        		    for(int i=0;i<Integer.parseInt(Character.toString(S.charAt(0)));i++){
        		        S1+="(";
        		    }
        		    if(Integer.parseInt(Character.toString(S.charAt(0)))!=0&&S.charAt(0)!=S.charAt(1)){
        		    S1+=Character.toString(S.charAt(0));}
        		    
        		    
		    int n= S.length();
		  //  System.out.println(S);
		  
		 for(int i=0;i<n;i++){
             
		  if(i>0){
		      if(S.charAt(i)!='0'&&S.charAt(i-1)!='0'){
		          //case they are equal
		          if(Integer.parseInt(Character.toString(S.charAt(i)))==Integer.parseInt(Character.toString(S.charAt(i-1))))
		          S1+=Integer.parseInt(Character.toString(S.charAt(i)));
		          //increasing case
		          if(Integer.parseInt(Character.toString(S.charAt(i)))>Integer.parseInt(Character.toString(S.charAt(i-1))))
		          {
		              for(int j=0;j<Integer.parseInt(Character.toString(S.charAt(i)))-Integer.parseInt(Character.toString(S.charAt(i-1)));j++){
		                  S1+="(";
		              }
		              S1+=Character.toString(S.charAt(i));
		          }
		          
		          //decreasing case
		          if(Integer.parseInt(Character.toString(S.charAt(i)))<Integer.parseInt(Character.toString(S.charAt(i-1))))
		          {
		            
		              for(int j=0;j<Integer.parseInt(Character.toString(S.charAt(i-1)))-Integer.parseInt(Character.toString(S.charAt(i)));j++){
		                  S1+=")";
		              }
		          }
		      }
		      
		         		     if(S.charAt(i)=='0'){
                		        S1+="0";
                		      }
            if(i>0){
		      if(S.charAt(i)!='0'&&S.charAt(i-1)=='0'){
		          
		          for(int j=0;j<Integer.parseInt(Character.toString(S.charAt(i)));j++){
		              S1+="(";
		          }
		          S1+=S.charAt(i);
		      }
		  }        		      
                		      
		  if(i<n-1){
		      if(S.charAt(i)!='0'&&S.charAt(i+1)=='0'){
		          if(i>0){  if(S.charAt(i-1)!='0')
		          S1+=S.charAt(i);}
		          for(int j=0;j<Integer.parseInt(Character.toString(S.charAt(i)));j++){
		              S1+=")";
		          }
		      }
		      
		  }
		  
		      
		      
		  }
		}
		  
		  
		  
// 		 if(S.charAt(n-1)!='0'){
// 		     S1+=Character.toString(S.charAt(n-1));
// 		 }
		 
		 for(int i=0;i<Integer.parseInt(Character.toString(S.charAt(n-1)));i++){
        		        S1+=")";
        		    }
        		    
		 
		 System.out.println("Case #"+t+": "+S1);
		    
		    
		    
		    
		    
		}
	}
}
