/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 int T,count=1;
	 Scanner sc=new Scanner(System.in);
	 T=sc.nextInt();
	 while(T>0){
	     int n=sc.nextInt(),countx=0,county=0;
	     int trace=0;
	     int[][] a=new int[n][n];
	     
	     for(int i=0;i<n;i++)
	     {
	        for(int j=0;j<n;j++)
	        {
	            a[i][j]=sc.nextInt();
	            
	        }
	     }
	     
	     Set<Integer> hash_SetR = new HashSet<Integer>(); 
	     for(int i=0;i<n;i++)
	     {
	         for(int j=0;j<n;j++){
	            
        hash_SetR.add(a[i][j]); 
	             
	         }if(hash_SetR.size()<n)
	         {
	             countx++;
	         }hash_SetR.clear();
	     }
	     
	     Set<Integer> hash_SetC = new HashSet<Integer>(); 
	     
	     for(int i=0;i<n;i++)
	     {
	         for(int j=0;j<n;j++){
	            
        hash_SetC.add(a[j][i]); 
	             
	         }if(hash_SetC.size()<n)
	         {
	             county++;
	         }hash_SetC.clear();
	     }
	     
	        for(int i=0;i<n;i++)
	        {
	            trace+=a[i][i];
	        }
	        System.out.println("Case #"+count+": "+trace+" "+countx+" "+county);
	         count++;
	 T--;  }	// your code goes here
	}
}
