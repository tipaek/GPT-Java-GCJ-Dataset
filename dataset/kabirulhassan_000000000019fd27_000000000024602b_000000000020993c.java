import java.util.*;
public class Main
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		String S="";
		for(int xt=1;xt<=t;xt++)
		{
			int n=sc.nextInt();
			int r=0,c=0,s=0;
			int A[][] = new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					A[i][j]=sc.nextInt();
			for(int i=0;i<n;i++)
			{
				outer : for(int j=0;j<n;j++)
				{
					int f=0;
					for(int k=j;k<n;k++)
					{
						if(A[i][j]==A[i][k])
						{
							f++;
							if(f>1)
							{
								r++;
								break outer;
							}
						}
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				outer : for(int j=0;j<n;j++)
				{
					int f=0;
					for(int k=j;k<n;k++)
					{
						if(A[j][i]==A[k][i])
						f++;
						if(f>1)
						{
							c++;
							break outer;
						}
					}
				}
			}
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i==j)
						s+=A[i][j];
				}
			}
			S=S+"Case #"+xt+": "+s+" "+r+" "+c+"\n";
		}
		System.out.println(S);
		sc.close();
	}
}
