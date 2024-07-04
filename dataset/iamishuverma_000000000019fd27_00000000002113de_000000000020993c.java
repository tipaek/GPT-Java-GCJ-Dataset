import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,n,i,j,k,trace=0,row=0,col=0;
	int[][] a=new int[100][100];
	int[] hash=new int[100];
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		trace=row=col=0;
		hash=new int[100];
		n=scan.nextInt();
		for(j=0;j<n;++j)
			{
			hash=new int[100];
			for(k=0;k<n;++k)
				{
				a[j][k]=scan.nextInt();
				if(j==k)
					trace+=a[j][k];
				++hash[a[j][k]-1];
				}
			for(k=0;k<n;++k)
				if(hash[k]>1)	
					{
					++row;
					break;
					}
			}
		for(k=0;k<n;++k)
			{
			hash=new int[100];
			for(j=0;j<n;++j)
				++hash[a[j][k]-1];
			for(j=0;j<n;++j)
				if(hash[j]>1)
					{
					++col;
					break;	
					}
			}
		System.out.println("Case #"+i+": "+trace+" "+row+" "+col);
		}
	}
}