import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            int[][] matrix = new int[N][N];
            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                array[i] = i + 1;
            }

            boolean found = false;
            int attempts = 0;

            while (attempts++ <= 1200 && !found) {
                if (attempts > 1) {
                    rotateRight(array);
                }

                for (int row = 0; row < N; row++) {
                    System.arraycopy(array, 0, matrix[row], 0, N);
                    rotateRight(array);
                }

                int diagonalSum = 0;
                for (int i = 0; i < N; i++) {
                    diagonalSum += matrix[i][i];
                }

                if (diagonalSum == K && isValidLatinSquare(matrix, N)) {
                    found = true;
                    System.out.println("Case #" + testCase + ": POSSIBLE");
                    printMatrix(matrix);
                }
            }

            if (!found) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static void rotateRight(int[] array) {
        int lastElement = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = lastElement;
    }

    private static boolean isValidLatinSquare(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            TreeSet<Integer> rowSet = new TreeSet<>();
            TreeSet<Integer> colSet = new TreeSet<>();
            for (int j = 0; j < N; j++) {
                rowSet.add(matrix[i][j]);
                colSet.add(matrix[j][i]);
            }
            if (rowSet.size() != N || colSet.size() != N) {
                return false;
            }
        }
        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}