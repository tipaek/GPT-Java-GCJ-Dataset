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
            boolean[][] filled = new boolean[N][N];
            boolean possible = false;

            for (int diagonalValue = 1; diagonalValue <= N; diagonalValue++) {
                int sum = 0;
                for (int i = 0; i < N; i++) {
                    matrix[i][i] = diagonalValue;
                    sum += matrix[i][i];
                    filled[i][i] = true;
                }

                if (sum == K) {
                    possible = true;
                    int[] remainingValues = new int[N - 1];
                    int index = 0;

                    for (int value = 1; value <= N; value++) {
                        if (value != diagonalValue) {
                            remainingValues[index++] = value;
                        }
                    }

                    boolean validMatrix = false;
                    for (int row = 0; row < N; row++) {
                        index = 0;
                        for (int col = 0; col < N; col++) {
                            if (!filled[row][col]) {
                                matrix[row][col] = remainingValues[index++];
                                filled[row][col] = true;
                            }
                        }

                        if (isValidMatrix(matrix, N)) {
                            validMatrix = true;
                            break;
                        } else {
                            rotateRight(remainingValues);
                        }
                    }

                    if (validMatrix) {
                        break;
                    }
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                printMatrix(matrix, N);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isValidMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            if (!isUnique(matrix[i])) {
                return false;
            }
        }

        for (int j = 0; j < N; j++) {
            int[] column = new int[N];
            for (int i = 0; i < N; i++) {
                column[i] = matrix[i][j];
            }
            if (!isUnique(column)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isUnique(int[] array) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int value : array) {
            set.add(value);
        }
        return set.size() == array.length;
    }

    private static void rotateRight(int[] array) {
        int lastElement = array[array.length - 1];
        System.arraycopy(array, 0, array, 1, array.length - 1);
        array[0] = lastElement;
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