import java.util.Scanner;
import java.util.Arrays;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,n,d,i,j;
	long[] a=new long[10000];	
	long[] b=new long[10000];
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		long[][] hash=new long[10000][2];
		int k=0;
		long maxfreq=0;
		int pos=0;
		n=scan.nextInt();
		d=scan.nextInt();
		for(j=0;j<n;++j)	
			a[j]=scan.nextLong();
		b=a.clone();
		Arrays.sort(b,0,n);
		hash[0][0]=b[0];
		hash[0][1]=1;
		for(j=1;j<n;++j)
			{
			if(b[j]==b[j-1])
				{
				++hash[k][1];
				if(hash[k][1]>maxfreq)
					{
					maxfreq=hash[k][1];
					pos=k;
					}
				}
			else 
				{
				++k;
				hash[k][0]=b[j];
				hash[k][1]=1;
				if(hash[k][1]>maxfreq)
					{
					maxfreq=hash[k][1];
					pos=k;
					}
				}
			}
		System.out.print("Case #"+i+": ");
		if(maxfreq>=d)
			System.out.println(0);
		else if(n==1)
			System.out.println((d-1));
		else
			{
			if(d==2)
				System.out.println(1);
			else
				{
				for(j=0;j<=k;++j)
					if(j!=pos&&(hash[j][0]*2==hash[pos][0]||hash[pos][0]*2==hash[j][0]))
						break;
				/*if(maxfreq==2)
					{
					if(pos==k-1)
					}*/
				if(j<k)
					System.out.println(1);
				else
					{
					if(maxfreq==1)
						System.out.println(2);
					else
						System.out.println(1);
					}
				}
			}
		}
	}
}