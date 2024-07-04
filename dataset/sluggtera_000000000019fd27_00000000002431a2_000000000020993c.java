import java.util.*;

import java.io.*;

public class Solution

{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int M[][][] = new int[T][][];
		for(int w=0;w<T;w++)
		{
			int N = sc.nextInt();
			M[w] = new int[N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					M[w][i][j] = sc.nextInt();
				}
			}
		}
		for(int w=0;w<T;w++)
		{
			int x = w+1;
			int k = 0;
			int r = 0;
			int c = 0;
			int N = M[w].length;
			for(int i=0;i<N;i++)
			{
				int A[] = new int[101];
				int B[] = new int[101];
				int p = 0;
				int q = 0;
				for(int j=0;j<N;j++)
				{
					int a = M[w][i][j];
					int b = M[w][j][i];
					if(i==j)
					{
						k+=a;
					}
					A[a]++;
					B[b]++;
					if(A[a]==2&&p==0)
					{
						r++;
						p++;
					}
					if(B[b]==2&&q==0)
					{
						c++;
						q++;
					}
				}
			}
			System.out.println("Case #"+x+": "+k+" "+r+" "+c);
		}
	}
}