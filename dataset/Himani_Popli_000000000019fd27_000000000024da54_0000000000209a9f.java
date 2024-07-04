/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int k=1;k<=t;k++){
		    String s=scan.next();
		    int open=0;
		    StringBuffer ans=new StringBuffer();
		    for(int i=0;i<s.length();i++){
		        int n=(int)(s.charAt(i)-'0');
		        while(open>n){
		            ans.append(")");
		            open--;
		        }
		        while(open<n){
		            ans.append("(");
		            open++;
		        }
		        ans.append(n+"");
		    }
		    while(open>0){
	            ans.append(")");
	            open--;
	        }
		    System.out.println("Case #"+k+": "+ans);
		}
	}
}
