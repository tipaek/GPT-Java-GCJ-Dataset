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
		int temp=0;
		int arr[][]=new int[n][n];
		for(i=0;i<n;i++)
		    {
		        temp=(i+1)^temp;
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
		    for(i=0;i<n;i++)
		    {
		         int temp2=0;
		        for(j=0;j<n;j++)
		        {
		            temp2=temp2^arr[i][j];
		        }
		        if(temp2!=temp)
		        r++;
		    }
		     for(i=0;i<n;i++)
		    {
		        int temp2=0;
		        for(j=0;j<n;j++)
		        {
		            temp2=temp2^arr[j][i];
		        }
		        if(temp2!=temp)
		        c++;
		    }
		       System.out.println("Case #"+(k+1)+":"+" "+sum+" "+r+" "+c);
		}
    }
}