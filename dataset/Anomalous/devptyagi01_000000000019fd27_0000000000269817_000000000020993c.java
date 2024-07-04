import java.util.Scanner;

public class Solution {

    static boolean hasDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                if (hasDuplicate(matrix[i])) {
                    duplicateRows++;
                }

                int[] column = new int[size];
                for (int j = 0; j < size; j++) {
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    column[j] = matrix[j][i];
                }

                if (hasDuplicate(column)) {
                    duplicateCols++;
                }
            }

            System.out.println(trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }
}