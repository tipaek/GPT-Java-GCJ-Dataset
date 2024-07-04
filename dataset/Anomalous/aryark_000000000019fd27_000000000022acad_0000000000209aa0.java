import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] matrix = new int[N][N];
            System.out.print("Case #" + (t + 1) + ": ");

            if (fillMatrix(matrix, N, K)) {
                System.out.println("POSSIBLE");
                printMatrix(matrix, N);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private boolean fillMatrix(int[][] matrix, int N, int K) {
        switch (N) {
            case 2:
                return fillMatrixForN2(matrix, K);
            case 3:
                return fillMatrixForN3(matrix, K);
            case 4:
                return fillMatrixForN4(matrix, K);
            case 5:
                return fillMatrixForN5(matrix, K);
            default:
                return false;
        }
    }

    private boolean fillMatrixForN2(int[][] matrix, int K) {
        if (K == 2) {
            matrix[0] = new int[]{1, 2};
            matrix[1] = new int[]{2, 1};
        } else if (K == 4) {
            matrix[0] = new int[]{2, 1};
            matrix[1] = new int[]{1, 2};
        } else {
            return false;
        }
        return true;
    }

    private boolean fillMatrixForN3(int[][] matrix, int K) {
        switch (K) {
            case 3:
                matrix[0] = new int[]{1, 2, 3};
                matrix[1] = new int[]{3, 1, 2};
                matrix[2] = new int[]{2, 3, 1};
                break;
            case 6:
                matrix[0] = new int[]{2, 1, 3};
                matrix[1] = new int[]{3, 2, 1};
                matrix[2] = new int[]{1, 3, 2};
                break;
            case 9:
                matrix[0] = new int[]{3, 2, 1};
                matrix[1] = new int[]{1, 3, 2};
                matrix[2] = new int[]{2, 1, 3};
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean fillMatrixForN4(int[][] matrix, int K) {
        switch (K) {
            case 4:
                matrix[0] = new int[]{1, 2, 3, 4};
                matrix[1] = new int[]{4, 1, 2, 3};
                matrix[2] = new int[]{3, 4, 1, 2};
                matrix[3] = new int[]{2, 3, 4, 1};
                break;
            case 6:
                matrix[0] = new int[]{1, 4, 2, 3};
                matrix[1] = new int[]{4, 2, 3, 1};
                matrix[2] = new int[]{2, 3, 1, 4};
                matrix[3] = new int[]{3, 1, 4, 2};
                break;
            case 7:
                matrix[0] = new int[]{1, 3, 4, 2};
                matrix[1] = new int[]{2, 1, 3, 4};
                matrix[2] = new int[]{4, 2, 1, 3};
                matrix[3] = new int[]{3, 4, 2, 1};
                break;
            case 8:
                matrix[0] = new int[]{2, 1, 3, 4};
                matrix[1] = new int[]{4, 2, 1, 3};
                matrix[2] = new int[]{3, 4, 2, 1};
                matrix[3] = new int[]{1, 3, 4, 2};
                break;
            case 9:
                matrix[0] = new int[]{1, 3, 4, 2};
                matrix[1] = new int[]{3, 2, 1, 4};
                matrix[2] = new int[]{2, 4, 3, 1};
                matrix[3] = new int[]{4, 1, 2, 3};
                break;
            case 10:
                matrix[0] = new int[]{2, 3, 1, 4};
                matrix[1] = new int[]{3, 2, 4, 1};
                matrix[2] = new int[]{1, 4, 3, 2};
                matrix[3] = new int[]{4, 1, 2, 3};
                break;
            case 11:
                matrix[0] = new int[]{2, 3, 4, 1};
                matrix[1] = new int[]{4, 2, 1, 3};
                matrix[2] = new int[]{1, 4, 3, 2};
                matrix[3] = new int[]{3, 1, 2, 4};
                break;
            case 12:
                matrix[0] = new int[]{3, 2, 1, 4};
                matrix[1] = new int[]{4, 3, 2, 1};
                matrix[2] = new int[]{1, 4, 3, 2};
                matrix[3] = new int[]{2, 1, 4, 3};
                break;
            case 13:
                matrix[0] = new int[]{3, 4, 1, 2};
                matrix[1] = new int[]{4, 2, 3, 1};
                matrix[2] = new int[]{2, 1, 4, 3};
                matrix[3] = new int[]{1, 3, 2, 4};
                break;
            case 14:
                matrix[0] = new int[]{3, 4, 1, 2};
                matrix[1] = new int[]{4, 3, 2, 1};
                matrix[2] = new int[]{1, 2, 4, 3};
                matrix[3] = new int[]{2, 1, 3, 4};
                break;
            case 15:
                return false;
            case 16:
                matrix[0] = new int[]{4, 2, 3, 1};
                matrix[1] = new int[]{1, 4, 2, 3};
                matrix[2] = new int[]{3, 1, 4, 2};
                matrix[3] = new int[]{2, 3, 1, 4};
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean fillMatrixForN5(int[][] matrix, int K) {
        switch (K) {
            case 5:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{5, 1, 2, 3, 4};
                matrix[2] = new int[]{4, 5, 1, 2, 3};
                matrix[3] = new int[]{3, 4, 5, 1, 2};
                matrix[4] = new int[]{2, 3, 4, 5, 1};
                break;
            case 6:
                return false;
            case 7:
                matrix[0] = new int[]{1, 3, 2, 5, 4};
                matrix[1] = new int[]{2, 1, 5, 4, 3};
                matrix[2] = new int[]{4, 2, 1, 3, 5};
                matrix[3] = new int[]{3, 5, 4, 2, 1};
                matrix[4] = new int[]{5, 4, 3, 1, 2};
                break;
            case 8:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{3, 1, 2, 5, 4};
                matrix[2] = new int[]{5, 4, 1, 3, 2};
                matrix[3] = new int[]{4, 3, 5, 2, 1};
                matrix[4] = new int[]{2, 5, 4, 1, 3};
                break;
            case 9:
                matrix[0] = new int[]{1, 2, 4, 3, 5};
                matrix[1] = new int[]{4, 1, 2, 5, 3};
                matrix[2] = new int[]{5, 3, 1, 4, 2};
                matrix[3] = new int[]{3, 4, 5, 2, 1};
                matrix[4] = new int[]{2, 5, 3, 1, 4};
                break;
            case 10:
                matrix[0] = new int[]{1, 2, 5, 4, 3};
                matrix[1] = new int[]{5, 1, 2, 3, 4};
                matrix[2] = new int[]{3, 4, 1, 5, 2};
                matrix[3] = new int[]{4, 5, 3, 2, 1};
                matrix[4] = new int[]{2, 3, 4, 1, 5};
                break;
            case 11:
                matrix[0] = new int[]{1, 3, 5, 4, 2};
                matrix[1] = new int[]{5, 1, 3, 2, 4};
                matrix[2] = new int[]{2, 4, 1, 5, 3};
                matrix[3] = new int[]{4, 5, 2, 3, 1};
                matrix[4] = new int[]{3, 2, 4, 1, 5};
                break;
            case 12:
                matrix[0] = new int[]{1, 4, 5, 3, 2};
                matrix[1] = new int[]{5, 1, 4, 2, 3};
                matrix[2] = new int[]{2, 3, 1, 5, 4};
                matrix[3] = new int[]{3, 5, 2, 4, 1};
                matrix[4] = new int[]{4, 2, 3, 1, 5};
                break;
            case 13:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{2, 5, 4, 1, 3};
                matrix[2] = new int[]{3, 4, 1, 5, 2};
                matrix[3] = new int[]{4, 3, 5, 2, 1};
                matrix[4] = new int[]{5, 1, 2, 3, 4};
                break;
            case 14:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{2, 1, 4, 5, 3};
                matrix[2] = new int[]{3, 4, 5, 2, 1};
                matrix[3] = new int[]{4, 5, 1, 3, 2};
                matrix[4] = new int[]{5, 3, 2, 1, 4};
                break;
            case 15:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{2, 3, 4, 5, 1};
                matrix[2] = new int[]{3, 1, 5, 2, 4};
                matrix[3] = new int[]{4, 5, 1, 3, 2};
                matrix[4] = new int[]{5, 4, 2, 1, 3};
                break;
            case 16:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{2, 4, 5, 1, 3};
                matrix[2] = new int[]{3, 1, 4, 5, 2};
                matrix[3] = new int[]{4, 5, 2, 3, 1};
                matrix[4] = new int[]{5, 3, 1, 2, 4};
                break;
            case 17:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{2, 5, 4, 1, 3};
                matrix[2] = new int[]{3, 1, 5, 2, 4};
                matrix[3] = new int[]{4, 3, 1, 5, 2};
                matrix[4] = new int[]{5, 4, 2, 3, 1};
                break;
            case 18:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{2, 4, 5, 3, 1};
                matrix[2] = new int[]{3, 5, 4, 1, 2};
                matrix[3] = new int[]{4, 1, 2, 5, 3};
                matrix[4] = new int[]{5, 3, 1, 2, 4};
                break;
            case 19:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{2, 5, 1, 3, 4};
                matrix[2] = new int[]{3, 4, 5, 1, 2};
                matrix[3] = new int[]{4, 3, 2, 5, 1};
                matrix[4] = new int[]{5, 1, 4, 2, 3};
                break;
            case 20:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{2, 5, 4, 1, 3};
                matrix[2] = new int[]{3, 4, 5, 2, 1};
                matrix[3] = new int[]{4, 3, 1, 5, 2};
                matrix[4] = new int[]{5, 1, 2, 3, 4};
                break;
            case 21:
                matrix[0] = new int[]{2, 1, 3, 4, 5};
                matrix[1] = new int[]{1, 5, 4, 2, 3};
                matrix[2] = new int[]{3, 4, 5, 1, 2};
                matrix[3] = new int[]{4, 3, 2, 5, 1};
                matrix[4] = new int[]{5, 2, 1, 3, 4};
                break;
            case 22:
                matrix[0] = new int[]{4, 3, 5, 1, 2};
                matrix[1] = new int[]{5, 4, 1, 2, 3};
                matrix[2] = new int[]{2, 5, 5, 3, 1};
                matrix[3] = new int[]{3, 1, 2, 5, 4};
                matrix[4] = new int[]{1, 2, 3, 4, 5};
                break;
            case 23:
                matrix[0] = new int[]{5, 3, 4, 1, 2};
                matrix[1] = new int[]{4, 5, 1, 2, 3};
                matrix[2] = new int[]{2, 4, 5, 3, 1};
                matrix[3] = new int[]{3, 1, 2, 4, 5};
                matrix[4] = new int[]{1, 2, 3, 5, 4};
                break;
            case 24:
                return false;
            case 25:
                matrix[0] = new int[]{5, 1, 2, 3, 4};
                matrix[1] = new int[]{4, 5, 1, 2, 3};
                matrix[2] = new int[]{3, 4, 5, 1, 2};
                matrix[3] = new int[]{2, 3, 4, 5, 1};
                matrix[4] = new int[]{1, 2, 3, 4, 5};
                break;
            default:
                return false;
        }
        return true;
    }

    private void printMatrix(int[][] matrix, int N) {
        for (int i = 0; i < N; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < N; j++) {
                row.append(matrix[i][j]).append(" ");
            }
            System.out.println(row.toString().trim());
        }
    }
}