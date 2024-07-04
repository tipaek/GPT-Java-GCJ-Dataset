/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tc=sc.nextInt();
		int in=0;
		String[] data=new String[tc];
		while(in<tc)
		{
		    data[in]=sc.next();
		    in++;
		}
		for(int i=0;i<tc;i++)
		{
		    String ans="";
		    for(int j=0;j<data[i].length();j++)
		    {
		        int va=Character.getNumericValue(data[i].charAt(j));
		       //System.out.println(va);
		        if(j==0)
		        {
		                for(int t=0;t<va;t++)
		                ans=ans+'(';
		                ans+=data[i].charAt(j);
		                if(data[i].length()==1)
		                    {
		                        for(int t=0;t<va;t++)
		                        ans=ans+')';
		       
		            
		                    }
		                continue;
		        }
		        
		      
		       
		            int vaprev=Character.getNumericValue(data[i].charAt(j-1));
		            if(va>=vaprev)
		            {
		                for(int t=0;t<va-vaprev;t++)
		                ans=ans+'(';
		                ans+=data[i].charAt(j);
		                
		            }
		            if(va<vaprev)
		            {
		                for(int t=0;t<vaprev-va;t++)
		                ans=ans+')';
		                ans+=data[i].charAt(j);
		                
		            }
		            if(j==data[i].length()-1)
		        {
		            for(int t=0;t<va;t++)
		        ans=ans+')';
		       
		            
		        }
		        
		        
		    }
		    System.out.println("Case #"+(i+1)+':'+" "+ans);
		}
	}
}