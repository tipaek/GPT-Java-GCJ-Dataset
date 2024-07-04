import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			int J=0;
			int C;
			int prev=-1;
			String s="";
			int n=sc.nextInt();
			int A[][]=new int[n][2];
			for(int j=0;j<n;j++)
			{
				A[j][0]=sc.nextInt();
				A[j][1]=sc.nextInt();
			}
			s=s+'C';
			C=A[0][1];
			prev=0;
			for(int j=1;j<n;j++)
			{
				if(A[j][0]<A[j-1][1])
				{
					if(prev==0)
					{
						if(J<=A[j-1][1])
						{
							s+='J';
							J=A[j][1];
							prev=1;
						}
						else
						{
							s="IMPOSSIBLE";
							break;
						}
					}
					else 
					{
						if(C<=A[j-1][1])
						{
							s+='C';
							prev=0;
							C=A[j][1];
						}
						else
						{
							s="IMPOSIIBLE";
							break;
						}
					}
				}
				else if(A[j][0]>=A[j-1][1])
				{
					if(prev==0)
					{
						s+='C';
						C=A[j][1];
						prev=0;
					}
					else
					{
						s+='J';
						J=A[j][1];
						prev=1;
					}
				}
			}
			System.out.println("case #"+(1+i)+": "+s);
		}
	}

}
