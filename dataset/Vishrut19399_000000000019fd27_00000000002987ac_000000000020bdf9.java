
import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int k=sc.nextInt();
		
		sc.nextLine();
	for(int t=1;t<=k;t++)
	{
	    int n=sc.nextInt();
	    int start[]=new int[n];
	    int end[]=new int[n];
	    String arr[]=new String[n];
	    for(int i=0;i<n;i++)
	    {
	    start[i]=sc.nextInt();
	    end[i]=sc.nextInt();
	    }
	    arr[0]="C";
	    int flag=0;
	    for(int i=1;i<n;i++)
	    {
	        int flagj=0;
	        int flagc=0;
	        for(int j=i-1;j>=0;j--)
	        {
	            
	                if(!(start[i]>=end[j] || end[i]<=start[j]))
	                {
	                    if(arr[j]=="C")
	                        flagc=1;
	                     else
	                        flagj=1;
	                }

	        }
	        
	        if(flagc==0)
	        {
	            arr[i]="C";
	        }
	        else if(flagj==0)
	        {
	            arr[i]="J";
	        }
	        else{
	            flag=1;
	            break;
	        }
	    }
	    
	    if(flag==1)
	    {
	 System.out.println("Case #"+t+": "+"IMPOSSIBLE");       
	        
	    }
	    else{
	        StringBuffer str=new StringBuffer("");
	        for(int i=0;i<n;i++)
	        {
	            str.append(arr[i]);
	        }
	        System.out.println("Case #"+t+": "+str.toString());
	    }
	
	    
	}
	    
	}
}