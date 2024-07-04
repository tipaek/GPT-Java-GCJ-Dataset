import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{

	public static void main (String[] args) throws IOException
	{
	    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         int itr = scan.nextInt();
         int x =1;
	      while(itr-->0){
	            String s = scan.next();int n = s.length();
	            String ans = "";
	            int previous = 0;
		        for(int i = 0 ;i<n ;i++){
		            int current = Integer.parseInt(String.valueOf(s.charAt(i)));
		             if(i==0){
		                int count = current;
		                while(count>0){
		                      ans+="(";
		                     count--;
		                 }
		                 ans+=Integer.toString(current);
		             }else if(current==0){
		                 int count  = previous;
		                 while(count>0){
		                     ans+=")";
		                     count--;
		                 }
		                 ans+=Integer.toString(current);
		             }else if(previous==current){
		                  ans+=Integer.toString(current);
		                 
		             }else if(current<previous){
		                  int diff = previous-current;
		                  while(diff>0){
		                      ans+=")";
		                      diff--;
		                  }
		                   ans+=Integer.toString(current);
		                 
		             }else if(current>previous){
		                  int diff= current-previous;
		                  while(diff>0){
		                      ans+="(";
		                      diff--;
		                  }
		                   ans+=Integer.toString(current);
		                 
		             }
		            
		            
		            
		            previous = current;
		        }
		           while(previous-->0){
		            ans+=")";
		        }
		        
		      
		        System.out.println("Case #"+x+": "+ans);
		        x++;
		     
		     
		}
	}
}
