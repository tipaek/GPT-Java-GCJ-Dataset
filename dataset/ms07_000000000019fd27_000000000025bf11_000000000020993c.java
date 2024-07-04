import java.util.Scanner;

public class Solution
{
    static class Result
    {
        int trace;

        int duplicateRows;

        int duplicateColumns;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int T = 0;
        int n = 0;
        int i;
        int j;

        T = sc.nextInt();
        int cases = 0;

        for (cases = 1; cases <= T; cases++) {
            n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            Solution.Result result = new Solution.Result();
            latinSquare(arr, n, result);
            trace(arr, n, result);
            System.out
                    .println("Case #" + cases + ": " + result.trace + " " + result.duplicateRows + " "
                            + result.duplicateColumns);
        }
    }

    public static void latinSquare(int[][] arr, int n, Result result)
    {
        for (int i = 0; i < n; i++) {

            if (checkDuplicates(arr[i])) {
                result.duplicateRows += 1;
            }

            int[] column = new int[n];
            for (int j = 0; j < n; j++) {
                column[j] = arr[j][i];
            }

            if (checkDuplicates(column)) {
                result.duplicateColumns += 1;
            }
        }
    }

    private static boolean checkDuplicates(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void trace(int[][] arr, int n, Result result)
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    result.trace += arr[i][j];
                }
            }
        }
    }
}
