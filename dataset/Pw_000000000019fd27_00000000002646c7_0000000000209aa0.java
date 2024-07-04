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
        if(createFull(matrix,0,0,0,k,rSet,cSet)){
            System.out.println("Case #"+ caseNo+": POSSIBLE");
			printMatrix(matrix);
		}
        else
        	System.out.println("Case #"+ caseNo+": IMPOSSIBLE");
        
    }
    private static boolean createFull(int[][] matrix, int r, int c, int t, int k, boolean[][] rSet, boolean[][] cSet){
		
        if(t>k)
            return false;
		//printMatrix(matrix);
        for(int i = 0;i< matrix.length;i++){
            if(rSet[r][i]== false && cSet[c][i]==false){
			    if(r == matrix.length-1 && c == matrix.length-1){
					if(t+i+1 == k){
						matrix[r][c] = i+1;
						return true;
					}
					return false;
				}
                rSet[r][i] = true;
                cSet[c][i] = true;
                matrix[r][c] = i+1;
                if(r==c){
                    t = t+matrix[r][c];
                }
				
                int nextc = c+1;
                int nextr = r;
                if(nextc==matrix.length){
                    nextc = 0;
                    nextr++;
                }
				//System.out.println(isValid(nextr,nextc,matrix.length));
				//isValidT(t,k,r, matrix.length) && 
                if(isValidT(t,k,r, matrix.length) &&  isValid(nextr,nextc,matrix.length) && createFull(matrix,nextr,nextc,t,k,rSet,cSet)){
                    return true;
                }
                rSet[r][i] = false;
                cSet[c][i] = false;
                if(r==c){
                    t = t-matrix[r][c];
                }
                matrix[r][c] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int r, int c, int N)
    {
        return r>=0 && r< N && c>=0 && c<N;
    }
	
	private static void printMatrix(int[][] matrix){
		for(int i = 0;i< matrix.length;i++){
			//System.out.print("[");
			for(int j = 0;j< matrix.length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			//System.out.print("]");
			System.out.println("");
		}
	}
	private static void printMatrix(boolean[][] matrix){
		for(int i = 0;i< matrix.length;i++){
			//System.out.print("[");
			for(int j = 0;j< matrix.length;j++){
				System.out.print(matrix[i][j]);
				if(j!=matrix.length-1){
				   System.out.print(" "); 
				}
			}
			//System.out.print("]");
			System.out.println("");
		}
	}
}