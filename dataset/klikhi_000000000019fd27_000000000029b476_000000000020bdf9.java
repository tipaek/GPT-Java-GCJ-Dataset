

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
		    int n=sc.nextInt();
		    String result="";
		    TreeMap<Integer,String>map=new TreeMap<>();
		    int [][] arr=new int[n][2];
		    int[][] temp=new int[n][2];
		    for(int i=0;i<n;i++)
		    {
		        arr[i][0]=sc.nextInt();
		        arr[i][1]=sc.nextInt();
		        temp[i][0]=arr[i][0];
		        temp[i][1]=arr[i][1];
		        
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
        int flag=0,count=0;
        for(int i=1;i<n;i++)
        {
            while(arr[i-1][0]==arr[i][0] &&arr[i-1][1]==arr[i][1] )
            {
                count++;
                i++;
                if(i==n)
                break;
            }
            if(count+1>2)
            {
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
                flag=1;
                break;
            }
            count=0;
        }
        
        if(flag==1)
        continue;
        for(int i=0;i<n;i++)
        {
            if(temp[i][0]==arr[0][0] && temp[i][1]==arr[0][1])
            {
                map.put(i,"C");
            }
        }
        int cend=arr[0][1],jend=0;
        flag=0;
        String prev="C";
        for(int i=1;i<n;i++)
        {
            if(arr[i-1][0]==arr[i][0] &&arr[i-1][1]==arr[i][1] )
            {
                for(int k=0;k<n;k++)
                {
                    if(temp[k][0]==arr[i][0] && temp[k][1]==arr[i][1])
                    {
                        if(prev.equals("C"))
                        map.put(i,"J");
                        else
                        map.put(i,"J");
                    }
                }                
            }
            else if(arr[i][0]<arr[i-1][1]&& (!prev.equals("J")))
            {
                for(int k=0;k<n;k++)
                {
                    if(temp[k][0]==arr[i][0] && temp[k][1]==arr[i][1])
                    {
                        map.put(k,"J");
                    }
                }
                jend=arr[i][1];
                prev="J";
            }
            else if(cend<=arr[i][0])
            {
                for(int k=0;k<n;k++)
                {
                    if(temp[k][0]==arr[i][0] && temp[k][1]==arr[i][1])
                    {
                        map.put(k,"C");
                    }
                }
                cend=arr[i][1];
                prev="C";
            }
            else if(jend<=arr[i][0])
            {
                for(int k=0;k<n;k++)
                {
                    if(temp[k][0]==arr[i][0] && temp[k][1]==arr[i][1])
                    {
                        map.put(k,"J");
                    }
                }
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
		   {
		       for(Map.Entry<Integer,String>ent: map.entrySet())
		       result+=ent.getValue();
		      // System.out.println(ent.getKey());
		       System.out.println("Case #"+t+": "+result);
		   }
		    
		}
	}
}
