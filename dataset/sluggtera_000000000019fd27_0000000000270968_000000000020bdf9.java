import java.util.Scanner;
public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int S[][] = new int[T][];
		int E[][] = new int[T][];
		for(int k=0;k<T;k++)
		{
			int N = sc.nextInt();
			S[k] = new int[N];
			E[k] = new int[N];
			for(int i=0;i<N;i++)
			{
				S[k][i] = sc.nextInt();
				E[k][i] = sc.nextInt();
			}
		}
		for(int k=0;k<T;k++)
		{
			int C = 0;
			int J = 0;
			int N = S[k].length;
			int A[] = new int[N];
			char ch[] = new char[N];
			int check = 1;
			for(int i=0;i<N;i++)
			{
				A[i] = i;
			}
			for(int i=0;i<(N-1);i++)
			{
				for(int j=(N-1);j>i;j--)
				{
					if(S[k][A[i]]>S[k][A[j]])
					{
						A[i] = A[i]+A[j];
						A[j] = A[i]-A[j];
						A[i] = A[i]-A[j];	
					}
				}	
			}	
			for(int i=0;i<N&&check==1;i++)
			{
				int index = A[i];
				if(C<=S[k][index])
				{
					C = E[k][index];
					ch[index] = 'C';
				}
				else if(J<=S[k][index])
				{
					J = E[k][index];
					ch[index] = 'J';
				}
				else
				{
					check = 0;
				}
			}
			System.out.print("Case #"+(k+1)+": ");
			if(check==0)
			{
				System.out.print("IMPOSSIBLE");
			}
			else
			{
				for(char i : ch)
				{
					System.out.print(i);
				}
			}
			System.out.println();		
		}
	}
}