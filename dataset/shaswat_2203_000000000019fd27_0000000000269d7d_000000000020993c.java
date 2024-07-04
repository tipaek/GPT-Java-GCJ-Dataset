import java.util.*;
public class Solution {

	public static void main(String[] args) {
         Scanner in=new Scanner(System.in);
         int t=in.nextInt();
         while(t-->0)
         {
        	 int n=in.nextInt();
        	 int arr[][] =new int[n][n];
        	 int sum=0;
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
        	 for (int i=0,z=0;i<n;i++,z++)
        	 {
        		 for (int j=z+1;j<n;j++)
        		 {
        			 if (arr[i][z]==arr[i][j])
        			 {
        				 countr++;
        			 }
        			 if (arr[z][i]==arr[j][i])
        			 {
        				 countc++;
        			 }
        			 break;
        			 
        		 }
        		 if (z==n-2)
        		 {
        			 z=0;
        		 }
        		 else if (i!=n-1)
        		 {
        			 i--;
        		 }
        	 }
        	 
           System.out.println("Case #"+(t+1)+": "+sum+" "+countr+" "+countc);
         }
         
	}

}
