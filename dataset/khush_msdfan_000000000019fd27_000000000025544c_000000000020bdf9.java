
import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cs=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            char[] cr=new char[2];
            cr[0]='C';
            cr[1]='J';
            int free[]=new int[2];
            int st[]=new int[n];
            int end[]=new int[n];
            int ind[]=new int[n];
            for(int i=0;i<n;i++)
            {
            	st[i]=sc.nextInt();
            	end[i]=sc.nextInt();
            	ind[i]=i;
            }
            for(int i=0;i<n;i++)
            {
            	for(int j=0;j<n-i-1;j++)
            	{
            		if(st[j]>st[j+1])
            		{
            			int tp=st[j];
            			st[j]=st[j+1];
            			st[j+1]=tp;
            			tp=end[j];
            			end[j]=end[j+1];
            			end[j+1]=tp;
            			tp=ind[j];
            			ind[j]=ind[j+1];
            			ind[j+1]=tp;
            			
            		}
            	}
            }
            
            String ans="";
            for(int i=0;i<n;i++)
            {
            	if(st[i]>=free[0])
            	{
            		ans+="C";
            		free[0]=end[i];
            	}
            	else if(st[i]>=free[1])
            	{
            		ans+="J";
            		free[1]=end[i];
            	}
            	else
            	{
            		ans="IMPOSSIBLE";
            		break;
            	}
            }
            if(ans.equals("IMPOSSIBLE"))
            {
            	System.out.println("Case #"+(cs++)+": "+ans.trim());	
            }
            else
            {
            	char ans_chr[]=ans.toCharArray();
            	for(int i=0;i<n;i++)
                {
                	for(int j=0;j<n-i-1;j++)
                	{
                		if(ind[j]>ind[j+1])
                		{
                			char tp_c=ans_chr[j];
                			ans_chr[j]=ans_chr[j+1];
                			ans_chr[j+1]=tp_c;
                			;
                			int tp=ind[j];
                			ind[j]=ind[j+1];
                			ind[j+1]=tp;
                			
                		}
                	}
                	
                }
            	ans=new String(ans_chr);
            	System.out.println("Case #"+(cs++)+": "+ans.trim());
            }
            
        }
    }
}