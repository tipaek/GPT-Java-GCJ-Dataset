import java.util.Scanner;

class CodeJam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int size = sc.nextInt();
            int[][] matrix = readMatrix(sc, size);
            displayMatrix(matrix, size);
            calculateAndPrintResults(matrix, size);
        }
        sc.close();
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

    private static void calculateAndPrintResults(int[][] matrix, int size) {
        int mainDiagonalSum = calculateMainDiagonalSum(matrix, size);
        int repeatedInRows = countRepeatedInRows(matrix, size);
        int repeatedInColumns = countRepeatedInColumns(matrix, size);
        System.out.println(mainDiagonalSum + " " + repeatedInRows + " " + repeatedInColumns);
    }

    private static int calculateMainDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int countRepeatedInRows(int[][] matrix, int size) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            boolean[] seen = new boolean[size + 1];
            for (int j = 0; j < size; j++) {
                if (seen[matrix[i][j]]) {
                    count++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return count;
    }

    private static int countRepeatedInColumns(int[][] matrix, int size) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            boolean[] seen = new boolean[size + 1];
            for (int i = 0; i < size; i++) {
                if (seen[matrix[i][j]]) {
                    count++;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }
        return count;
    }

    private static void displayMatrix(int[][] matrix, int size) {
        System.out.println("Your Matrix is:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}