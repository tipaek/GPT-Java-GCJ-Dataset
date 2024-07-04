import java.lang.Math;

class LatinMatrixTest {
    static void matrixTest(int n, int[][] matrix) {
        int[] rowCount = new int[n];
        int[] columnCount = new int[n];
        boolean notPrinted = true;
        int repCount = 0;
        boolean rowRep = false;
        boolean columnRep = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!rowRep) {
                    rowCount[matrix[i][j] - 1]++;
                }
                if (!columnRep) {
                    columnCount[matrix[j][i] - 1]++;
                }
                if (rowCount[matrix[i][j] - 1] > 1 || columnCount[matrix[j][i] - 1] > 1) {
                    if (notPrinted) {
                        System.out.println("Not a Natural Latin Matrix.");
                        notPrinted = false;
                    }
                    if (rowCount[matrix[i][j] - 1] > 1) {
                        if (!rowRep) {
                            repCount++;
                        }
                        rowRep = true;
                        j--;
                    }
                    if (columnCount[matrix[j][i] - 1] > 1) {
                        if (!columnRep) {
                            repCount++;
                        }
                        columnRep = true;
                        i--;
                    }
                    if (rowRep && columnRep) {
                        break;
                    }
                }
            }
            rowCount = new int[n];
            columnCount = new int[n];
            rowRep = false;
            columnRep = false;
        }

        if (notPrinted) {
            System.out.println("This is a Natural Latin Matrix.");
        } else {
            System.out.println("There are " + repCount + " repetitions.");
        }
    }

    public static void main(String[] args) {
        int n = 1 + (int) (Math.random() * 100);
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 1 + (int) (Math.random() * n);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        matrixTest(n, matrix);
    }
}