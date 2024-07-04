import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numTestCases = sc.nextInt();

        for (int testCase = 0; testCase < numTestCases; testCase++) {
            int N = sc.nextInt();
            int duplicateRows = 0;
            int duplicateColumns = 0;
            int trace = 0;
            int[][] arr = new int[N][N];
            for (int row = 0; row < N; row++) {
                int[] rowIdentifiers = new int[N];
                for (int column = 0; column < N; column++) {
                    arr[row][column] = sc.nextInt();
                    if (row == column) {
                        trace += arr[row][column];
                    }
                    rowIdentifiers[arr[row][column] - 1]++;
                }
                for (int i = 0; i < N; i++) {
                    if (rowIdentifiers[i] != 1) {
                        duplicateRows++;
                        break;
                    }
                }
            }
            for (int column = 0; column < N; column++) {
                int[] columnIdentifiers = new int[N];
                for (int row = 0; row < N; row++) {
                    columnIdentifiers[arr[row][column] - 1]++;
                }
                for (int i = 0; i < N; i++) {
                    if (columnIdentifiers[i] != 1) {
                        duplicateColumns++;
                        break;
                    }
                }
            }
            System.out.println(String.format("Case #%s: %s %s %s", testCase + 1, trace, duplicateRows, duplicateColumns));
        }
    }
}
