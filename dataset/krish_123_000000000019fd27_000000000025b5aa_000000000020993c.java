package gfg;


import java.util.Scanner;
import java.util.Arrays;
class Google{
    public static void main(String[] args)
    {		
    	// your code goes here
		Scanner sc=new Scanner(System.in);
		try {
		int t=sc.nextInt();
		while(t-->0)
		{	int k=1;
		    int n=sc.nextInt();
		    int p[][]=new int[n][n];
		    int result=((n+1)*n)/2;
		    int r=0;
		    int dig=0;
		    for(int i=0;i<n;i++)
		    {	int sum=0;
		    	for(int j=0;j<n;j++)
		    	{
		    		p[i][j]=sc.nextInt();
		    		sum+=p[i][j];
		    		if(i==j)
		    		{
		    			dig+=p[i][j];
		    		}
		    	}
		    	if(sum!=result)
		    		r++;
		    }
		    int c=ans(p,n,result);
		    System.out.println("Case #"+k+":"+" "+dig+" "+r+" "+c);
		   
		}
		}catch(Exception e)
		{
		}
		}
    public static int  ans(int p[][],int n,int result)
    {	int c=0;
    	for(int i=0;i<n;i++)
    	{	int sum2=0;
    		for(int j=0;j<n;j++)
    		{
    			sum2+=p[j][i];
    		}
    		if(sum2!=result)
    			c++;
    	}
    	return c;
    }
		
}
    	
    				