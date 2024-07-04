import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int matrix[][] = new int[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = in.nextInt();
                }
            }
            int[] values = solution(n, matrix);
            System.out.println("Case #" + i + ": " + values[0] + " " + values[1] + " " + values[2]);
        }
    }
    
    public static int[] solution(int n, int[][] matrix) {
        
        int[] answers = new int[3];
        int trace = 0;
        int row_duplicate = 0;
        int col_duplicate = 0;
        int element = 0;
        
        for (int row = 0; row < n; row++) {
            Set<Integer> duplicates_row = new HashSet<Integer>();
            for (int col = 0; col < n; col++) {
                element = matrix[row][col];
                if (row == col) {
                    trace += element;
                }
                duplicates_row.add(element);
            }
            if (duplicates_row.size() < n) {row_duplicate++;}
        }
        
        for (int col = 0; col < n; col++) {
            Set<Integer> duplicates_col = new HashSet<Integer>();
            for (int row = 0; row < n; row++) {
                duplicates_col.add(matrix[row][col]);
            }
            if (duplicates_col.size() < n) {col_duplicate++;}
        }
        
        answers[0] = trace;
        answers[1] = row_duplicate;
        answers[2] = col_duplicate;
        
        return answers;
    }
}