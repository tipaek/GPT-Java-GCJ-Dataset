import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int diagonalSum = 0;
            int duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                diagonalSum += arr[i][i];
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicates(arr[i])) {
                    duplicateRows++;
                }
            }

            for (int i = 0; i < n; i++) {
                if (hasDuplicatesInColumn(arr, i)) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        for (int value : array) {
            if (!seen.add(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDuplicatesInColumn(int[][] matrix, int col) {
        Set<Integer> seen = new HashSet<>();
        for (int[] row : matrix) {
            if (!seen.add(row[col])) {
                return true;
            }
        }
        return false;
    }
}