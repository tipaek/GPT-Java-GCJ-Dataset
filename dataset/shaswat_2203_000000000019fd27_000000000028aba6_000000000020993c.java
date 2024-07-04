import java.util.*;
public class Solution {
	
        
	public static void main(String[] args) {
         Scanner in=new Scanner(System.in);
         int test=in.nextInt();
         for (int t=1;t<=test;t++)
         {
        	 int n=in.nextInt();
        	 int arr[][]=new int[n][n];
        	 int sum=0;
        	 for (int i=0;i<n;i++)
        	 {
        	 	 for (int j=0;j<n;j++)
        	 	 {
        	 		 arr[i][j]=in.nextInt();
        	 		 if (i==j)
        	 			 sum+=arr[i][j];
        	     }
        	 }
        	 int countr=0;
        	 int countc=0,k=0;
        	 int a1[]=new int[n];
        	 int a2[]=new int[n];
            for (int i=0;i<n;i++)
            {
            	for (int j=k+1;j<n;j++)
            	{
            		if (arr[i][k]==arr[i][j])
            			a1[i]++;
            		if (arr[k][i]==arr[j][i])
            			a2[i]++;
            	}
            	k++;
            	if (k!=n-1)
            	{
            		i--;
            	}
            	else
            		k=0;
            }
        	       for (int i=0;i<n;i++)
        	       {
        	    	   if (a1[i]>0)
        	    		   countr++;
        	    	   if (a2[i]>0)
        	    		   countc++;
        	       }
           	                                                                
              System.out.println("Case #"+t+": "+sum+" "+countr+" "+countc);
               }
      }
}