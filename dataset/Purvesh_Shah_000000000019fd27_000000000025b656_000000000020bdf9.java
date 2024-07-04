import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int T=scan.nextInt();
		
		for(int i=1;i<=T;i++)
		{
			String ans="";
			int[] J={0,0};
			int[] C={0,0};
			
			int N=scan.nextInt();
			int[] S=new int[N];
			int[] E=new int[N];
			for(int j=0;j<N;j++)
			{
				S[j]=scan.nextInt();
				E[j]=scan.nextInt();
			}
			for(int j=0;j<N;j++)
			{
				if(C[1]<=S[j] || C[0]>=E[j])
				{
					ans=ans+"C";
					C[0]=S[j];
					C[1]=E[j];
				}
				else if(J[1]<=S[j] || C[0]>=E[j])
				{
					ans=ans+"J";
					J[0]=S[j];
					J[1]=E[j];
				}
				else
				{
					ans="IMPOSSIBLE";
					break;
				}
			}
			System.out.println("Case #"+i+": "+ans);
			
		}

	}

}
