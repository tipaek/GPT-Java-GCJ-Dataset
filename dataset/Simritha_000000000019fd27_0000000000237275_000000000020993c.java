import java.util.*;
class Main
{
	public static void main(String args[])
	{
		int m,n,r,c,k;
		int i,j,l,p,q;
		Scanner sc = new Scanner(System.in);
		m=sc.nextInt();
		for(i=0;i<m;i++)
		{
			k=0;
			r=0;
			c=0;
			n=sc.nextInt();
			int a[][]=new int[n][n];
			int flag[][]=new int[2][n];
			for(j=0;j<n;j++)
			{
				for(l=0;l<n;l++)
				{

					a[j][l]=sc.nextInt();
					if(j==l)
					{
						k=k+a[j][l];
					}
				}
			}
			for(j=0;j<2;j++)
			{
				for(l=0;l<n;l++)
				{
					flag[j][l]=0;
				}
			}
			for(j=0;j<n;j++)
			{
				for(l=0;l<n;l++)
				{
					for(p=0;p<n;p++)
					{
						for(q=0;q<n;q++)
						{
							if(a[j][l]==a[p][q])
							{
								if(j==p&&l!=q)
								{
									flag[0][j]=1;
								}
								if(l==q&&j!=p)
								{
									flag[1][l]=1;
								}
							}
						}
					}

				}
			}
			for(j=0;j<n;j++)
			{
				if(flag[0][j]==1)
				{
					r++;
				}
			}
			for(j=0;j<n;j++)
			{
				if(flag[1][j]==1)
				{
					c++;
				}
			}
			System.out.println("Case #"+(i+1)+":"+k+" "+r+" "+c);

		}
	}
}
