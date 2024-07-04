import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= testcase; test++) {
            String[] S = sc.nextLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            int[][] A = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = j + 1;
                }
            }

            System.out.print("Case #" + test + ": ");

            boolean isPossible = false;

            if (K <= calculateDiagonalSum(A)) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        for (int k = 0; k < j; k++) {
                            A = rotateRow(A, j);
                        }

                        if (isValidConfiguration(A, K)) {
                            isPossible = true;
                            break;
                        }
                    }
                    if (isPossible) break;
                }
            }

            if (isPossible) {
                System.out.println("POSSIBLE");
                for (int[] row : A) {
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
    }

    private static int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static boolean isValidConfiguration(int[][] matrix, int K) {
        int diagonalSum = calculateDiagonalSum(matrix);
        int duplicateRows = countDuplicateRows(matrix);
        int duplicateCols = countDuplicateCols(matrix);

        return diagonalSum == K && duplicateCols == 0;
    }

    private static int countDuplicateCols(int[][] matrix) {
        int count = 0;
        for (int col = 0; col < matrix.length; col++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] row : matrix) {
                map.put(row[col], map.getOrDefault(row[col], 0) + 1);
            }
            if (map.values().stream().anyMatch(val -> val > 1)) {
                count++;
            }
        }
        return count;
    }

    private static int countDuplicateRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int val : row) {
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            if (map.values().stream().anyMatch(val -> val > 1)) {
                count++;
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
                if (k >= n) k -= n;
                if (k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
        return arr;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}