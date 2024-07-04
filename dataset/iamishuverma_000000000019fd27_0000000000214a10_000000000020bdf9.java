import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,n,i,j,k,ej,ec;
	int[] s=new int[1000];
	int[] s1=new int[1000];
	int[] e=new int[1000];
	int[] e1=new int[1000];
	int[] index=new int[1000];
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		String ans="";
		ej=ec=-1;
		boolean flag=true;
		n=scan.nextInt();
		for(j=0;j<n;++j)
			index[j]=j+1;
		for(j=0;j<n;++j)
			{
			s[j]=scan.nextInt();
			s1[j]=s[j];
			e[j]=scan.nextInt();
			e1[j]=e[j];
			}
		for(j=n-1;j>=0;--j)
			for(k=0;k<j;++k)
				if(s1[k]>s1[k+1])
					{
					int temp=s1[k];
					s1[k]=s1[k+1];
					s1[k+1]=temp;
					temp=e1[k];
					e1[k]=e1[k+1];
					e1[k+1]=temp;
					temp=index[k];
					index[k]=index[k+1];
					index[k+1]=temp;
					}
		for(j=0;j<n;++j)
			System.out.println(s1[j]+" "+e1[j]);
		for(j=0;j<n;++j)
			{
			if(ans.equals("IMPOSSIBLE"))
				break;
			if(ej==-1)
				{
				ej=e1[j];
				ans+="J";
				}
			else if(ej<=s1[j])
				{
				ej=e1[j];
				ans+="J";
				}
			else if(ec==-1)
				{
				ec=e1[j];
				ans+="C";
				}
			else if(ec<=s1[j])
				{
				ec=e1[j];
				ans+="C";
				}
			else
				{
				ans="IMPOSSIBLE";
				}
			}
		System.out.print("Case #"+i+": ");
		if(ans.equals("IMPOSSIBLE"))
			System.out.print(ans);
		else
			{
			for(j=1;j<=n;++j)
				{
				for(k=0;k<n;++k)
					{
					if(index[k]==j)	
						{
						System.out.print(ans.charAt(k));
						break;
						}
					}
				}
			}
		System.out.println();
		}
	}
}