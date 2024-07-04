import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int test = 1; test <= testCases; test++) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            int[][] matrix = new int[N][N];

            // Initialize the matrix
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = j + 1;
                }
            }

            System.out.print("Case #" + test + ": ");

            boolean isPossible = false;

            if (N != 1 && K <= calculateDiagonalSum(matrix)) {
                for (int i = 0; i < N; i++) {
                    int rotations = 0;
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < rotations; k++) {
                            matrix = rotateRow(matrix, rotations);
                        }

                        if (isValidConfiguration(matrix, K)) {
                            isPossible = true;
                            break;
                        }
                        rotations++;
                    }
                    if (isPossible) {
                        break;
                    }
                }
            }

            if (isPossible) {
                System.out.println("POSSIBLE");
                for (int[] row : matrix) {
                    for (int j = 0; j < N; j++) {
                        if (j == N - 1) {
                            System.out.print(row[j]);
                        } else {
                            System.out.print(row[j] + " ");
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static boolean isValidConfiguration(int[][] matrix, int K) {
        return calculateDiagonalSum(matrix) == K && countDuplicateColumns(matrix) == 0;
    }

    private static int countDuplicateColumns(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            HashMap<Integer, Integer> columnCount = new HashMap<>();
            for (int j = 0; j < matrix.length; j++) {
                columnCount.put(matrix[j][i], columnCount.getOrDefault(matrix[j][i], 0) + 1);
            }
            for (int value : columnCount.values()) {
                if (value > 1) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private static int[][] rotateRow(int[][] matrix, int row) {
        int N = matrix.length;
        int[] rotatedRow = new int[N];
        System.arraycopy(matrix[row], 0, rotatedRow, 0, N);
        rotatedRow = leftRotate(rotatedRow, 1, N);
        System.arraycopy(rotatedRow, 0, matrix[row], 0, N);
        return matrix;
    }

    private static int[] leftRotate(int[] arr, int d, int n) {
        int gcd = gcd(d, n);
        for (int i = 0; i < gcd; i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int k = j + d;
                if (k >= n) {
                    k -= n;
                }
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        return arr;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}