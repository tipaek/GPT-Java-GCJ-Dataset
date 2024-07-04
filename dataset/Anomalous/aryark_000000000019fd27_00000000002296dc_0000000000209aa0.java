import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[][] matrix = new int[N][N];
            boolean isPossible = true;

            System.out.print("Case #" + (t + 1) + ": ");

            switch (N) {
                case 2:
                    isPossible = handleCaseForN2(K, matrix);
                    break;
                case 3:
                    isPossible = handleCaseForN3(K, matrix);
                    break;
                case 4:
                    isPossible = handleCaseForN4(K, matrix);
                    break;
                case 5:
                    isPossible = handleCaseForN5(K, matrix);
                    break;
                default:
                    isPossible = false;
            }

            if (isPossible) {
                System.out.println("POSSIBLE");
                printMatrix(matrix);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private boolean handleCaseForN2(int K, int[][] matrix) {
        if (K == 2) {
            matrix[0] = new int[]{1, 2};
            matrix[1] = new int[]{2, 1};
        } else if (K == 3) {
            return false;
        } else {
            matrix[0] = new int[]{2, 1};
            matrix[1] = new int[]{1, 2};
        }
        return true;
    }

    private boolean handleCaseForN3(int K, int[][] matrix) {
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

    private boolean handleCaseForN4(int K, int[][] matrix) {
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
            case 14:
                matrix[0] = new int[]{3, 4, 1, 2};
                matrix[1] = new int[]{4, 3, 2, 1};
                matrix[2] = new int[]{1, 2, 4, 3};
                matrix[3] = new int[]{2, 1, 3, 4};
                break;
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

    private boolean handleCaseForN5(int K, int[][] matrix) {
        switch (K) {
            case 5:
                matrix[0] = new int[]{1, 2, 3, 4, 5};
                matrix[1] = new int[]{5, 1, 2, 3, 4};
                matrix[2] = new int[]{4, 5, 1, 2, 3};
                matrix[3] = new int[]{3, 4, 5, 1, 2};
                matrix[4] = new int[]{2, 3, 4, 5, 1};
                break;
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
            case 22:
                matrix[0] = new int[]{4, 3, 5, 1, 2};
                matrix[1] = new int[]{5, 4, 1, 2, 3};
                matrix[2] = new int[]{2, 5, 3, 4, 1};
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

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + (i < row.length - 1 ? " " : ""));
            }
            System.out.println();
        }
    }
}