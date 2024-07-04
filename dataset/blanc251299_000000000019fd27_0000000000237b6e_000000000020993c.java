import java.util.*;
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++)
		{
			int n=sc.nextInt();
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=sc.nextInt();
				}
			}
			int trace=0,row=0,col=0;
			for(int i=0;i<n;i++)
			{
				trace+=arr[i][i];
			}
			for(int i=0;i<n;i++)
			{
				boolean flag=true;
				ArrayList<Integer> al=new ArrayList<>();
				for(int j=0;j<n;j++)
				{
					if(arr[i][j]>n)
					{
						flag=false;
						break;
					}
					else if(al.contains(arr[i][j]))
					{
						flag=false;
						break;
					}
					else
					{
						al.add(arr[i][j]);
					}
				}
				if(!flag)
				{
					row++;
				}
			}
			for(int i=0;i<n;i++)
			{
				boolean flag=true;
				ArrayList<Integer> al=new ArrayList<>();
				for(int j=0;j<n;j++)
				{
					if(arr[j][i]>n)
					{
						flag=false;
						break;
					}
					else if(al.contains(arr[j][i]))
					{
						flag=false;
						break;
					}
					else
					{
						al.add(arr[j][i]);
					}
				}
				if(!flag)
				{
					col++;
				}
			}
			System.out.println("#"+(t+1)+": "+trace+" "+row+" "+col);
		}
	}
}