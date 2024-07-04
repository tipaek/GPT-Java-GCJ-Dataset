import java.util.*;
public class Solution
{
	public static void main(String arrr[])
	{
		int t;
		Scanner p=new Scanner(System.in);
		t=p.nextInt();
		int xx=1;
		while(t>=1)
		{
			int n=p.nextInt();
			int mat[][]=new int[n][n];
			int i,j,k=0,temp=0,ii,jj,r=0,d=0,c=0;
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					mat[i][j]=p.nextInt();
					if(i==j)
						k=k+mat[i][j];
				}
			}
			
			///next
			for(ii=0;ii<n;ii++)
			{
				temp=0;
				for(jj=0;jj<n;jj++)
				{ 
					temp=0;
					i=ii;
					d=0;
						for(j=0;j<n;j++)
						{
							if(mat[ii][jj]==mat[i][j])
							{
								if(d==0)
									d=1;
								else
								if(d==1)
								{
								r++;
								
								temp=9;
								break;
								}
							}
						}
						if(temp==9)break;
						
				}
			}
			int trmat[][]=new int[n][n];
			System.out.println();
				for(i=0;i<n;i++)
				{
					for(j=0;j<n;j++)
					{
						trmat[i][j]=mat[j][i];
					//	System.out.print(mat[j][i]+" ");
					}
				//	System.out.println();

				}	
			for(ii=0;ii<n;ii++)
			{
				temp=0;
				for(jj=0;jj<n;jj++)
				{ 
					temp=0;
					i=ii;
					d=0;
						for(j=0;j<n;j++)
						{
							if(trmat[ii][jj]==trmat[i][j])
							{
								if(d==0)
									d=1;
								else
								if(d==1)
								{
								c++;
								
								temp=9;
								break;
								}
							}
						}
						if(temp==9)break;
						
				}
			}
				
			
			System.out.print("Case #"+xx+": "+k+" "+r+" "+c);
			System.out.println();
			xx++;
			t--;
		}
		
	}
	
}