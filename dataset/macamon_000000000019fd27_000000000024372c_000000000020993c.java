import java.io.*;
import java.math.*;
import java.util.*;
public class Solution {
    static Scanner sc;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int casenum = 1; casenum <= n; casenum++) {
            solve(casenum);
         }
    }
    
    public static void solve(int casenum) {
        int trace = 0;
        int numRowsWithRepeated = 0;
        int numColumnsWithRepeated = 0;
        
        int N = sc.nextInt(); // dimension of the matrix
        int[][] matrix = new int[N][N]; // initial values
        for (int line = 0; line < N; line++) {
            boolean[] existInRow = new boolean[N];
            for (int column = 0; column < N; column++) {
                int value = sc.nextInt();
                if (line == column) {
                    trace += value;
                }
                matrix[line][column] = value;
                existInRow[value-1] = true;
            }
            
            for (int i=0; i<N; i++){
                if (!existInRow[i]) {
                    numRowsWithRepeated++;
                    break;
                }
            }
        }

        for (int column = 0; column < N; column++) {
            boolean[] existInColumn = new boolean[N];
            for (int row = 0; row < N; row++) {
                int value = matrix[row][column];
                existInColumn[value-1] = true;
            }
            
            for (int i=0; i<N; i++){
                if (!existInColumn[i]) {
                    numColumnsWithRepeated++;
                    break;
                }
            }
        }        
           
        StringBuilder sb = new StringBuilder();
        sb.append("Case #");
        sb.append(casenum);
        sb.append(": ");
        sb.append(trace);
        sb.append(" ");
        sb.append(numRowsWithRepeated);
        sb.append(" ");
        sb.append(numColumnsWithRepeated);
        System.out.println(sb);
    }
    
    
}