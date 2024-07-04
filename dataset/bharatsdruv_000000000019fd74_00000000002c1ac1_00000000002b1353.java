import java.util.*;
class Solution
{
	public static void main(String[] args) 
	{
	    Scanner in=new Scanner(System.in);
	    int testcases=in.nextInt();
	    for(int tc=1;tc<=testcases;tc++)
	    {
	        int N=in.nextInt();
	        System.out.println("Case #"+tc+":");
	        if(N<=500)
	        {
	            for(int i=0;i<N;i++)
	                System.out.println(i+1+" "+1);
	        }
	        else if(N==501)
	        {
	            System.out.println(1+" "+1);
	            System.out.println(2+" "+2);
	            
	            for(int i=1;i<500;i++)
	                System.out.println(i+1+" "+1);
	            
	        }
	        
	           
	    }
	    
	}
}
