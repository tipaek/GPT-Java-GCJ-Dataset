import java.util.*;

 class Solution {

	public static void main(String are[])
	{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int q=1;q<=T;q++)
		{
		int N = scan.nextInt();
		int matrix[][] = new int[N][N];
		for(int i = 0; i<N;i++)
		{
			for(int j= 0;j<N;j++) {
				matrix[i][j] = scan.nextInt();
			}
		}
		int rows=0,cols=0;	
		boolean flag1=false, flag2=false;

		  for(int t=0;t<N;t++)
	        {
	            flag1=false;
	            for(int u=0;u<N;u++)
	            {
	                for(int k=u+1;k<N;k++)
	                {
	                   if(matrix[t][u]==matrix[t][k])
	                   {
	                       rows++;
	                       flag1=true;
	                       break;
	                   }
	                }

	                if(flag1)
	                break;
	            }
	        }

	        for(int u=0;u<N;u++)
	        {
	            flag2=false;
	            for(int t=0;t<N;t++)
	            {
	                for(int k=t+1;k<N;k++)
	                {
	                    if(matrix[t][u]==matrix[k][u])
	                    {
	                        cols++;
	                        flag2=true;
	                        break;
	                    }
	                }

	                if(flag2)
	                break;
	            }
	        }

	        int ans = sum_diagonal(matrix);
	        System.out.println("Case #"+q+": "+ans+" "+rows+" "+cols);
	        
		}
	}

static int sum_diagonal(int matrix[][])
{
	int sum = 0;
	for(int i=0;i<matrix.length;i++)
	{
		sum = sum+matrix[i][i];
	}
	return sum;
}

}
