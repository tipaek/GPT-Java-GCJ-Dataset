import java.util.*;
class Codejam
{
	public static void main(String []args)
	{
		int T,N,i,j,k,counter=0,trace=0,r=0,c=0;
		Scanner sc=new Scanner(System.in);
		try
		{
		T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			N=sc.nextInt();
			int [][]array=new int[N][N];
			for(i=0;i<N;i++)
			{
				for(j=0;j<N;j++)
				{
					array[i][j]=sc.nextInt();
					if(i==j)
					{
						trace=trace+array[i][j];
					}
				}
			}

			for(i=0;i<N;i++)
			{
				Break:
				for(k=1;k<=N;k++)
				{
					counter=0;
					for(j=0;j<N;j++)
					{
						if(array[i][j]==k)
							counter++;
						if(counter>1)
						{
							r++;
							break Break;
						}
					}
				}
			}
			for(j=0;j<N;j++)
			{
	
				Break:
				for(k=1;k<=N;k++)
				{
					counter=0;
					for(i=0;i<N;i++)
					{
						if(array[i][j]==k)
							counter++;
						if(counter>1)
						{
							c++;
							break Break;
						}
					}
				}
			}

			System.out.println("Case #"+t+": "+trace+" "+r+" "+c);
		}	
		}
		catch(Exception e)
		{
		
		}
	}
}



/*
Case #1: 4 0 0
Case #2: 9 4 4
Case #3: 8 0 2
*/