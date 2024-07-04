import java.util.Scanner;
import java.util.Arrays;
public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long A[][] = new long[T][];
		long D[] = new long[T];
		for(int k=0;k<T;k++)
		{
			int N = sc.nextInt();
			D[k] = sc.nextLong();
			A[k] = new long[N];
			for(int i=0;i<N;i++)
			{
				A[k][i] = sc.nextLong();
			}
			Arrays.sort(A[k]);
		}
		for(int k=0;k<T;k++)
		{
			long min = D[k]-1;
			for(int i=0;i<A[k].length-1;i++)
			{
				long p = 1;
				long cut = 0;
				for(int j=i+1;j<A[k].length&&p<D[k];j++)
				{
					long temp = A[k][j]/A[k][i];
					long piWant = D[k]-p;
					if(temp>piWant)
					{
						cut+=piWant;
						p+=piWant;
					}
					else
					{
						if(A[k][j]%A[k][i]==0)
						{
							cut+=(temp-1);	
						}
						else
						{
							cut+=temp;
						}
						p+=temp;
					}
				}
				if(p==D[k])
				{
					min = min<cut?min:cut;
				}
			}
			System.out.println("Case #"+(k+1)+": "+min);
		}
	}
}