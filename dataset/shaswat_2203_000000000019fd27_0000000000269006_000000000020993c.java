import java.util.*;
public class Solution {

	public static void main(String[] args) {
         Scanner in=new Scanner(System.in);
         int t=in.nextInt();
         for (int q=1;q<=t;q++)
         {
        	 int n=in.nextInt();
        	 int arr[][] =new int[n][n];
        	 int sum=0;
        	 int a1[]=new int[n];
        	 int a2[]=new int[n];
        	 for (int i=0;i<n;i++)
        	 {
        		 for (int j=0;j<n;j++)
        		 {
        			 arr[i][j]=in.nextInt();
        			 if (i==j)
        				 sum=sum+arr[i][j];
        		 }
        	 }
        	 int countr=0;
        	 int countc=0;
        	 for (int i=0;i<n;i++)
        	 {
        	     int z=0;
        		 for (int j=0;j<n;j++)
        		 {
        			 if (arr[z][i]==arr[z][j])
        			 {
        				 a1[i]++;
        			 }
        			 if (arr[i][z]==arr[j][z])
        			 {
        				 a2[i]++;
        			 }
        			 
        	   }
        	z++;	 
        	 }
        	 for(int i=0;i<n;i++)
        	 {
        	     if (a1[i]!=1)
        	     countr++;
        	     if (a2[i]!=1)
        	     countc++;
        	 }
        	 
           System.out.println("Case #"+t+": "+sum+" "+countr+" "+countc);
         }
	}

}
