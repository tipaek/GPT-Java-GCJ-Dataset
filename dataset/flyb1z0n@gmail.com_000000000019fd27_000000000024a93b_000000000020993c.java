

import java.util.Scanner;


public class Vestigium {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            int matrixSize = sc.nextInt();
            int[][] arr = new int[matrixSize][matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int[] result = solve(arr);
            System.out.println("Case #" + t + ": " + result[0] + " " + result[1] + " " + result[2]);
        }
    }

    public static int[] solve(int[][] arr) {
        int trace = 0;
        int[][] rows = new int[arr.length][arr.length];
        int[][] cols = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    trace += arr[i][j];
                }
                rows[i][arr[i][j] - 1]++;
                cols[j][arr[i][j] - 1]++;
            }
        }

        int misRows = 0;
        int misCols = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (rows[i][j] > 1) {
                    misRows++;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (cols[i][j] > 1) {
                    misCols++;
                    break;
                }
            }
        }

        return new int[]{trace, misRows, misCols};
    }
}
