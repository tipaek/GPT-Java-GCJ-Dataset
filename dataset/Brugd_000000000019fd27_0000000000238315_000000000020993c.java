import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        
        int T;
        int[][] mat;
        T = input.nextInt();
        
        for (int i = 0; i < T; i++) {            
            mat = readMatrix(input);
            int[] res = solution(mat);
            output.println(String.format("Case #%d: %d %d %d",(i+1), res[0], res[1], res[2]));
            output.flush();
        }
    }
    
    public static int[][] readMatrix(Scanner input) {
        int N = input.nextInt();
        int[][] matrix = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        
        return matrix;
    }
    
    public static int[] solution(int[][] mat) {
        // 0 : trace sum
        // 1 : number rows contains repeated numbers
        // 2 : number of columns contains repeated numbers
        int[] res = new int[3];
        int N = mat.length;
        
        boolean[][] seenOnRow = new boolean[N + 1][N + 1];
        boolean[][] seenOnCol = new boolean[N + 1][N + 1];
        
        boolean[] invalidRows = new boolean[N];
        boolean[] invalidCols = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    res[0] += mat[i][j];
                }
                
                // have this row seen this element before and row is still marked as invalid
                if (seenOnRow[i][mat[i][j]] && !invalidRows[i]) {
                    invalidRows[i] = true;
                    res[1]++;
                }
                
                // have this col seen this element before
                if (seenOnCol[j][mat[i][j]] && !invalidCols[j]) {
                    invalidCols[j] = true;
                    res[2]++;
                }
                
                // mark value as seen
                seenOnRow[i][mat[i][j]] = true;
                seenOnCol[j][mat[i][j]] = true;              
                
            }
        }
    
        return res;
    }
}