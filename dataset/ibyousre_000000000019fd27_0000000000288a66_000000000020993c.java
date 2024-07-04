
import java.util.Scanner;

class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int ti=0;ti<t;ti++) {
            int n = in.nextInt();
            int[][] m = new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    m[i][j] = in.nextInt();
            solve(ti+1, m);
        }
    }
    private static void solve(int t, int[][] m){
        int rowsWithRepetition = 0;
        int colsWithRepetition = 0;
        int diagonalSum = 0;
        for(int i=0, n = m.length;i<n;i++){
            diagonalSum+=m[i][i];
            int[] rowCount = new int[n];
            int[] colCount = new int[n];
            boolean rowHasRepetition = false;
            boolean colHasRepetition = false;
            for(int j=0;j<n;j++){
                rowHasRepetition |= ++rowCount[m[i][j]-1]>1;
                colHasRepetition |= ++colCount[m[j][i]-1]>1;
            }
            rowsWithRepetition+=rowHasRepetition?1:0;
            colsWithRepetition+=colHasRepetition?1:0;
        }
        System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, rowsWithRepetition, colsWithRepetition);
    }
}