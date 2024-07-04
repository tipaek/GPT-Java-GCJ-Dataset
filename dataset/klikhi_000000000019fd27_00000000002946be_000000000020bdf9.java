

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{

		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
		    int n=sc.nextInt();
		    String result="C";
		    int [][] arr=new int[n][2];
		    for(int i=0;i<n;i++)
		    {
		        arr[i][0]=sc.nextInt();
		        arr[i][1]=sc.nextInt();
		    }
		    
		    Arrays.sort(arr,new Comparator<int[]>()
		    {
		         public int compare(final int[] a,final int[] b)
		         { 
                    if (a[0] > b[0]) 
                    return 1; 
                    else
                    return -1; 
                 } 
            }
        );
        int cend=arr[0][1],jend=0,flag=0;
        String prev="C";
        for(int i=1;i<n;i++)
        {
            if(arr[i][0]<arr[i-1][1]&& (!prev.equals("J")))
            {
                result+="J";
                jend=arr[i][1];
                prev="J";
            }
            else if(cend<=arr[i][0])
            {
                result+="C";
                cend=arr[i][1];
                prev="C";
            }
            else if(jend<=arr[i][0])
            {
                result+="J";
                jend=arr[i][1];
                prev="J";
            }            
            else
            {
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
                flag=1;
                break;
            }
		    
        }    
		   if(flag!=1) 
		    System.out.println("Case #"+t+": "+result);
		}
	}
}
