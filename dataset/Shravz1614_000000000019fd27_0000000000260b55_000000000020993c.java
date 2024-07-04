import java.util.*;

public class Solution {

	public static void pn(Object o)
    {System.out.println(o);}
    public static void p(Object o)
    {System.out.print(o);}
    
        
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s =new Scanner(System.in);
		int t=s.nextInt();
		
		for(int test=1;test<=t;test++)
		{
		    int n=s.nextInt();
		    int arr[][]=new int[n][n];
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        arr[i][j]=s.nextInt();
		    }
		    int sum=0;
		    for(int i=0;i<n;i++)
		    sum+=arr[i][i];
		    
		    int rowCount=0;
		    for(int i=0;i<n;i++)
		    {
		    	boolean found=true;
		    	int hash[]=new int[n+n];
		    	for(int j=0;j<n;j++)
		    	{
		    		if(hash[arr[i][j]]==1)
		    		{
		    			found=false;
		    			break;
		    		}
		    		else
		    			hash[arr[i][j]]=1;
		    		
		    	}
		    	if(found==false)
		    		rowCount++;
		    	
		    }
		    int colCount=0;
		    for(int i=0;i<n;i++)
		    {
		    	boolean found=true;
		    	int hash[]=new int[n+n];
		    	for(int j=0;j<n;j++)
		    	{
		    		if(hash[arr[j][i]]==1)
		    		{
		    			found=false;
		    			break;
		    		}
		    		else
		    			hash[arr[j][i]]=1;
		    		
		    	}
		    	if(found==false)
		    		colCount++;
		    	
		    }
		    
		    pn("Case #"+test+": "+sum+" "+rowCount+" "+colCount);
		}
		    
		     
	}

}