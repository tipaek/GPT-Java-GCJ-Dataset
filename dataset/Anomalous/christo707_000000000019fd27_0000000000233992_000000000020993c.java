import java.util.Scanner;

class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int[] colSumArr = new int[n];
            int trace = 0, rows = 0, columns = 0;
            int expectedSum = n * (n + 1) / 2;

            for (int i = 0; i < n; i++) {
                int rowSum = 0;
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    rowSum += matrix[i][j];
                    colSumArr[j] += matrix[i][j];
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    if (rowCheck[matrix[i][j]]) {
                        rows++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
                if (rowSum != expectedSum) {
                    rows++;
                }
            }

            for (int j = 0; j < n; j++) {
                int colSum = 0;
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    colSum += matrix[i][j];
                    if (colCheck[matrix[i][j]]) {
                        columns++;
                        break;
                    }
                    colCheck[matrix[i][j]] = true;
                }
                if (colSum != expectedSum) {
                    columns++;
                }
            }

            System.out.println(trace + " " + rows + " " + columns);
        }

        scanner.close();
    }
}