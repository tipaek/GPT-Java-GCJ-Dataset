import java.util.Scanner;
import java.util.Arrays;
class Solution
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,n,d,i,j;
	int[] a=new int[10000];	
	int[] b=new int[10000];
	t=scan.nextInt();
	for(i=1;i<=t;++i)
		{
		int[][] hash=new int[10000][2];
		int k=0;
		int maxfreq=0;
		int pos=0;
		n=scan.nextInt();
		d=scan.nextInt();
		for(j=0;j<n;++j)	
			a[j]=scan.nextInt();
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
		else
			{
			if(d==2)
				System.out.println(2);
			else
				{
				for(j=0;j<k;++j)
					if(j!=pos&&(hash[j][0]*2==hash[pos][0]||hash[pos][0]*2==hash[j][0]))
						break;
				if(j<k)
					System.out.println(2);
				else
					System.out.println(3);
				}
			}
		}
	}
}