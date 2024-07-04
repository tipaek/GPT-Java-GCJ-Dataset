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
            boolean possible = fillArray(N, K, arr);
            if (possible) {
                System.out.println("POSSIBLE");
                printArray(arr);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private boolean fillArray(int N, int K, int[][] arr) {
        if (N == 2) {
            if (K == 2) {
                arr[0] = new int[]{1, 2};
                arr[1] = new int[]{2, 1};
            } else if (K == 4) {
                arr[0] = new int[]{2, 1};
                arr[1] = new int[]{1, 2};
            } else {
                return false;
            }
        } else if (N == 3) {
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
        } else if (N == 4) {
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
                case 8:
                    arr[0] = new int[]{2, 1, 3, 4};
                    arr[1] = new int[]{4, 2, 1, 3};
                    arr[2] = new int[]{3, 4, 2, 1};
                    arr[3] = new int[]{1, 3, 4, 2};
                    break;
                case 10:
                    arr[0] = new int[]{2, 3, 1, 4};
                    arr[1] = new int[]{3, 2, 4, 1};
                    arr[2] = new int[]{1, 4, 3, 2};
                    arr[3] = new int[]{4, 1, 2, 3};
                    break;
                case 11:
                    arr[0] = new int[]{2, 3, 4, 1};
                    arr[1] = new int[]{4, 2, 1, 3};
                    arr[2] = new int[]{1, 4, 3, 2};
                    arr[3] = new int[]{3, 1, 2, 4};
                    break;
                case 12:
                    arr[0] = new int[]{3, 2, 1, 4};
                    arr[1] = new int[]{4, 3, 2, 1};
                    arr[2] = new int[]{1, 4, 3, 2};
                    arr[3] = new int[]{2, 1, 4, 3};
                    break;
                case 14:
                    arr[0] = new int[]{3, 4, 1, 2};
                    arr[1] = new int[]{4, 3, 2, 1};
                    arr[2] = new int[]{1, 2, 4, 3};
                    arr[3] = new int[]{2, 1, 3, 4};
                    break;
                case 16:
                    arr[0] = new int[]{4, 2, 3, 1};
                    arr[1] = new int[]{1, 4, 2, 3};
                    arr[2] = new int[]{3, 1, 4, 2};
                    arr[3] = new int[]{2, 3, 1, 4};
                    break;
                default:
                    return false;
            }
        } else if (N == 5) {
            switch (K) {
                case 5:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{5, 1, 2, 3, 4};
                    arr[2] = new int[]{4, 5, 1, 2, 3};
                    arr[3] = new int[]{3, 4, 5, 1, 2};
                    arr[4] = new int[]{2, 3, 4, 5, 1};
                    break;
                case 8:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{3, 1, 2, 5, 4};
                    arr[2] = new int[]{5, 4, 1, 3, 2};
                    arr[3] = new int[]{4, 3, 5, 2, 1};
                    arr[4] = new int[]{2, 5, 4, 1, 3};
                    break;
                case 9:
                    arr[0] = new int[]{1, 2, 4, 3, 5};
                    arr[1] = new int[]{4, 1, 2, 5, 3};
                    arr[2] = new int[]{5, 3, 1, 4, 2};
                    arr[3] = new int[]{3, 4, 5, 2, 1};
                    arr[4] = new int[]{2, 5, 3, 1, 4};
                    break;
                case 10:
                    arr[0] = new int[]{1, 2, 5, 4, 3};
                    arr[1] = new int[]{5, 1, 2, 3, 4};
                    arr[2] = new int[]{3, 4, 1, 5, 2};
                    arr[3] = new int[]{4, 5, 3, 2, 1};
                    arr[4] = new int[]{2, 3, 4, 1, 5};
                    break;
                case 11:
                    arr[0] = new int[]{1, 3, 5, 4, 2};
                    arr[1] = new int[]{5, 1, 3, 2, 4};
                    arr[2] = new int[]{2, 4, 1, 5, 3};
                    arr[3] = new int[]{4, 5, 2, 3, 1};
                    arr[4] = new int[]{3, 2, 4, 1, 5};
                    break;
                case 12:
                    arr[0] = new int[]{1, 4, 5, 3, 2};
                    arr[1] = new int[]{5, 1, 4, 2, 3};
                    arr[2] = new int[]{2, 3, 1, 5, 4};
                    arr[3] = new int[]{3, 5, 2, 4, 1};
                    arr[4] = new int[]{4, 2, 3, 1, 5};
                    break;
                case 13:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{2, 5, 4, 1, 3};
                    arr[2] = new int[]{3, 4, 1, 5, 2};
                    arr[3] = new int[]{4, 3, 5, 2, 1};
                    arr[4] = new int[]{5, 1, 2, 3, 4};
                    break;
                case 14:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{2, 1, 4, 5, 3};
                    arr[2] = new int[]{3, 4, 5, 2, 1};
                    arr[3] = new int[]{4, 5, 1, 3, 2};
                    arr[4] = new int[]{5, 3, 2, 1, 4};
                    break;
                case 15:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{2, 3, 4, 5, 1};
                    arr[2] = new int[]{3, 1, 5, 2, 4};
                    arr[3] = new int[]{4, 5, 1, 3, 2};
                    arr[4] = new int[]{5, 4, 2, 1, 3};
                    break;
                case 16:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{2, 4, 5, 1, 3};
                    arr[2] = new int[]{3, 1, 4, 5, 2};
                    arr[3] = new int[]{4, 5, 2, 3, 1};
                    arr[4] = new int[]{5, 3, 1, 2, 4};
                    break;
                case 17:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{2, 5, 4, 1, 3};
                    arr[2] = new int[]{3, 1, 5, 2, 4};
                    arr[3] = new int[]{4, 3, 1, 5, 2};
                    arr[4] = new int[]{5, 4, 2, 3, 1};
                    break;
                case 18:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{2, 4, 5, 3, 1};
                    arr[2] = new int[]{3, 5, 4, 1, 2};
                    arr[3] = new int[]{4, 1, 2, 5, 3};
                    arr[4] = new int[]{5, 3, 1, 2, 4};
                    break;
                case 19:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{2, 5, 1, 3, 4};
                    arr[2] = new int[]{3, 4, 5, 1, 2};
                    arr[3] = new int[]{4, 3, 2, 5, 1};
                    arr[4] = new int[]{5, 1, 4, 2, 3};
                    break;
                case 20:
                    arr[0] = new int[]{1, 2, 3, 4, 5};
                    arr[1] = new int[]{2, 5, 4, 1, 3};
                    arr[2] = new int[]{3, 4, 5, 2, 1};
                    arr[3] = new int[]{4, 3, 1, 5, 2};
                    arr[4] = new int[]{5, 1, 2, 3, 4};
                    break;
                case 25:
                    arr[0] = new int[]{5, 1, 2, 3, 4};
                    arr[1] = new int[]{4, 5, 1, 2, 3};
                    arr[2] = new int[]{3, 4, 5, 1, 2};
                    arr[3] = new int[]{2, 3, 4, 5, 1};
                    arr[4] = new int[]{1, 2, 3, 4, 5};
                    break;
                default:
                    return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int i = 0; i < row.length; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(row[i]);
            }
            System.out.println();
        }
    }
}