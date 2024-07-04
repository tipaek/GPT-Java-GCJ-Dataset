package gfg;


import java.util.Scanner;
import java.util.Arrays;
 class Google{
	static int k=1;
    public static void main(String[] args)
    {		
    	// your code goes here
		Scanner sc=new Scanner(System.in);
		try {
		int t=sc.nextInt();
		while(t-->0)
		{	
		    int n=sc.nextInt();
		    int p[][]=new int[n][n];
		   
		    int r=0;
		    int dig=0;
		    for(int i=0;i<n;i++)
		    {	
		    	for(int j=0;j<n;j++)
		    	{
		    		p[i][j]=sc.nextInt();
		    		
		    		if(i==j)
		    		{
		    			dig+=p[i][j];
		    		}
		    	}		    	
		    }
		   ans(p,n,dig);
		   
		   
		   
		}
		}catch(Exception e)
		{
		}
		}
    public static void  ans(int p[][],int n,int dig)
    {	int c=0,r=0;
    	
    		for(int i=0;i<n;i++)
    		{	
    			for(int j=0;j<n;j++)
    			{	
    				int flag=0;
    				for(int k=j+1;k<n;k++)
    				{
    					if(p[i][j]==p[i][k])
    					{
    						flag=1;
    						break;
    					}
    				}
    				if(flag==1)
    				{	r++;
    					break;
    				}
    			}
    		}
    		
    	
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		for(int i=0;i<n;i++)
    		{	
    			for(int j=0;j<n;j++)
    			{	
    				int flag=0;
    				for(int k=j+1;k<n;k++)
    				{
    					if(p[j][i]==p[k][i])
    					{
    						flag=1;
    						break;
    					}
    				}
    				if(flag==1)
    				{	c++;
    					break;
    				}
    			}
    		}
    	 System.out.println("Case #"+k+":"+" "+dig+" "+r+" "+c);
    	 k++;
    }
		
}
    	
    				