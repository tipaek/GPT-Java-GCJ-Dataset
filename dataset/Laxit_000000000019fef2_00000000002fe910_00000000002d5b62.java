
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int test=sc.nextInt();
		int temp=1;
		while(temp<=test)
		{
		    long x = sc.nextLong();
		    long y = sc.nextLong();
		    
		    StringBuffer ans=new StringBuffer();
		    long tx=Math.abs(x);
		    long ty=Math.abs(y);
		    if((tx+ty)%2 == 0) {
		        ans.append("IMPOSSIBLE");
		    }
		    else {
		        
		        long num = tx+ty, start=1;
		        
		        while(start<=num)
		           start=start*2;
		        start=start/2;   
		        
		        int count=0;
		        while(start > 0)
		        {
		            count++;
		            if(Math.abs(x) > Math.abs(y)) {
		                long minus=x-start, plus=x+start;
		                if(Math.abs(minus) > Math.abs(plus)) {
		                    x+=start;
		                    ans.append('W');
		                }
		                else {
		                    x-=start;
		                   ans.append('E');
		                }
		            }
		            else {
		                long minus=y-start, plus=y+start;
		                if(Math.abs(minus) > Math.abs(plus)) {
		                    y+=start;
		                    ans.append('S');
		                }
		                else {
		                    y-=start;
		                    ans.append('N');
		                }
		            }
		            start/=2;
		        }
		        ans.reverse();
		    }
		    
		    System.out.println("Case #"+temp+": "+ans);
		    temp++;
		}
	}
}


































