import java.util.*;
import java.lang.*;
import java.io.*;
class Ideone
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int p=1;
		while(t-->0)
		{
			int n=sc.nextInt();
			int matrix[][]=new int[n][n];
			long su=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					matrix[i][j]=sc.nextInt();
					if(i==j)
						su+=matrix[i][j];
				}
			}
			
			solve(matrix,n,su,p);
			p++;
		}
	}
	
	public static void solve(int matrix[][],int n,long su,int p)
	{
		int row=0,col=0;
		for(int i=0;i<n;i++)
		{
			HashMap<Integer,Integer> h=new HashMap<>();
			for(int j=0;j<n;j++)
			{
				if(h.containsKey(matrix[i][j]))
				{
					row++;
					j=n;
				}
				else
					h.put(matrix[i][j], 1);
			}
		}
		for(int j=0;j<n;j++)
		{
			HashMap<Integer,Integer> h=new HashMap<>();
			for(int i=0;i<n;i++)
			{
				if(h.containsKey(matrix[i][j]))
				{
					col++;
					i=n;
				}
				else
					h.put(matrix[i][j], 1);
			}
		}
		System.out.println("Case #"+p+": "+su+" "+row+" "+col);
	}
}