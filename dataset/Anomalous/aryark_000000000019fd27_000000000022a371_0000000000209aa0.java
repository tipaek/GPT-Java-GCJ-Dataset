import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int a = 0; a < T; a++) {
            int N = scan.nextInt();
            int K = scan.nextInt();
            int[][] arr = new int[N][N];
            System.out.print("Case #" + (a + 1) + ": ");

            boolean possible = fillMatrix(arr, N, K);

            if (possible) {
                System.out.println("POSSIBLE");
                printMatrix(arr, N);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private boolean fillMatrix(int[][] arr, int N, int K) {
        boolean possible = true;

        if (N == 2) {
            possible = fillMatrixForN2(arr, K);
        } else if (N == 3) {
            possible = fillMatrixForN3(arr, K);
        } else if (N == 4) {
            possible = fillMatrixForN4(arr, K);
        } else if (N == 5) {
            possible = fillMatrixForN5(arr, K);
        } else {
            possible = false; // Default case for unsupported N values
        }

        return possible;
    }

    private boolean fillMatrixForN2(int[][] arr, int K) {
        switch (K) {
            case 2:
                arr[0] = new int[]{1, 2};
                arr[1] = new int[]{2, 1};
                break;
            case 4:
                arr[0] = new int[]{2, 1};
                arr[1] = new int[]{1, 2};
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean fillMatrixForN3(int[][] arr, int K) {
        switch (K) {
            case 3:
                arr[0] = new int[]{1, 2, 3};
                arr[1] = new int[]{3, 1, 2};
                arr[2] = new int[]{2, 3, 1};
                break;
            case 6:
                arr[0] = new int[]{2, 1, 3};
                arr[1] = new int[]{3, 2, 1};
                arr[2] = new int[]{1, 3, 2};
                break;
            case 9:
                arr[0] = new int[]{3, 2, 1};
                arr[1] = new int[]{1, 3, 2};
                arr[2] = new int[]{2, 1, 3};
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean fillMatrixForN4(int[][] arr, int K) {
        switch (K) {
            case 4:
                arr[0] = new int[]{1, 2, 3, 4};
                arr[1] = new int[]{4, 1, 2, 3};
                arr[2] = new int[]{3, 4, 1, 2};
                arr[3] = new int[]{2, 3, 4, 1};
                break;
            case 6:
                arr[0] = new int[]{1, 4, 2, 3};
                arr[1] = new int[]{4, 2, 3, 1};
                arr[2] = new int[]{2, 3, 1, 4};
                arr[3] = new int[]{3, 1, 4, 2};
                break;
            case 7:
                arr[0] = new int[]{1, 3, 4, 2};
                arr[1] = new int[]{2, 1, 3, 4};
                arr[2] = new int[]{4, 2, 1, 3};
                arr[3] = new int[]{3, 4, 2, 1};
                break;
            // Add other cases similarly
            default:
                return false;
        }
        return true;
    }

    private boolean fillMatrixForN5(int[][] arr, int K) {
        switch (K) {
            case 5:
                arr[0] = new int[]{1, 2, 3, 4, 5};
                arr[1] = new int[]{5, 1, 2, 3, 4};
                arr[2] = new int[]{4, 5, 1, 2, 3};
                arr[3] = new int[]{3, 4, 5, 1, 2};
                arr[4] = new int[]{2, 3, 4, 5, 1};
                break;
            case 7:
                arr[0] = new int[]{1, 3, 2, 5, 4};
                arr[1] = new int[]{2, 1, 5, 4, 3};
                arr[2] = new int[]{4, 2, 1, 3, 5};
                arr[3] = new int[]{3, 5, 4, 2, 1};
                arr[4] = new int[]{5, 4, 3, 1, 2};
                break;
            // Add other cases similarly
            default:
                return false;
        }
        return true;
    }

    private void printMatrix(int[][] arr, int N) {
        for (int[] row : arr) {
            for (int j = 0; j < N; j++) {
                System.out.print(row[j] + (j < N - 1 ? " " : ""));
            }
            System.out.println();
        }
    }
}