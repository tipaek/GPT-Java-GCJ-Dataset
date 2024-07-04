import java.util.Scanner;
class FindMatrix {
public static void main(String args[])
{
//	Scanner sc=new Scanner(System.in);
//	System.out.println("enter the number of test cases");
//	int x=sc.nextInt();
//	int h=x;
//	System.out.print("enter array size");
	int n=sc.nextInt();
	int ar[][]=new int[n][n];
/*	System.out.print("enter array");
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			 ar[i][j]=sc.nextInt();
		}
	}
	*/
	int s=0;
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			if(i==j)
			{
				s=s+ar[i][j];
			}
		}
	}
	

	int l=0;
	int m=0;
	int c=0;
	for(int k=0;k<n;k++)
	{
	l1:	
	for(int i=0;i<n-1;i++)
	{	
		for(int j=i+1;j<n;j++)
		{
			
			if(ar[l][i]==ar[l][j])
			{
				c=c+1;
				break l1;
			}
		
		}
		
	}
	l++;
}
	l=0;
	for(int k=0;k<n;k++)
	{
		l2:
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(ar[i][l]==ar[j][l])
				{
					m=m+1;
					break l2;
				}
			}
		}
	l++;
	}
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			System.out.print(ar[i][j]);
		}
		System.out.println();
	}
	System.out.println("case:"+s);
	System.out.print(c);
	System.out.print(m);
	System.out.println();
	
    
}
}
