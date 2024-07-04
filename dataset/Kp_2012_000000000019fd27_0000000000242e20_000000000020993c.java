import java.util.*;
import java.util.stream.*;
import java.util.Set;

public class Solution{
	public static void main(String[] args)
	{
		int n,a,b,i,j,t,r=0,c=0;
		Scanner s=new Scanner(System.in);
		int test=s.nextInt();
		int[][] ans=new int[test][3];
		int ar[]=new int[test];
		b=test;
		for(i=0;i<test;i++)
		{
			n=s.nextInt();
			int[][] mat =new int[n][n];
			for(j=0;j<n;j++)
			{
				for(a=0;a<n;a++){
					mat[j][a]=s.nextInt();
				}
			}
			ans[i][0]=0;
			ans[i][1]=0;
			ans[i][2]=0;

			for(j=0;j<n;j++)
			{
				ans[i][0]=ans[i][0]+mat[j][j];

			}

			
			for(j=0;j<n;j++)
			{
				Set<Integer> set=new HashSet<Integer>();

				for(a=0;a<n;a++)
				{
					set.add(mat[j][a]);
					
					if(set.size()<a+1)
					{
						r=r+1;
						break;
						
					}
					

				}
				ans[i][1]+=r;
				r=0;


			}
			for(j=0;j<n;j++)
			{
				Set<Integer> set1=new HashSet<Integer>();
				for(a=0;a<n;a++)
				{
					set1.add(mat[a][j]);
					if(set1.size()<a+1)
					{
						c=c+1;
						break;
						
					}
					

				}
				ans[i][2]=ans[i][2]+c;
				c=0;
				

			}


		}
		for(j=0;j<b;j++)
		{
			System.out.println("Case #"+j+1+" "+ans[j][0]+" "+ans[j][1]+" "+ans[j][2]);
		}

	}
}


