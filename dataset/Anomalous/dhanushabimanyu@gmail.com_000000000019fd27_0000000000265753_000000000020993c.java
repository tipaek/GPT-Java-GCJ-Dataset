import java.util.Scanner;

public class Solution {

    static int[][] arr;

    public static int findRowDiff(int row, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[row][i] == arr[row][j]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int findColDiff(int col, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i][col] == arr[j][col]) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int trace = 0, rowDuplicates = 0, colDuplicates = 0;
            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
                rowDuplicates += findRowDiff(i, n);
                colDuplicates += findColDiff(i, n);
            }

            System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }
}