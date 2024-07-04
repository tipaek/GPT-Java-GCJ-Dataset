import java.util.*;
public class codejam{

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
        	 for (int i=0;i<n;i++)
        	 {
        		 for (int a=0;a<n-1;a++)
        		 {
        			 for (int b=a+1;b<n;b++)
        			 {
        				 if (arr[i][a]==arr[i][b])
        					 {
        					 countr++;
        					 }
        				 if (arr[a][i]==arr[b][i])
        					 countc++;
        			 }
        		 }
        	 }
           System.out.println("Case #"+t+": "+sum+" "+countr+" "+countc);
         }
	}

}
