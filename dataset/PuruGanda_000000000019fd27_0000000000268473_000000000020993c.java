import java.util.Scanner;

class abc
{
	static void fun(int tn)
		{
			Scanner sa=new Scanner(System.in);
			int n=sa.nextInt();
			int a[][]=new int[n][n];
			int s=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					a[i][j]=sa.nextInt();
					if(i==j)
					{
						s=s+a[i][j];
					}
				}
			}
			int tr,tc;
			int ro=0,co=0;
			for(int i=0;i<n;i++)
			{
				int r=0,c=0;
				for(int j=0;j<n;j++)
				{
					tr=a[i][j];
					tc=a[j][i];
					for(int k=j+1;k<n;k++)
					{
						if(tr==a[i][k])
						{
							r=1;
						}
						if(tc==a[k][i])
						{
							c=1;
						}
					}
				}
				if(r==1)
				{
					ro=ro+1;
				}
				if(c==1)
				{
					co=co+1;
				}
			}
			System.out.println("Case #"+tn+": "+s+" "+ro+" "+co);
		}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
			fun(i+1);
		}
	}
}