import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        Matrix[] matrices = new Matrix[testCases];
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            matrices[i] = new Matrix(n);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrices[i].data[j][k] = scanner.nextInt();
                }
            }
        }

        for (int i = 0; i < testCases; i++) {
            matrices[i].resolve(i + 1);
        }
    }

    public static class Matrix {

        public int[][] data;

        public Matrix(int n) {
            this.data = new int[n][n];
        }

        public void resolve(int x) {
            //check rows
            int rowsWithRepetition = 0;
            for (int i = 0; i < data.length; i++) {
                boolean[] row = new boolean[data.length + 1];
                for (int j = 0; j < data.length; j++) {
                    if (row[data[i][j]]) {
                        rowsWithRepetition++;
                        break;
                    }
                    row[data[i][j]] = true;
                }
            }
            //check columns
            int columnsWithRepetition = 0;
            for (int j = 0; j < data.length; j++) {
                boolean[] column = new boolean[data.length + 1];
                for (int i = 0; i < data.length; i++) {
                    if (column[data[i][j]]) {
                        columnsWithRepetition++;
                        break;
                    }
                    column[data[i][j]] = true;
                }
            }
            //sum diagonal
            int trace = 0;
            for (int i = 0; i < data.length; i++) {
                trace += data[i][i];
            }

            System.out.println("Case #" + x + ": " + trace + " " + rowsWithRepetition + " " + columnsWithRepetition);
        }
    }
}