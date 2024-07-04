import java.util.*;

class Solution {
    public static boolean hasDuplicates(final int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int num : array) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int[] temp = new int[N];
            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) trace += matrix[i][j];
                    temp[j] = matrix[i][j];
                }
                if (hasDuplicates(temp)) duplicateRows++;
            }

            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    temp[i] = matrix[i][j];
                }
                if (hasDuplicates(temp)) duplicateCols++;
            }

            System.out.println("Case #" + tc + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}