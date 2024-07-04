import java.util.*;
class Solution{
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int p=1;
		while(t-->0)
		{
			
			int n=sc.nextInt();
			int mat[][]=new int[n][n];
			long sum=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					mat[i][j]=sc.nextInt();
					if(i==j)
						sum+=mat[i][j];
				}
			}
			
			solve(mat,n,sum,p);
			p++;
		}
	}
	
	public static void solve(int mat[][],int n,long sum,int p)
	{
		int row=0,col=0;
		for(int i=0;i<n;i++)
		{
			HashMap<Integer,Integer> h=new HashMap<>();
			
			for(int j=0;j<n;j++)
			{
				if(h.containsKey(mat[i][j]))
				{
					row++;
					j=n;
				}
				else
					h.put(mat[i][j], 1);
			}
		}
		
		for(int j=0;j<n;j++)
		{
			HashMap<Integer,Integer> h=new HashMap<>();
			for(int i=0;i<n;i++)
			{
				if(h.containsKey(mat[i][j]))
				{
					col++;
					i=n;
				}
				else
					h.put(mat[i][j], 1);
			}
		}
		
		System.out.println("Case #"+p+": "+sum+" "+row+" "+col);
	}

}
