
import java.util.*;

class Main
{  
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
	        int i,j,sum=0,rcount=0,ccount=0;
	        int testcase =sc.nextInt();
	   for(int t=1;t<=testcase;t++)
	   {
	
		int n = sc.nextInt();

		int[][] mat = new int[n][n];
 
    		
    		for(i=0;i<n;i++)
    		{ 
	    		for(j=0;j<n;j++)
	    		{ 
	        		mat[i][j] = sc.nextInt();
    			}
		}
		
    		

    		for(i=0;i<n;i++)
    		{ 
	    		for(j=0;j<n;j++)
	    		{ 
				if(i==j)	
				{
					sum = sum + mat[i][j];
				}
    			}
		}
for(i=0;i<n;i++)
    { 
	    for(j=0;j<n;j++)
	    	{ 
	    	    
				if(mat[i][j]==t)	
				{
				    rcount=rcount+1;
	
				}
				else
				{
				    break;
				}
				
			ccount=ccount+1;	    
				}
	    		}
    		
    		System.out.println("Case #"+t+":"+" "+sum+" "+rcount+" "+ccount);
    		sum=0;
    		rcount=0;
    		ccount=0;
	   	
}
}
}