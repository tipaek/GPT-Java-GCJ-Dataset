import java.util.*;

class Solution{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for(int t = 0;t< tc;t++){
            int N = in.nextInt();
			int K = in.nextInt();
            
            solve(N,K,t+1);
        }
    }
    private static void solve(int N, int k, int caseNo){
        int[][] matrix = new int[N][N];
        boolean[][] rSet = new boolean[N][N];
        boolean[][] cSet = new boolean[N][N];
        int t = 0;
        if(create(matrix,0,0,0,k,rSet,cSet))
            System.out.println("Case #"+caseNo+": POSSIBLE");
        else
        	System.out.println("Case #"+caseNo+": IMPOSSIBLE");
        
    }
    
	private static boolean create(int[][] matrix, int r, int c, int t, int k, boolean[][] rSet, boolean[][] cSet){
		//System.out.println(r+"-"+ c+"-"+ )		
        if(t>k)
            return false;
		for(int i = 1;i<= matrix.length;i++){
            if(rSet[r][i-1] == false){
				matrix[r][c] = i;
				rSet[r][i-1] = true;
				t += i;
				if(c == matrix.length-1){
					if(t == k)
						return true;
					else
						return false;
				}
				if(c+1< matrix.length && create(matrix,r,c+1,t,k,rSet,cSet))
					return true;
				t-=i;
				rSet[r][i-1] = false;
				matrix[r][c] = 0;
			}
        }
        return false;
    }
   
}