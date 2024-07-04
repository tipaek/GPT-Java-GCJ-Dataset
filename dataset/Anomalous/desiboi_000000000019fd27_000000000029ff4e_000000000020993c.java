import java.util.Scanner;

class LatinMatrixTest {
    static void matrixTest(int n, int[][] matrix) {
        int[] rowCount = new int[n];
        int[] columnCount = new int[n];
        boolean notPrinted = true;
        int repetitionCount = 0;
        boolean rowRepeated = false;
        boolean columnRepeated = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!rowRepeated) {
                    rowCount[matrix[i][j] - 1]++;
                }
                if (!columnRepeated) {
                    columnCount[matrix[j][i] - 1]++;
                }
                if (rowCount[matrix[i][j] - 1] > 1 || columnCount[matrix[j][i] - 1] > 1) {
                    if (notPrinted) {
                        System.out.println("Not a Natural Latin Matrix.");
                        notPrinted = false;
                    }
                    if (rowCount[matrix[i][j] - 1] > 1) {
                        if (!rowRepeated) {
                            repetitionCount++;
                        }
                        rowRepeated = true;
                        j--;
                    }
                    if (columnCount[matrix[j][i] - 1] > 1) {
                        if (!columnRepeated) {
                            repetitionCount++;
                        }
                        columnRepeated = true;
                        i--;
                    }
                    if (rowRepeated && columnRepeated) {
                        break;
                    }
                }
            }
            rowCount = new int[n];
            columnCount = new int[n];
            rowRepeated = false;
            columnRepeated = false;
        }

        if (notPrinted) {
            System.out.println("This is a Natural Latin Matrix.");
        } else {
            System.out.println("There are " + repetitionCount + " repetitions.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the sides for the matrix: ");
        int n = scanner.nextInt();
        System.out.println();

        System.out.println("Enter numbers for the matrix:");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        matrixTest(n, matrix);
    }
}