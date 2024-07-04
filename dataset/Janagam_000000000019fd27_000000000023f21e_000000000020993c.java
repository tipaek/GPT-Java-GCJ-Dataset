import java.util.*;
import java.util.Scanner;
public class S
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int sum=0,count=0,c=0,num,r=0;
int t=sc.nextInt();
        int n=sc.nextInt();
        int a[][]=new int[n][n];
	for(int i=1;i<t;i++){
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
	
		for(int j=0;j<n;j++)
		{
			num=a[0][0];
			if(num==a[k][j])
			{
				count=count+1;
				
			}
			
		}
		
		
		
	    }
		count=(n*n)%(count)+1;
		
            System.out.println("Case"+ "#"+i+":"+sum+" "+ count+" "+count);
	}
	
	}
}