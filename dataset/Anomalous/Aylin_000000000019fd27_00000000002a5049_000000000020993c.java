import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeJam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int repeat = sc.nextInt();

        for (int i = 0; i < repeat; i++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = readMatrix(sc, matrixSize);
            displayMatrix(matrix, matrixSize);
            calculateAndPrintResults(matrix, matrixSize);
        }
    }

    public static int[][] readMatrix(Scanner scanner, int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void calculateAndPrintResults(int[][] matrix, int size) {
        int mainDiagonalSum = calculateMainDiagonalSum(matrix, size);
        int repeatedInRows = countRepeatedInRows(matrix, size);
        int repeatedInColumns = countRepeatedInColumns(matrix, size);
        System.out.println(mainDiagonalSum + " " + repeatedInRows + " " + repeatedInColumns);
    }

    public static int calculateMainDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int countRepeatedInRows(int[][] matrix, int size) {
        int count = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int countRepeatedInColumns(int[][] matrix, int size) {
        int count = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> uniqueElements = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!uniqueElements.add(matrix[row][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void displayMatrix(int[][] matrix, int size) {
        System.out.println("Your Matrix is:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}