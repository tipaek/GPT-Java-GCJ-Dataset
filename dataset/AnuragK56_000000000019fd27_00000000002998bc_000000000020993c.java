import java.util.Scanner;
public class Solution{
   
    public static void main(String args[]) {
      int test,
		i,
		j,
		k = 0;
        Scanner sc=new Scanner(System.in);
		test = sc.nextInt();
		for (k = 0; k < test; k++)
		{
		int n=sc.nextInt();
		int temp=1;
		int arr[][]=new int[n][n];
		for(i=0;i<n;i++)
		    {
		        temp=(i+1)*temp;
	    	    for(j=0;j<n;j++)
		        {  
		        arr[i][j]=sc.nextInt();
		        }   
		    }
		    int sum=0;
		    for(i=0;i<n;i++)
		    {
		        sum+=arr[i][i];
		    }
		    int c=0,r=0;
		     boolean b[]=new boolean[n+1];
		    for(i=0;i<n;i++)
		    {
		         int temp2=1;
		         for(int k1=0;k1<n+1;k1++)
		         {
		             b[k1]=false;
		         }
		        for(j=0;j<n;j++)
		        {
		            if(b[arr[i][j]]==false)
		            b[arr[i][j]]=true;
		            else
		            {
		                r++;
		              break;  
		            }
		        }
		    }
		     for(i=0;i<n;i++)
		    {
		         int temp2=1;
		         for(int k1=0;k1<n+1;k1++)
		         {
		             b[k1]=false;
		         }
		        for(j=0;j<n;j++)
		        {
		            if(b[arr[j][i]]==false)
		            b[arr[j][i]]=true;
		            else
		            {
		                c++;
		              break;  
		            }
		        }
		    }
		       System.out.println("Case #"+(k+1)+":"+" "+sum+" "+r+" "+c);
		}
    }
}