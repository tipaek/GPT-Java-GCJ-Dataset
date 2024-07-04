/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int start = 1; start<=t;start++){
		    String str = s.next();
            String ans="";
            int prev=0;
            int para=0;
        for(int i=0;i<str.length();i++)
        {
            int curr=str.charAt(i)-'0';
            if(prev==curr)
            {
                ans+=str.charAt(i);
                continue;
            }
            if(prev>curr)
            {
                for(int j=0;j<prev-curr;j++)
                {
                    ans+=')';
                    para--;
                }
            }else
            {
                for(int j=0;j<curr-prev;j++)
                {
                    ans+='(';
                    para++;
                }
            }
            ans+=str.charAt(i);
            prev=curr;
        }
        for(int i=0;i<para;i++)
        {
            ans+=')';
        }
		
		    System.out.println("Case #"+start+": "+ans);
		}
	}
}
