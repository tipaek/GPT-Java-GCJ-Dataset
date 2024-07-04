import java.util.Scanner;

class LatinMatrixTest {
    static void checkMatrix(int n, int[][] matrix) {
        int[] rowCount = new int[n];
        int[] columnCount = new int[n];
        boolean notPrinted = true;
        int repetitionCount = 0;
        boolean rowRepetition = false;
        boolean columnRepetition = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!rowRepetition) {
                    rowCount[matrix[i][j] - 1]++;
                }
                if (!columnRepetition) {
                    columnCount[matrix[j][i] - 1]++;
                }

                if (rowCount[matrix[i][j] - 1] > 1 || columnCount[matrix[j][i] - 1] > 1) {
                    if (notPrinted) {
                        System.out.println("Not a Natural Latin Matrix.");
                        notPrinted = false;
                    }
                    if (rowCount[matrix[i][j] - 1] > 1) {
                        if (!rowRepetition) {
                            repetitionCount++;
                        }
                        rowRepetition = true;
                    }
                    if (columnCount[matrix[j][i] - 1] > 1) {
                        if (!columnRepetition) {
                            repetitionCount++;
                        }
                        columnRepetition = true;
                    }
                }
            }
            rowCount = new int[n];
            columnCount = new int[n];
            rowRepetition = false;
            columnRepetition = false;
        }

        if (notPrinted) {
            System.out.println("This is a Natural Latin Matrix.");
        } else {
            System.out.println("There are " + repetitionCount + " repetitions.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the sides for the matrix: ");
        int n = sc.nextInt();
        System.out.println();

        System.out.println("Enter numbers for the matrix:");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        checkMatrix(n, matrix);
        sc.close();
    }
}