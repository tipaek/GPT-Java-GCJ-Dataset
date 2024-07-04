import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Solution 
{
    boolean flag=false;
	 int[][] matrix(int n)
	{
		int C[][] = new int[2 * n + 1][2 * n + 1]; 
	      
        // Calculate value of Binomial Coefficient in 
        // bottom up manner 
        for (int i = 0; i <= 2 * n; i++)  
        { 
            for (int j = 0; j <= Math.min(i, 2 * n); j++)  
            { 
                // Base Cases 
                if (j == 0 || j == i) 
                    C[i][j] = 1; 
      
                // Calculate value using previously 
                // stored values 
                else
                    C[i][j] = C[i - 1][j - 1]  
                              + C[i - 1][j]; 
            } 
        } 
        
        return C;
	}
	 
	 List<int[]> res;
	 void dfs(int mat[][],int n,int i,int j,List<int[]> li,boolean visited[][],int sum,int count)
	 {
		 if(count==500||mat[i][j]==0||visited[i][j])
			 return;
		 
		 if(flag||sum>n)
			 return;
		 
		 if(sum==n)
		 {
		     flag=true;
			 res=new ArrayList<>(li);
			 return;
		 }
		 
		 li.add(new int[] {i+1,j+1});
		 visited[i][j]=true;
		 
		 if(i-1>=0)
			 dfs(mat,n,i-1,j,li,visited,sum+mat[i][j],count+1);

		 if(j-1>=0)
			 dfs(mat,n,i,j-1,li,visited,sum+mat[i][j],count+1);

		 if(i+1<mat.length)
			 dfs(mat,n,i+1,j,li,visited,sum+mat[i][j],count+1);

		 if(j+1<mat[0].length)
			 dfs(mat,n,i,j+1,li,visited,sum+mat[i][j],count+1);

		 if(i-1>=0&&j-1>=0)
			 dfs(mat,n,i-1,j-1,li,visited,sum+mat[i][j],count+1);

		 if(i+1<mat.length&&j+1<mat[0].length)
			 dfs(mat,n,i+1,j+1,li,visited,sum+mat[i][j],count+1);
		 
		 
		 visited[i][j]=false;
		 li.remove(li.size()-1);
		 
	 }
	 int [][] cal(int n)
	 {
		 int mat[][]=matrix(n);
		 
		 boolean visited[][]=new boolean[mat.length][mat[0].length];
		 dfs(mat,n,0,0,new ArrayList<>(),visited,0,1);
		 
		 int ans[][]=new int[res.size()][2];
		 for(int i=0;i<res.size();i++)
		 {
			 ans[i]=res.get(i);
		 }
		 return ans;
	 }
	
public static void main(String args[]) {	
	
	Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	
	int testCases=in.nextInt();
	Solution solution=new Solution();
	for(int count=1;count<=testCases;count++)
	{
	

		int n=in.nextInt();
		int ans[][]=solution.cal(n);
		
		System.out.println("Case #" + count + ": ");
		for(int i=0;i<ans.length;i++)
			System.out.println(ans[i][0]+" "+ans[i][1]);
	}
	

}
}
