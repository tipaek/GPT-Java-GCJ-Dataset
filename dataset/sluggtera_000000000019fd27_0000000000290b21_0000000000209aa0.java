import java.util.Scanner;
public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N[]  = new int[T];
		int K[] = new int[T];
		for(int k=0;k<T;k++)
		{
			N[k] = sc.nextInt();
			K[k] = sc.nextInt();	
		}
		for(int k=0;k<T;k++)
		{
			int l = N[k];
			int r = N[k]*N[k];
			if(K[k]>=l && K[k]<=r)
			{
				if(K[k]%N[k]==0)
				{
					System.out.println("Case #"+(k+1)+": POSSIBLE");
					int num = K[k]/N[k];
					for(int i=0;i<N[k];i++)
					{
						for(int j=0;j<(N[k]-1);j++)
						{
							System.out.printf("%-3d",(num));
							num--;
							if(num<1)
							{
								num = N[k];
							}	
						}
						System.out.printf("%-3d\n",(num));
					}
				}
				else
				{
					System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
				}
			}
			else
			{
				System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
			}
		}
	}
}