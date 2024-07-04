import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int x=1;x<=t;x++)
		{
			int n=sc.nextInt();
			
			int [][] m=new int[n][n];
			
			int k=0,r=0,c=0,i1=0,j1=0,b=0;;
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					m[i][j]=sc.nextInt();
					
					if(i==j)
					{
						k+=m[i][j];
					}
					
					if(i==i1)
					{
						for(int jj=0;jj<j && b!=1;jj++)
						{
							if(m[i][j]==m[i][jj])
							{
								++r;
								b=1;
							}
						}
				
					}
					else
					{
						i1=i;
						b=0;
					}

				}
			}
			
			b=0;
			
			for(int j=0;j<n;j++)
			{
				for(int i=0;i<n;i++)
				{			
					
					if(j==j1)
					{
						for(int ii=0;ii<i && b!=1;ii++)
						{
							if(m[i][j]==m[ii][j])
							{
								++c;
								b=1;
							}
						}
				
					}
					else
					{
						j1=j;
						b=0;
					}

				}
			}
			
			System.out.println("Case #"+x+": "+k+" "+r+" "+c);
			
		}

	}

}
