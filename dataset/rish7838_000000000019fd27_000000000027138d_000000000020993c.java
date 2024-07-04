import java.util.*;

class Solution
{
	public static void main(String s[])
	{
		
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		ArrayList<String> list = new ArrayList();
		for(int k=0;k<t;k++)
		{
			int n = sc.nextInt();
			int a[][] = new int[n][n];
			long sum = 0;
			int max1 = 0;
			int max2 = 0;
			int rc = 0,cc=0;
			for(int i=0;i<n;i++)
			{
				
				for(int j=0;j<n;j++)
				{
					a[i][j] = sc.nextInt();
				}
			}
			for(int i=0;i<n;i++)
			{
				int b1[] = new int[n+1];
				int b2[] = new int[n+1];
				for(int j=0;j<n;j++)
				{
					if(i==j)
						sum+=a[i][j];
					
					b1[a[i][j]]++;
					b2[a[j][i]]++;
					max1 = Math.max(max1,b1[a[i][j]]);
					max2 = Math.max(max2,b2[a[j][i]]);
				}
				if(max1>1)
					rc++;
				if(max2>1)
					cc++;
				max1= 0;
				max2= 0;
			}
			
			String ans = "Case #"+k+": "+sum+" "+rc+" "+cc;
			list.add(ans);
			//System.out.println("Case #"+k+": "+sum+" "+rc+" "+cc);
		}
		
		for(String ans1: list)
			System.out.println(ans1);
	
		
		
			
				
	}
}