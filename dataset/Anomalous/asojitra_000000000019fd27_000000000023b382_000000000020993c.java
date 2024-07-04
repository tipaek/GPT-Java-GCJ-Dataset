import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            
            populateMatrix(scanner, matrix);
            int trace = calculateTrace(matrix);
            int[] repeats = countRowColumnRepeats(matrix);
            
            System.out.printf("Case #%d: %d %d %d%n", t + 1, trace, repeats[0], repeats[1]);
        }
    }

    private static void populateMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int[] countRowColumnRepeats(int[][] matrix) {
        int rowRepeats = 0;
        int columnRepeats = 0;

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> columnSet = new HashSet<>();
            
            boolean rowFlag = false;
            boolean columnFlag = false;
            
            for (int j = 0; j < matrix[i].length; j++) {
                if (!rowSet.add(matrix[i][j]) && !rowFlag) {
                    rowRepeats++;
                    rowFlag = true;
                }
                if (!columnSet.add(matrix[j][i]) && !columnFlag) {
                    columnRepeats++;
                    columnFlag = true;
                }
            }
        }

        return new int[]{rowRepeats, columnRepeats};
    }
}