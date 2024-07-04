import java.util.Scanner;
public class Solution{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++)
		{
			int Js=0;
			int Je=0;
			int Ce;
			int Cs;
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
			Cs=A[0][0];
			Ce=A[0][1];
			prev=0;
			for(int j=1;j<n;j++)
			{
				if(A[j][0]<A[j-1][1])
				{
					if(prev==0)
					{
						if(Je<=A[j][0])
						{
							s+='J';
							Je=A[j][1];
							Js=A[j][0];
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
						if(Ce<=A[j][0])
						{
							s+='C';
							prev=0;
							Ce=A[j][1];
							Cs=A[j][0];
						}
						else
						{
							s="IMPOSSIBLE";
							break;
						}
					}
				}
				else if(A[j][0]>=A[j-1][1])
				{
					if(prev==0)
					{
						s+='C';
						Cs=A[j][0];
						Ce=A[j][1];
						prev=0;
					}
					else
					{
						s+='J';
						Js=A[j][0];
						Je=A[j][1];
						prev=1;
					}
				}
			}
			System.out.println("case #"+(1+i)+": "+s);
		}
	}

}
