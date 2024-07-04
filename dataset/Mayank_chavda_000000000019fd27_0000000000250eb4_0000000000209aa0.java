import java.util.*;
public class Solution {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		s.nextLine();
		for(int k=0;k<T;k++)
		{
			int t=k+1;
			String[] NK=s.nextLine().split(" ");
			int N=Integer.parseInt(NK[0]);
			int K=Integer.parseInt(NK[1]);
			int[][] result=new int[N][N];
			if(K%N==0)
			{
				System.out.println("Case #"+t+": POSSIBLE");
				int x=K/N;
				creatmat(result,x);
			}
			else
			{
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
		}
	}

	private static void creatmat(int[][] result, int x) {
	    int N=result.length;
	    int k=N+1;
		for(int i=1;i<=N;i++)
		{
			String[] val=new String[N];
			int j=0;
			int temp=k;
			while(temp<=N)
			{
				val[j]=String.valueOf(temp);
				temp++;
				j++;
			}
			for(int m=1;m<k;m++)
			{
				val[j]=String.valueOf(m);
				j++;
			}
			k--;
			for(int k1=0;k1<N;k1++)
			{
				result[i-1][k1]=Integer.parseInt(val[k1]);
			}
		}
		x--;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				result[i][j]=(result[i][j]+x)%N;
				if(result[i][j]==0)
					result[i][j]=N;
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=i;j<N;j++)
			{
				int temp1=result[i][j];
				result[i][j]=result[j][i];
				result[j][i]=temp1;
			}
		}
	/*	for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}*/
	}
}
