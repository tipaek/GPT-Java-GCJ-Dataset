

import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc=t;
        while(t!=0)
        {
        	int n = scn.nextInt();
        	int minc=0;
        	int maxc=0;
        	int minj=Integer.MAX_VALUE;
        	int maxj=Integer.MIN_VALUE;
        	String str="";
        	for(int i =1;i<=n;i++)
        	{
        		int s= scn.nextInt(), e = scn.nextInt();
        		
        		if(i==1)
        		{
        			str=str+"C";
        			minc=s;
        			
        			maxc=e;
        		}
        		else if(((minc<s && maxc>s) || (minc<e && maxc>e)) )
        		{
        			if((minj<s && maxj>s) || (minj<e && maxj>e))
        			{
        				System.out.println("Case #"+(tc-t+1)+": " +"IMPOSSIBLE");
            			str="IMPOSSIBLE";
            			break;
        			}
        			else {
        				str=str+"J";
            			if(s<minj)
            			{
            				minj=s;
            			}
            			if(e>maxj)
            			{
            				maxj=e;
            			}
        			}
   	
        		}
        		else 
        		{
        			str=str+"C";
        			if(s<minc)
        			{
        				minc=s;
        			}
        			if(e>maxc)
        			{
        				maxc=e;
        			}
        		}
        		
        		
        	}
        	if(!str.equalsIgnoreCase("IMPOSSIBLE")) {
        	System.out.println("Case #"+(tc-t+1)+": " +str);
        	}
        	t--;
        }

	}

}
