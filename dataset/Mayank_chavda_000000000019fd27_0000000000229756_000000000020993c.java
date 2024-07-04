import java.util.*;
public class Solution {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int k=0;k<T;k++)
		{
			int N=s.nextInt();
			int[][] mat=new int[N][N];
			s.nextLine();
			for(int i=0;i<N;i++)
			{
				String[] val=s.nextLine().split(" ");
				for(int j=0;j<N;j++)
					mat[i][j]=Integer.parseInt(val[j]);
			}
			int c_t=counttrace(mat,N);
			int c_r=countrow(mat,N);
			int c_c=countcolumn(mat,N);
			int t=k+1;
			System.out.println("Case #"+t+": "+c_t+" "+c_r+" "+c_c);
		}
	}

	private static int countcolumn(int[][] mat, int n) {
		int count=0,a=0;
		for(int i=0;i<n;i++)
		{
			int[] col=new int[n];
			for(int j=0;j<n;j++)
			{
				col[j]=mat[j][i];
			}
			Arrays.sort(col);
			for(int k=0;k<n-1;k++)
			{
				if(col[k]==col[k+1])
				{
					a=1;
					break;
				}
			}
			if(a==1)
			{
				count++;
				a=0;
			}
		}
		return count;
	}

	private static int countrow(int[][] mat, int n) {
		int count=0,a=0;
		for(int i=0;i<n;i++)
		{
			int[] col=new int[n];
			for(int j=0;j<n;j++)
			{
				col[j]=mat[i][j];
			}
			Arrays.sort(col);
			for(int k=0;k<n-1;k++)
			{
				if(col[k]==col[k+1])
				{
					a=1;
					break;
				}
			}
			if(a==1)
			{
				count++;
				a=0;
			}
		}
		return count;
	}

	private static int counttrace(int[][] mat, int n) {
		int count=0;
		for(int i=0;i<n;i++)
			count+=mat[i][i];
		return count;
	}
}
