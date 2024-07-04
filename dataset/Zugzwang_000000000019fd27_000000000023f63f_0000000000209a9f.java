/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    String num=sc.next();
		    StringBuilder ans=new StringBuilder();int i=0;int b=0;int c=0;
		    while(i<num.length())
		    {
		        int d=Integer.parseInt(Character.toString(num.charAt(i)));
		            if(b<d){
		            while(b!=d)
		            {
		                ans.append("(");b++;
		            }
		            ans.append(num.charAt(i++));
		            }
		            else if(b>d)
		            {
		                while(b!=d)
		                {
		                    ans.append(")");b--;
		                }
		                ans.append(num.charAt(i++));
		            }
		            else ans.append(num.charAt(i++));
		            
		        }
		        while(b>0){
		        ans.append(")");b--;}
		        System.out.println("Case #"+c+":"+" "+ans.toString());c++;
		    }
		}
	}
