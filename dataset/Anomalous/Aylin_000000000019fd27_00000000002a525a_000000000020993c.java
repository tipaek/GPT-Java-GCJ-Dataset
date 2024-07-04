import java.util.Scanner;

public class CodeJam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        for (int i = 0; i < repeat; i++) {
            int size = sc.nextInt();
            int[][] matrix = readMatrix(sc, size);
            printMatrix(matrix);
            printMatrixDetails(matrix);
        }
    }

    private static int[][] readMatrix(Scanner sc, int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Your Matrix is:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    private static void printMatrixDetails(int[][] matrix) {
        int size = matrix.length;
        int mainDiagonalSum = calculateMainDiagonalSum(matrix);
        int rowRepeats = countRepeatedInRows(matrix);
        int columnRepeats = countRepeatedInColumns(matrix);
        System.out.println(mainDiagonalSum + "  " + rowRepeats + " " + columnRepeats);
    }

    private static int calculateMainDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRepeatedInRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            count += countRepeatedElements(row);
        }
        return count;
    }

    private static int countRepeatedInColumns(int[][] matrix) {
        int count = 0;
        int size = matrix.length;
        for (int col = 0; col < size; col++) {
            int[] column = new int[size];
            for (int row = 0; row < size; row++) {
                column[row] = matrix[row][col];
            }
            count += countRepeatedElements(column);
        }
        return count;
    }

    private static int countRepeatedElements(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}