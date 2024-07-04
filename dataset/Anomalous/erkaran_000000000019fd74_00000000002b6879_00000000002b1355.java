import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            if (rows == 1 && cols == 1) {
                System.out.println("Case #" + caseNum + ": " + scanner.nextInt());
            } else if (rows == 1 || cols == 1) {
                int size = Math.max(rows, cols);
                handleSingleDimension(scanner, size, caseNum);
            } else {
                int[][] matrix = new int[rows][cols];
                int totalSum = 0;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = scanner.nextInt();
                        totalSum += matrix[i][j];
                    }
                }

                System.out.println("Case #" + caseNum + ": " + totalSum);
            }
        }
    }

    private static void handleSingleDimension(Scanner scanner, int size, int caseNum) {
        int[] array = new int[size];
        int sum = 0;

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        Arrays.sort(array);

        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j++) {
                sum += array[j];
            }
        }

        System.out.println("Case #" + caseNum + ": " + sum);
    }
}