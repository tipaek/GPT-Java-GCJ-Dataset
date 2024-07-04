import java.util.*;


public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = 0,n=0;
		t = sc.nextInt();
		
		for(int l=0;l<t;l++)
		{
			n = sc.nextInt();
			Integer m[][]=new Integer[n][n];
			int k=0,i=0,j=0;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					m[i][j]=sc.nextInt();
				}
			}
			System.out.println();
			for(i=0;i<n;i++)
			{
				k+=m[i][i];
			}
			int flag1=0,flag2=0,r=0,c=0;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					for(int h=j+1;h<n;h++)
					{
						if(m[i][j]==m[i][h])
						{
							flag1++;
						}
						if(m[j][i]==m[h][i])
						{
							flag2++;
						}
					}
				}
				if(flag1!=0)
				{
					r++;
					flag1=0;
				}
				if(flag2!=0)
				{
					c++;
					flag2=0;
				}
			}
			System.out.println("Case #"+(l+1)+": "+k+" "+r+" "+c);
		}
		
	}

}
