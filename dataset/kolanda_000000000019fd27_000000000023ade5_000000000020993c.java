import java.util.*;
class Solution {

	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int tc;
		ArrayList tra=new ArrayList();
		ArrayList nra=new ArrayList();
		ArrayList nca=new ArrayList();
		tc=sc.nextInt();
		for(int t=0;t<tc;t++)
		{
			int n,trace=0,nr=0,nc=0;
			n=sc.nextInt();
			int a[][]=new int[n][n];
			for(int i=0;i<n;i++)
			{
				HashSet hs=new HashSet();
				for(int j=0;j<n;j++)
				{
					a[i][j]=sc.nextInt();
					if(i==j)
					{
						trace=trace+a[i][j];
					}
					hs.add(a[i][j]);
				}
				if(hs.size()<n)
				{
					nr=nr+1;
				}
			}
			for(int j =0;j<n;j++)
			{
				HashSet hs1=new HashSet();
				for (int k=0;k<n;k++)
				{
					hs1.add(a[k][j]);
				}
				if(hs1.size()<n)
				{
					nc=nc+1;
				}
			}
			tra.add(trace);
			nra.add(nr);
			nca.add(nc);
		}
		for(int z=0;z<tra.size();z++)
		{
			System.out.println("Case #"+(z+1)+": "+tra.get(z)+" "+nra.get(z)+" "+nca.get(z));
		}			
	}
}
