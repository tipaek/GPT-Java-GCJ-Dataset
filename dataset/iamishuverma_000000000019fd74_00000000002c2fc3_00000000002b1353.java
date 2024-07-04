import java.util.Scanner;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,n,i,j,k,N;
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		n=scan.nextInt();
		System.out.println("Case #"+i+":");
		N=(int)(Math.floor(Math.log(n+1)/Math.log(2)));
		//System.out.println(N);
		for(j=1;j<=N;++j)
			{
			if(j%2==1)
				{
				for(k=1;k<=j;++k)
					System.out.println(j+" "+k);
				}
			else
				{
				for(k=j;k>=1;--k)
					System.out.println(j+" "+k);
				}
			}
		n-=((int)(Math.pow(2,N))-1);
		if(N%2==0)
			{
			while(n-->0)
				{
				++N;
				System.out.println(N+" 1");
				}
			}
		else
			{
			while(n-->0)
				{
				++N;
				System.out.println(N+" "+N);
				}
			}
		}
	}
}