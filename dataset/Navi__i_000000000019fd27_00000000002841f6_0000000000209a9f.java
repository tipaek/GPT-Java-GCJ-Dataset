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
	            char previous = '0';
		        for(int i = 0 ;i<n ;i++){
		           if(previous=='0' && s.charAt(i)=='1'){
		                ans+="(1";
		                previous = '1';
		           }else if(previous=='1' && s.charAt(i)=='1'){
		                ans+="1";
		                 previous = '1';
		               
		           }else if(previous=='1' && s.charAt(i)=='0'){
		               ans+=")0";
		                previous = '0';
		           }else{
		                ans+="0";
		                 previous = '0';
		           }
		            
		        }
		        
		        if(s.charAt(n-1)=='1'){
		            ans+=")";
		        }
		        
		        System.out.println("Case #"+x+": "+ans);
		        x++;
		     
		     
		}
	}
}
