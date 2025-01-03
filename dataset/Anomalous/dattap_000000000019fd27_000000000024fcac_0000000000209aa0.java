import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);

            int[][] matrix = new int[N][N];
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = i + 1;
            }

            boolean possible = false;
            for (int rotations = 0; rotations <= 200; rotations++) {
                if (rotations > 0) {
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
                        System.out.println("Case #" + caseNumber + ": POSSIBLE");
                        printMatrix(matrix, N);
                        possible = true;
                        break;
                    }
                }
            }

            if (!possible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
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

    private static void printMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}