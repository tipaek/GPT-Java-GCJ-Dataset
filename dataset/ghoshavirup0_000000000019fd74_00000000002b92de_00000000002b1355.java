import java.util.*;


public class Solution 
{
	int count=0;
	void sum(int mat[][],int r,int c,boolean visited[][])
	{
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(!visited[i][j])
					count+=mat[i][j];
			}
				
		}
	}
	
	boolean compass(int mat[][],int i,int j,boolean visited[][],int r,int c)
	{
		int sum=0;
		int avg=0;
		
		int m=0,n=0;
		
		m=i-1;
		while(m>=0&&visited[m][j])
		{
			m--;
		}
		if(m>=0)
		{
			sum+=mat[m][j];
			avg++;
		}
		m=j-1;
		while(m>=0&&visited[i][m])
		{
			m--;
		}
		if(m>=0)
		{
			sum+=mat[i][m];
			avg++;
		}
		n=i+1;
		while(n<r&&visited[n][j])
		{
			n++;
		}
		if(n<r)
		{
			sum+=mat[n][j];
			avg++;
		}
		n=j+1;
		while(n<c&&visited[i][n])
		{
			n++;
		}
		if(n<c)
		{
			sum+=mat[i][n];
			avg++;
		}
		
		if(avg==0)
			return false;
		
		double d=(double)sum/(double)avg;
		if((double)mat[i][j]<d)
			return true;
		
		return false;
	}
	void dfs(int mat[][],int i,int j,int r,int c,boolean visited[][])
	{
		sum(mat,r,c,visited);
		
		boolean flag=false;
		
		boolean visited2[][]=new boolean[r][c];
		
		for(i=0;i<r;i++)
		{
			for(j=0;j<c;j++)
			{
				
				if(!visited[i][j])
				{
					
					if(compass(mat, i, j, visited,r,c))
						{
						flag=true;
						visited2[i][j]=true;
						}
				}
			}
		}
		
		for( i=0;i<r;i++)
		{
			for(j=0;j<c;j++)
				visited2[i][j]|=visited[i][j];
				
		}
		
	
		
		if(flag)
			dfs(mat,i,j,r,c,visited2);
	}
	
	int cal(int mat[][],int r,int c)
	{
		boolean visited[][]=new boolean[r][c];
		dfs(mat,0,0,r,c,visited);
		return count;
	}
	
	
public static void main(String arrr[]) {	
	
	Scanner in=new Scanner(System.in);
	
	
	int testCases=in.nextInt();
	
	for(int count=1;count<=testCases;count++)
	{
		Solution solution=new Solution();
		
		int r=in.nextInt();
		int c=in.nextInt();
		int mat[][]=new int[r][c];
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
				mat[i][j]=in.nextInt();
		}
		
		int ans=solution.cal(mat,r,c);
		
		System.out.println("Case #"+count+": "+ans);
	}
	
	in.close();
}
}
