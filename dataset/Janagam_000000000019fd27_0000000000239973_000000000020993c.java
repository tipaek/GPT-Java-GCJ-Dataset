import java.util.*;
import java.util.Scanner;
public class S
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int sum=0,count=0,c=0;
        int n=sc.nextInt();
        int a[][]=new int[n][n];
	for(int k=0;k<n;k++)
            {
                for(int j=0;j<n;j++)
                {
                    a[k][j]=sc.nextInt();
                }
            }
	    for(int k=0;k<n;k++)
            {
                
                sum=sum+a[k][k];
            }
	    for(int k=0;k<n;k++)
	    {
	
		for(int j=0;j<n-1;j++)
		{
			if(a[k][j]==a[k][j+1])
			{
				count++;
			}
		}
	    }
	
		
            System.out.println("Case"+ "#"+"1"+":"+sum);
	
	}
}