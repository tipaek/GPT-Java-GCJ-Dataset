import java.util.*;


public class Solution 
{
	boolean flag;
	
	void dfs(int mat[][],int in,int jn,int k,int n,Map<Integer,Set<Integer>> row,Map<Integer,Set<Integer>> col)
	{
		if(flag)
			return;
		if(in==n-1&&jn==n)
		{
			int f=0;
			for(int i=0;i<n;i++)
				f=f+mat[i][i];
			if(f==k)
				flag=true;
			
			return;
		}
		
		if(jn==n)
		{
			in=in+1;
			jn=0;
		}
		if(in==n)
			return;
		
		
		for(int i=1;i<=n;i++)
		{
			if(!row.get(in).contains(i)&&!col.get(jn).contains(i))
			{
				row.get(in).add(i);
				col.get(jn).add(i);
				mat[in][jn]=i;
				dfs(mat,in,jn+1,k,n,row,col);
				
				if(flag)
					return;
				
				row.get(in).remove(i);
				col.get(jn).remove(i);
			}
		}
	}
	
	
	int [][]cal(int n,int k)
	{
		flag=false;
		int mat[][]=new int[n][n];
		
		Map<Integer,Set<Integer>> row=new HashMap<>();
		Map<Integer,Set<Integer>> col=new HashMap<>();
		
		for(int i=0;i<=n;i++)
		{
			row.put(i,new HashSet<>());
			col.put(i,new HashSet<>());
		}
		dfs(mat, 0, 0, k, n, row, col);
		
		
		return mat;
	}
	
	
public static void main(String arrr[]) {	
	
	Scanner in=new Scanner(System.in);
	
	int t=in.nextInt();
	
	for(int ii=1;ii<=t;ii++)
	{
		Solution solution=new Solution();
		int n=in.nextInt();
		int k=in.nextInt();
		int mat[][]=solution.cal(n, k);
		if(!solution.flag)
		System.out.println("Case #"+ii+":"+" IMPOSSIBLE");
		else
		{
			System.out.println("Case #"+ii+":"+" POSSIBLE");
			for(int i=0;i<mat.length;i++)
			{
				for(int j=0;j<mat.length;j++)
					System.out.print(mat[i][j]+" ");
				System.out.println();
			}
		}
		
	}
	
	in.close();
}
}
