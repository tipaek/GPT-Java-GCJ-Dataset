import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            System.out.println("Case #" + i + ": " + processMatrix());
        }
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static String processMatrix() {
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];
        int repeatedRows = 0;
        int repeatedCols = 0;
        
        Set<Integer>[] rowSets = new HashSet[size];
        Set<Integer>[] colSets = new HashSet[size];

        for (int i = 0; i < size; i++) {
            rowSets[i] = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (i == 0) {
                    colSets[j] = new HashSet<>();
                }
                matrix[i][j] = scanner.nextInt();
                int value = matrix[i][j];
                
                rowSets[i].add(value);
                colSets[j].add(value);

                if (i == size - 1 && colSets[j].size() < size) {
                    repeatedCols++;
                }
            }
            if (rowSets[i].size() < size) {
                repeatedRows++;
            }
        }

        int trace = calculateTrace(matrix, size);
        return trace + " " + repeatedRows + " " + repeatedCols;
    }
}