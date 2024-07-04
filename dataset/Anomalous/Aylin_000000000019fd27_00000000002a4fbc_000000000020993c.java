import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CodeJam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            int size = sc.nextInt();
            int[][] matrix = readMatrix(sc, size);
            displayMatrix(matrix, size);
            calculateAndDisplayResults(matrix, size);
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

    private static void displayMatrix(int[][] matrix, int size) {
        System.out.println("Your Matrix is:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void calculateAndDisplayResults(int[][] matrix, int size) {
        int mainDiagonalSum = calculateMainDiagonalSum(matrix, size);
        int repeatedRowSum = calculateRepeatedRowSum(matrix, size);
        int repeatedColumnSum = calculateRepeatedColumnSum(matrix, size);
        
        System.out.println(mainDiagonalSum + "  " + repeatedRowSum + " " + repeatedColumnSum);
    }

    private static int calculateMainDiagonalSum(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int calculateRepeatedRowSum(int[][] matrix, int size) {
        int count = 0;
        for (int row = 0; row < size; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < size; col++) {
                if (!seen.add(matrix[row][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int calculateRepeatedColumnSum(int[][] matrix, int size) {
        int count = 0;
        for (int col = 0; col < size; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < size; row++) {
                if (!seen.add(matrix[row][col])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}