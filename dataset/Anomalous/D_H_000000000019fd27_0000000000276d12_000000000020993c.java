import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numTestCases = scanner.nextInt();
            for (int i = 1; i <= numTestCases; i++) {
                int N = scanner.nextInt();
                int[][] matrix = new int[N][N];
                for (int row = 0; row < N; row++) {
                    for (int column = 0; column < N; column++) {
                        matrix[row][column] = scanner.nextInt();
                    }
                }
                
                int trace = calculateTrace(matrix, N);
                int repeatedRow = countRepeatedRows(matrix, N);
                int repeatedColumn = countRepeatedColumns(matrix, N);
                
                System.out.println("Case #" + i + ": " + trace + " " + repeatedRow + " " + repeatedColumn);
            }
        }
    }

    private static int calculateTrace(int[][] matrix, int N) {
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRepeatedRows(int[][] matrix, int N) {
        int repeatedRow = 0;
        for (int row = 0; row < N; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < N; col++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < N) {
                repeatedRow++;
            }
        }
        return repeatedRow;
    }

    private static int countRepeatedColumns(int[][] matrix, int N) {
        int repeatedColumn = 0;
        for (int col = 0; col < N; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < N; row++) {
                uniqueElements.add(matrix[row][col]);
            }
            if (uniqueElements.size() < N) {
                repeatedColumn++;
            }
        }
        return repeatedColumn;
    }
}