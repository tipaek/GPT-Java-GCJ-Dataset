import java.util.*;
class Solution
{
	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int sum=0;
	        int N=in.nextInt();
	        System.out.println("Case #"+tc+":");
	        if(N<=500)
	        {
	            for(int i=0;i<N;i++)
	                System.out.println(i+1+" "+1);
	        }
	        else if(N>500)
	        {
	            int i=0;
	            for( i=0;i<=N-500;i++)
	                System.out.println(i+1+" "+1);
	            
	            System.out.println(i+2+" "+2);
	            
	
	            for( i=N-500+2;i<500;i++)
	                {
	                    System.out.println(i+" "+1);
	                }
	        }
	        
	           
	    }
	    
	}
}
