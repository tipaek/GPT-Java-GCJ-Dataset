import java.util.*;
class CodeJam1
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		int p=0;
		while(T>0)
		{
			int n=scan.nextInt();
			int a[][]=new int[n][n];
			int aa[]=new int[n];
			int bb[]=new int[n];

			int t=0,c=0,r=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j]=scan.nextInt();
				}
			}
			int row[]=new int[n];
			int col[]=new int[n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i==j)
						t+=a[i][j];
					if(col[j]==0)
					{
						for(int k=i+1;k<n;k++)
						{
							if(a[i][j]==a[k][j])
							{
								col[j]=1;
								break;
							}
						}
					}
					if(row[i]==0)
					{
						for(int k=j+1;k<n;k++)
						{
							if(a[i][j]==a[i][k])
							{
								row[i]=1;
								break;
							}
						}
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				r+=row[i];
				c+=col[i];
			}
			p++;
			System.out.println("Case #"+p+":"+t+" "+r+" "+c);
			T--;
		}
	}
}