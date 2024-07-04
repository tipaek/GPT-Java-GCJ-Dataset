import java.util.*;

class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int a=0;a<t;a++)
		{
			int n=sc.nextInt();
			int arr[][];
			int i,j,tr=0,cr=0,cc=0,k,f;
			arr=new int[n][n];
			
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
					arr[i][j]=sc.nextInt();
					
					if(i==j)
					{
						tr=tr+arr[i][j];
					}
				}
			}
			
			for(i=0;i<n;i++)
			{
				f=0;
				for(j=0;j<n-1;j++)
				{
					for(k=j+1;k<n;k++)
					{
						if(arr[i][j]==arr[i][k])
						{
							if(f==0)
							{
							cr++;
							f++;
							break;
							}
						}
					}
				}
			}
			
			for(j=0;j<n;j++)
			{
				f=0;
				for(i=0;i<n-1;i++)
				{
					for(k=i+1;k<n;k++)
					{
						if(arr[i][j]==arr[k][j])
						{
							if(f==0)
							{
							cc++;
							f++;
							break;
							}
						}
					}
				}
			}
			
			System.out.println("Case #"+(a+1)+": "+tr+" "+cr+" "+cc);
		}
	}
}