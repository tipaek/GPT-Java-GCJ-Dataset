import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++) {
            int size = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] inputArray = new String[size];
            for (int j = 0; j < size; j++) {
                inputArray[j] = scanner.nextLine();
            }
            int[][] matrix = createMatrix(inputArray);
            printSolution(i + 1, matrix); // Adjusting test case number to start from 1
        }
        scanner.close();
    }

    public static void printSolution(int testcase, int[][] matrix) {
        int diag = calculateDiagonal(matrix);
        int rows = countDuplicateRows(matrix);
        int columns = countDuplicateColumns(matrix);
        System.out.printf("Case #%d: %d %d %d\n", testcase, diag, rows, columns);
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!set.add(matrix[j][i])) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (!set.add(matrix[i][j])) {
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public static int[][] createMatrix(String[] input) {
        int size = input.length;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] temp = input[i].split(" ");
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return matrix;
    }

    public static int calculateDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}