import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
class Main1
{
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++)    
		{
		    int n=sc.nextInt();
		    
		    int a[][]=new int[n][n];
		    for(int j=0;j<n;j++)
		    for(int j1=0;j1<n;j1++)
		    a[j][j1]=sc.nextInt();
		    int p=((n)*(n+1))/2;
		    
		  BigInteger factorial = BigInteger.ONE;
		  for (int i9 = n; i9 > 0; i9--) 
		  { factorial = factorial.multiply(BigInteger.valueOf(i9));
		  }
		  


		    
		    
		   
		    
		    int r=0,c=0;
		    for (int k = 0; k < n;k++)
		    {
		        int sum=0,sum1=0;
		         BigInteger factorial1 = BigInteger.ONE;
		       BigInteger factorial2 = BigInteger.ONE;
		        //loop through columns
    for (int j2 =0; j2 < n; j2++)
     { sum =sum+a[k][j2];
      factorial1=factorial1.multiply(BigInteger.valueOf(a[k][j2]));
        
        }if((sum==p)&& factorial1==factorial)
      r++;
      
        for(int j3=0;j3<n;j3++)
        {
            sum1=sum1+a[j3][k];
             factorial2=factorial2.multiply(BigInteger.valueOf(a[j3][k]));
        }   
      if(sum1==p&& factorial2==factorial)
      c++;
      
            }
            int sum2=0;
            for(int j=0;j<n;j++)
		 sum2=sum2+a[j][j];
         
         System.out.println("Case #"+i+": "+sum2+" "+(n-r)+" "+(n-c));
            
      
    }
  }
  
  
  
  
}
		    
		    
		    
		    
