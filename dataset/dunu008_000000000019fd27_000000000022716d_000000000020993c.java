import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = createScaner();

        int testCases;

        testCases = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= testCases; i++) {
            StringBuilder sb = new StringBuilder();
            int N = in.nextInt();
            in.nextLine();
            for (int a = 0; a < N; a++) {
                sb.append(in.nextLine());
                sb.append(" ");
            }
            int[] numbs = Arrays.stream(sb.toString().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] matrix = new int[N][N];

            int arrLoc = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    matrix[x][y] = numbs[arrLoc];
                    arrLoc++;
                }
            }
            solve(i, N, matrix);
        }


    }

    private static void solve(int testCase, int N, int[][] matrix) {
        int trace = 0;
        int rowsCount = 0;
        int colomnsCount = 0;

        for (int i = 0; i < N; i++) {
            trace += matrix[i][i];
        }

        rowsCount = latinSquareRows(matrix);
        colomnsCount = latinSquareColomns(matrix);

        System.out.println("Case #" + testCase + ": " + trace + " " + rowsCount + " " + colomnsCount);

    }

    public static Scanner createScaner() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return sc;
    }

    public static int latinSquareRows(int[][] array) {
        int rowscount = 0;
        for (int i = 0; i < array.length; i++) {
            if (duplicates(array[i])) {
                rowscount++;
            }
        }
        return rowscount;
    }

    public static int latinSquareColomns(int[][] array) {
        int colomncount = 0;
        for (int i = 0; i < array.length; i++) {

            int[] column = new int[array[i].length];
            for (int j = 0; j < array.length; j++) {
                column[j] = array[j][i];
            }

            if (duplicates(column)) {
                colomncount++;
            }
        }
        return colomncount;
    }

    public static boolean duplicates(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}