import java.util.Scanner;

public class Solution {
    public static String solve(int[][] matrix) {
        int trace = 0;
        int size = matrix.length;
        int rowRepeats = 0;
        int colRepeats = 0;
        
        for (int i = 0; i < size; i++) {
            boolean[] rowCheck = new boolean[size + 1];
            boolean[] colCheck = new boolean[size + 1];
            boolean rowHasRepeat = false;
            boolean colHasRepeat = false;
            
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                if (rowCheck[matrix[i][j]]) {
                    rowHasRepeat = true;
                }
                if (colCheck[matrix[j][i]]) {
                    colHasRepeat = true;
                }
                rowCheck[matrix[i][j]] = true;
                colCheck[matrix[j][i]] = true;
            }
            
            if (rowHasRepeat) rowRepeats++;
            if (colHasRepeat) colRepeats++;
        }
        
        return trace + " " + rowRepeats + " " + colRepeats;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            System.out.println("Case #" + testCase + ": " + solve(matrix));
        }
    }
}