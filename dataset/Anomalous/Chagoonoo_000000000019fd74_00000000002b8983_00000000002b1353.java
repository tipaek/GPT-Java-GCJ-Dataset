import java.util.Scanner;

public class Solution {
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        matrix = generateMatrix(500);
        int testCases = sc.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int n = sc.nextInt();
            System.out.println("Case #" + (i + 1) + ":");
            
            if (n <= 501) {
                handleCaseForNLessThanEqual501(n);
            } else if (n <= 1000) {
                handleCaseForNLessThanEqual1000(n);
            }
        }
    }

    private static void handleCaseForNLessThanEqual501(int n) {
        System.out.println("1 1");
        System.out.println("2 1");
        int sum = 2;
        int j = 1;

        while (sum < n) {
            System.out.println((j + 1) + " " + (j + 1));
            j++;
            sum++;
        }
    }

    private static void handleCaseForNLessThanEqual1000(int n) {
        int sum = 3;
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("2 2");
        int row = 3;

        while (sum < n) {
            if (sum + matrix[row][row - 2] <= n) {
                sum += matrix[row][row - 2];
                System.out.println((row + 1) + " " + (row - 1));
            } else {
                sum += matrix[row][row - 1];
                System.out.println((row + 1) + " " + row);
            }
            row++;
        }
    }

    private static int[][] generateMatrix(int size) {
        int lastLength = (matrix == null) ? 0 : matrix.length;

        if (size > lastLength) {
            int[][] newMatrix = new int[size][];
            copyMatrix(matrix, newMatrix);

            for (int i = lastLength; i < size; i++) {
                newMatrix[i] = new int[i + 1];
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        newMatrix[i][j] = 1;
                    } else {
                        newMatrix[i][j] = newMatrix[i - 1][j - 1] + newMatrix[i - 1][j];
                    }
                }
            }
            return newMatrix;
        }
        return matrix;
    }

    private static void copyMatrix(int[][] source, int[][] destination) {
        if (source != null) {
            for (int i = 0; i < source.length; i++) {
                System.arraycopy(source[i], 0, destination[i], 0, source[i].length);
            }
        }
    }
}