import java.util.Scanner;
public class Solution {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        for (int testCase = 1; testCase <= n; ++testCase) {
            int number = scanner.nextInt();
            printResult(testCase, solve(number));
        }
    }

    private static String solve(int N) {
        int [][] rows = new int[N][N];
        int [][] columns = new int[N][N];
        int trace = 0;
        int repeatingRows = 0;
        int repeatingCols = 0;
        for (int row = 0; row < N; ++row) {
            for (int col = 0; col < N; ++col) {
                int value = scanner.nextInt();
                if (row == col) {
                    trace += value;
                }

                int index = value - 1;
                rows[row][index]++;
                columns[col][index]++;
            }
        }

        for (int row = 0; row < N; ++row) {
            for (int index = 0; index < N; ++index) {
                if (rows[row][index] > 1) {
                    repeatingRows++;
                    break;
                }
            }
        }

        for (int col = 0; col < N; ++col) {
            for (int index = 0; index < N; ++index) {
                if (columns[col][index] > 1) {
                    repeatingCols++;
                    break;
                }
            }
        }

        return trace + " " + repeatingRows + " " + repeatingCols;
    }

    private static void printResult(int testCase, String result) {
        System.out.println("Case #" + testCase + ": " + result);
    }
}