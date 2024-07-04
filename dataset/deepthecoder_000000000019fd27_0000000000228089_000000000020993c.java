/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int z=1;
		while(z<=t)
		{
			int n=sc.nextInt();
			int arr[][]=new int[n][n];
			int trace=0;
			int crow=0,ccol=0;
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=sc.nextInt();
				}
			}
			
			for(int i=0;i<n;i++)
			{
				trace+=arr[i][i];
			}
			
			for(int i=0;i<n;i++)
			{
				int flag=0,f2=0;
				Map<Integer, Integer> mp = new HashMap<>();
			Map<Integer, Integer> mp1 = new HashMap<>();
				for (int j = 0; j < n; j++) 
			    { 
			            if (mp.containsKey(arr[i][j]))  
			            { 
			                mp.put(arr[i][j], (mp.get(arr[i][j]) + 1)); 
			                //System.out.println("I am Here,,,"+arr[i][j]);
			                flag=1;
			                break;
			            }  
			            else
			            { 
			            	
			                mp.put(arr[i][j], 1); 
			            } 
			    } 
			     
        		 if(flag==1)
        		 {	
        		 	crow++;	
        		 }
        	
        	for (int j = 0; j < n; j++) 
			{ 
			            if (mp1.containsKey(arr[j][i]))  
			            { 
			                mp1.put(arr[j][i], mp1.get(arr[j][i]) + 1); 
			                f2=1;
			                break;
			            }  
			            else
			            { 
			                mp1.put(arr[j][i], 1); 
			            } 
			} 
			     
        		 if(f2==1)
        		 {	
        			ccol++;	
        		 }	 
			}
			
			System.out.println("Case #"+z+": "+trace+" "+crow+" "+ccol);
			z++;
		}
	}
}