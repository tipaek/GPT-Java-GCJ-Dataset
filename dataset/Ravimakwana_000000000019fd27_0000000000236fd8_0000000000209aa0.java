import java.util.*;
class Solution{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		for(int t=1;t<=T;t++)
		{
			int n=scan.nextInt();
			int r=scan.nextInt();
			int k=n+1;
			int p=0,q=0;
			int arr[][]=new int[n][n];
			for(int i=1;i<=n;i++)
			{
				int temp=k;
				q=0;
				while(temp<=n)
				{
					arr[p][q++]=temp;
					temp++;
				}
				for(int j=1;j<k;j++)
				{
					arr[p][q++]=j;
				}
				k--;
				p++;
			}
			int sum1=0,sum2=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i==j)
						sum1+=arr[i][j];
					if(i==n-j-1)
						sum2+=arr[i][j];
				}
			}

			if(sum1==r || sum2==r)
			{
				System.out.println("Case #"+t+": POSSIBLE");
			}
			else
				System.out.println("Case #"+t+": IMPOSSIBLE");
		}
	}
}