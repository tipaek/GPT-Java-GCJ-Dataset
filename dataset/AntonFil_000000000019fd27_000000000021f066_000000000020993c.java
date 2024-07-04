import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsCount = sc.nextInt();

        for (int i = 1; i <= testsCount; i++) {
            int[][] mx = readMatrix(sc);
            checkMatrix(i, mx);
        }

        sc.close();
    }

    private static int[][] readMatrix(Scanner sc) {
        sc.nextLine();
        int size = sc.nextInt();
        int [][] mx = new int[size][size];
        for (int i = 0; i < size; i++) {
            sc.nextLine();
            for (int j = 0; j < size; j++) {
                mx[i][j] = sc.nextInt();
            }
        }
        return mx;
    }

    private static void checkMatrix(int testNumber, int[][] mx) {
        int n = mx.length;
        //
        int rowsCount = 0;
        for (int i = 0; i < n; i++) {
            int[] occur = new int[n + 1];
            for (int j = 0; j < n; j++) {
                occur[mx[i][j]]++;
                if (occur[mx[i][j]] > 1) {
                    rowsCount++;
                    break;
                }
            }
        }
        //
        int columnsCount = 0;
        for (int j = 0; j < n; j++) {
            int[] occur = new int[n + 1];
            for (int i = 0; i < n; i++) {
                occur[mx[i][j]]++;
                if (occur[mx[i][j]] > 1) {
                    columnsCount++;
                    break;
                }
            }
        }
        //
        int trace = mx[0][0];
        for (int i = 1; i < n; i++) {
            trace += mx[i][i];
        }
        //
        System.out.println("Case #" + testNumber + ": " + trace + " " + rowsCount + " " + columnsCount);
    }
}
