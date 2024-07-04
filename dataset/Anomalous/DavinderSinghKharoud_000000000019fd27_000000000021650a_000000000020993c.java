import java.util.*;

public class Solution {

    public static List<Integer> solve(int[][] matrix, int len) {
        List<Integer> result = new ArrayList<>();

        int diagonalSum = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;

        // Calculate the sum of the main diagonal
        for (int i = 0; i < len; i++) {
            diagonalSum += matrix[i][i];
        }

        // Check for duplicate elements in each row
        for (int i = 0; i < len; i++) {
            Set<Integer> seenInRow = new HashSet<>();
            for (int j = 0; j < len; j++) {
                if (seenInRow.contains(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
                seenInRow.add(matrix[i][j]);
            }
        }

        // Check for duplicate elements in each column
        for (int i = 0; i < len; i++) {
            Set<Integer> seenInCol = new HashSet<>();
            for (int j = 0; j < len; j++) {
                if (seenInCol.contains(matrix[j][i])) {
                    duplicateCols++;
                    break;
                }
                seenInCol.add(matrix[j][i]);
            }
        }

        result.add(diagonalSum);
        result.add(duplicateRows);
        result.add(duplicateCols);
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caseCount = input.nextInt();
        for (int caseIndex = 1; caseIndex <= caseCount; caseIndex++) {
            int len = input.nextInt();
            int[][] matrix = new int[len][len];

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }

            List<Integer> result = solve(matrix, len);

            System.out.printf("Case #%d: %d %d %d%n", caseIndex, result.get(0), result.get(1), result.get(2));
        }
    }
}