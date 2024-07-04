import java.util.*;
class Solution{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int i,N,mat[][],j,k=0,r,c,row=0,col=0;
		for(i = 1 ;i<=T;i++)
		{
			N = sc.nextInt();
			mat= new int[N][N];
			for(r=0;r<N;r++)
			{
				for(c=0;c<N;c++)
				{
					mat[r][c]=sc.nextInt();
				}
			}
			for(r=0;r<N;r++)
			{
				k=k+mat[r][r];
			}
			//number of rows containing repeated values
			for(r=0;r<N;r++)
			{
				for (c=0;c<N;c++)
				{
					for (j=c+1;j<N;j++)
					{
					    if(r<N)
					    {
						if(mat[r][c]==mat[r][j])
						{
                            row++;
                            r++;
                            c=-1;
                            break;
                            
						}	}
					}
				}
			}
			//number of columns containing repeated values
			for(c=0;c<N;c++)
			{
				for(r=0;r<N;r++)
				{
					for(j=r+1;j<N;j++)
					{
					    if(c<N)
					    {
					   
					    
						if(mat[r][c]==mat[j][c])
						{
							col++;
						    c++;
						    r=-1;
							break;
							
						
					    }
					    }
					}
				}
			}
			System.out.println("Case #"+i+": "+k+" "+row+" "+col);
			col=0;row=0;k=0;




		}
	}
}