import java.util.Scanner;
public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int R[] = new int[T];
		int S[] = new int[T];
		for(int k=0;k<T;k++)
		{
			R[k] = sc.nextInt();
			S[k] = sc.nextInt();
		}
		for(int k=0;k<T;k++)
		{
			System.out.println("Case #"+(k+1)+": "+((R[k]-1)*(S[k]-1)));
			int a = R[k];
			int b = (R[k]*(S[k]-1))-1;
			for(int i=a;i>1;i--)
			{
				for(int j=0;j<(S[k]-1);j++)
				{
					System.out.println(i+" "+b);
					b--;
				}
			}
		}
	}
}