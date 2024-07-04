import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %d %d %d";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processCase(int caseNum, Scanner scanner) {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < n; j++) {
                if (!rowSet.add(matrix[i][j])) {
                    rowDuplicates++;
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (!colSet.add(matrix[j][i])) {
                    colDuplicates++;
                    break;
                }
            }
        }

        System.out.printf(OUTPUT_FORMAT, caseNum, trace, rowDuplicates, colDuplicates);
        System.out.println();
    }
}