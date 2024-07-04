import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int i,j,r,c,x,n,n1,trace;
		for(x=1;x<=T;x++){
		    n = sc.nextInt();
		    r=0;c=0;trace=0;
		    int fr[]=new int[n];
		    int fc[]=new int[n];
		    int R[][]=new int[n][n];
		    int C[][]=new int[n][n];
		    for(i=0;i<n;i++){
		        for(j=0;j<n;j++){
		            n1=sc.nextInt();
		            if(i==j)
		            trace+=n1;
		            if(R[i][n1-1]==0)
		            R[i][n1-1]++;
		            else{
		                R[i][n1-1]++;
		                if(fr[i]==0)
		               r++;
		               fr[i]=1;
		            } 
		            
		            if(C[j][n1-1]==0)
		            C[j][n1-1]++;
		            else{
		                C[j][n1-1]++;
		                if(fc[j]==0)
		               c++;
		               fc[j]=1;
		            } 
		        }
		    }
		     System.out.println("Case #" + x + ": " +trace+" "+r+" "+c );
		    
    	}
		
	}
}
