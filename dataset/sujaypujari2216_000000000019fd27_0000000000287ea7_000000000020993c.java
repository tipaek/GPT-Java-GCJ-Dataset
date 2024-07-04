import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
class Solution
{
	public static void main(String a[])
	{
		int t=1,n=3,i,j,k=0,r=0,c=0,cnt,m=0;
		int[] arr={2,1,3,1,3,2,1,2,3};
		//int[][] trace=new int[n][n];
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			t=Integer.parseInt(br.readLine());
			for(cnt=1;cnt<=t;cnt++)
			{
				k=0;
				r=0;
				c=0;
				n=Integer.parseInt(br.readLine());
				int[][] trace=new int[n][n];
				for(i=0;i<n;i++)
					for(j=0;j<n;j++)
					{
						trace[i][j]=Integer.parseInt(br.readLine());
						//m++;
					}
				
				for(i=0;i<n;i++)
					k=k+trace[i][i];
				
				for(int jm=0;jm<n;jm++)
				{
					int[] row= new int[n];
					for(j=0,m=0;j<n;j++,m++)
					{
						row[m]=trace[jm][j];
						//System.out.println(row[m]);
					}
					Arrays.sort(row);
					int length = row.length-1;

					for (i = 0; i < length; i++) 
						if (row[i] == row[i + 1]) 
						{
							r++;
							break;
						}
					
					
					
				//System.out.println(j+": " + r);
				}
				
				for(int im=0;im<n;im++)
				{
					int[] col=new int[n];
					for(j=0,m=0;j<n;j++,m++)
					{
						col[m]=trace[j][im];
						//System.out.println(col[m]);
					}
					Arrays.sort(col);
					int length = col.length-1;

					for (i = 0; i < length; i++) 
						if (col[i] == col[i + 1]) 
						{	
							c++;
							break;
						}				
				}
				System.out.println("Case #"+cnt+": "+k+" "+r+" "+c);
						
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println();
	}
}