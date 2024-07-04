import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scaner = new Scanner(System.in);
        
		int t = scaner.nextInt();
		
		for(int test=1;test<=t;test++)
		{
			int n = scaner.nextInt();	
			int [][] arr = new int[n][n];
			
			int diag=0;
			
			for(int i=0; i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j] = scaner.nextInt();	
					
					if(i == j)
						diag+=arr[i][j];
				}
			}
			
			int rmax=0,cmax=0;
			for(int i=0; i<n;i++)
			{
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int j=0;j<n;j++)
				{
					
					if(!map.containsKey(arr[i][j]))	
						map.put(arr[i][j],1);
					else
					{
						map.put(arr[i][j],map.get(arr[i][j])+1);
						rmax++;
						break;
					}
				}
			}
				
				
			for(int i=0; i<n;i++)
			{
				HashMap<Integer,Integer> map = new HashMap<>();
				for(int j=0;j<n;j++)
				{
					
					if(!map.containsKey(arr[j][i]))
						map.put(arr[j][i],1);
					else
					{
						map.put(arr[j][i],map.get(arr[j][i])+1);
						cmax++;
						break;
					}
				}
			}
		
			System.out.println("Case #"+test+": "+diag+" "+rmax+" "+cmax);			
		}
		
		
		
		
    }
}
