import java.util.*;
public class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=1;i<=t;i++)
		{
			int n=sc.nextInt();
			int j,k,trace=0;
			int rc=0,cc=0;
			
			int a[][]=new int[n][n];
			//creating temp matrix for column check
			int b[][]=new int[n][n];
			
			for(j=0;j<n;j++)          //no. of rows by j
			{
				for(k=0;k<n;k++)	  //no. of cols by k
				{
					a[j][k]=sc.nextInt();
					b[j][k]=a[j][k];
					if(j==k)          //this works
						trace+=a[j][k];
				}
			}
			  
			  
			  
			  //check duplicates for rows
			  for(j=0;j<n;j++)          
			{
				Set<Integer> set = new HashSet<Integer>(); 
				for(k=0;k<n;k++)	  
				{
					if(set.add(a[j][k])==false)
					{
						rc++;
						break;
					}
				}
			}
			
			for(k=0;k<n;k++)          
			{
				Set<Integer> set2 = new HashSet<Integer>();
				for(j=0;j<n;j++)	  
				{
					if(set2.add(a[j][k])==false)
					{
						cc++;
						break;
					}
				}
			}
			
			    //
				System.out.println("Case #"+i+": "+trace+" "+rc+" "+cc);
			  
		}
	}
}
				