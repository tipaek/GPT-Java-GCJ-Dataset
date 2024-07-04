import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int[][][] matrices = new int[testCases][][];
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            matrices[i] = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrices[i][j][k] = scanner.nextInt();
                }
            }
        }

        for (int i = 0; i < testCases; i++) {
            resolve(matrices[i], i + 1);
        }
    }

    public static void resolve(int[][] matrix, int x) {
        //check rows
        int rowsWithRepetition = 0;
        for (int i = 0; i < matrix.length; i++) {
            boolean[] row = new boolean[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                if (row[matrix[i][j] - 1]) {
                    rowsWithRepetition++;
                    break;
                }
                row[matrix[i][j] - 1] = true;
            }
        }
        //check columns
        int columnsWithRepetition = 0;
        for (int j = 0; j < matrix.length; j++) {
            boolean[] column = new boolean[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                if (column[matrix[i][j] - 1]) {
                    columnsWithRepetition++;
                    break;
                }
                column[matrix[i][j] - 1] = true;
            }
        }
        //sum diagonal
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }

        System.out.println("Case #" + x + ": " + trace + " " + rowsWithRepetition + " " + columnsWithRepetition);
    }
}