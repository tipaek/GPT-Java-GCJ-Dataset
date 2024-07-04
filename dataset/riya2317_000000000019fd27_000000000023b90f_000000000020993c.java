import java.util.*;
class Solution
{
	public static void main(String s[])
	{
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		int k=1;
		while(k++<=tc)
		{
			int n=sc.nextInt();
			int d=0,r=0,c=0;
			int arr[][]=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					arr[i][j]=sc.nextInt();
			for(int i=0;i<n;i++)
				d+=arr[i][i];
			for(int i=0;i<n;i++)
			{
				HashSet<Integer> hset1=new HashSet<>();
				HashSet<Integer> hset2=new HashSet<>();
				for(int j=0;j<n;j++)
				{
					hset1.add(arr[i][j]);
					hset2.add(arr[j][i]);
				}
				if(hset1.size()<n)
				r++;
				if(hset2.size()<n)
				c++;
			}
			System.out.println("Case #"+(k-1)+": "+d+" "+r+" "+c);
		}
	}
}