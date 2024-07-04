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

            boolean isPossible = false;

            for (int rotationCount = 0; rotationCount <= 200; rotationCount++) {
                if (rotationCount > 0) {
                    rotateRight(array);
                }

                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        matrix[row][col] = array[col];
                    }
                    rotateRight(array);
                }

                int diagonalSum = 0;
                for (int i = 0; i < N; i++) {
                    diagonalSum += matrix[i][i];
                }

                if (diagonalSum == K) {
                    if (isValidMatrix(matrix, N)) {
                        System.out.println("Case #" + testCase + ": POSSIBLE");
                        printMatrix(matrix, N);
                        isPossible = true;
                        break;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static void rotateRight(int[] array) {
        int lastElement = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = lastElement;
    }

    private static boolean isValidMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            if (!hasUniqueElements(matrix[i])) {
                return false;
            }
        }

        for (int j = 0; j < N; j++) {
            int[] column = new int[N];
            for (int i = 0; i < N; i++) {
                column[i] = matrix[i][j];
            }
            if (!hasUniqueElements(column)) {
                return false;
            }
        }

        return true;
    }

    private static boolean hasUniqueElements(int[] array) {
        TreeSet<Integer> uniqueElements = new TreeSet<>();
        for (int value : array) {
            uniqueElements.add(value);
        }
        return uniqueElements.size() == array.length;
    }

    private static void printMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}