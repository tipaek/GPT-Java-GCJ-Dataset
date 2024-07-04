import java.io.*;
import java.util.Scanner;

public class Solution {
    private static int matrixDimension;
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(scanner.next());
        
        for (int i = 0; i < testCount; i++) {
            if (i == 0) {
                scanner.nextLine();
            }
            matrixDimension = Integer.parseInt(scanner.next());
            scanner.nextLine();
            matrix = new int[matrixDimension][matrixDimension];
            
            for (int row = 0; row < matrixDimension; row++) {
                for (int col = 0; col < matrixDimension; col++) {
                    matrix[row][col] = Integer.parseInt(scanner.next());
                }
            }
            
            int trace = calculateTrace(matrix);
            int rowRepeats = countRowRepeats(matrix);
            int colRepeats = countColRepeats(matrix);
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowRepeats(int[][] matrix) {
        int repeats = 0;
        for (int row = 0; row < matrix.length; row++) {
            boolean[] seen = new boolean[matrix.length + 1];
            for (int col = 0; col < matrix.length; col++) {
                if (seen[matrix[row][col]]) {
                    repeats++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return repeats;
    }

    private static int countColRepeats(int[][] matrix) {
        int repeats = 0;
        for (int col = 0; col < matrix.length; col++) {
            boolean[] seen = new boolean[matrix.length + 1];
            for (int row = 0; row < matrix.length; row++) {
                if (seen[matrix[row][col]]) {
                    repeats++;
                    break;
                }
                seen[matrix[row][col]] = true;
            }
        }
        return repeats;
    }
}