import java.util.*;
import java.lang.*;
import java.lang.Math; 
class Solutions
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int x=0;x<t;x++)
		{
			int n=sc.nextInt();
			int m[][]=new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					int m2=sc.nextInt();
					m[i][j]=m2;
				}
			}
			int trace=0;

	        int sum=0;
	        int sum2=0;

	        int s=0;
	        int s2=0;
	        for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(i == j)
	            	 {
	               	     trace = trace + (m[i][j]);
	               	 }
					int z=m[i][j];
					sum2=0;
					s2=0;
						for(int q=0;q<n;q++)
						{
							if(q<n)
							{
								if(z==m[i][q])
								{
									sum2=sum2+1;
								}
							}
							if(q<n)
							{
								if(z==m[q][i])
								{
									s2=s2+1;
								}
							}
						}
				
					if(sum2>sum)
					{
						sum=sum2;
					}
					if(s2>s)
					{
						s=s2;
					}
				}
			}
			if(sum==1)
			{
				sum=0;
			}
			if(s==1)
			{
				s=0;
			}
			System.out.println("Case #"+(x+1)+": "+trace+" "+sum+" "+s);

		}

	}
}