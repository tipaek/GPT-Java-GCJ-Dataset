import java.util.*;

class Solution{
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        for(int t = 0;t< tc;t++){
            int N = in.nextInt();
            int[][] matrix = new int[N][N];
            for(int r = 0;r<N;r++){
                for(int c = 0;c<N;c++){
                    matrix[r][c] = in.nextInt();
                }
            }
            solve(matrix,t);
        }
    }
    private static void solve(int[][] matrix, int caseNo){
        int trace = 0;
        int[][] rows = new int[matrix.length][matrix.length];
        int[][] cols = new int[matrix.length][matrix.length];
        int rDup = 0;
        int cDup = 0;
        for(int r = 0;r<matrix.length;r++){
			for(int c = 0;c<matrix.length;c++){
			    if(r==c)
                    trace+=matrix[r][c];
                rows[r][matrix[r][c]-1]++;
				cols[c][matrix[r][c]-1]++;
            }
        }
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix.length;j++){
				if(rows[i][j]>1){
					rDup++;
					break;
				}
			}
			for(int j = 0;j<matrix.length;j++){
				if(cols[i][j]>1){
					cDup++;
					break;
				}
			}
		}
        System.out.println("Case #"+caseNo+": "+ trace+" "+ rDup+" "+ cDup);
        
    }
}