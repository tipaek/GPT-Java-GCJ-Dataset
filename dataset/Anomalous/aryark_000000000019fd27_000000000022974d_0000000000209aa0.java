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
            boolean possible = true;

            switch (N) {
                case 2:
                    possible = handleCaseFor2(K, arr);
                    break;
                case 3:
                    possible = handleCaseFor3(K, arr);
                    break;
                case 4:
                    possible = handleCaseFor4(K, arr);
                    break;
                case 5:
                    possible = handleCaseFor5(K, arr);
                    break;
                default:
                    possible = false;
            }

            if (possible) {
                System.out.println("POSSIBLE");
                for (int[] row : arr) {
                    for (int num : row) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private boolean handleCaseFor2(int K, int[][] arr) {
        if (K == 2) {
            arr[0] = new int[]{1, 2};
            arr[1] = new int[]{2, 1};
        } else if (K == 3) {
            return false;
        } else {
            arr[0] = new int[]{2, 1};
            arr[1] = new int[]{1, 2};
        }
        return true;
    }

    private boolean handleCaseFor3(int K, int[][] arr) {
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

    private boolean handleCaseFor4(int K, int[][] arr) {
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
        return true;
    }

    private boolean handleCaseFor5(int K, int[][] arr) {
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
            case 22:
                arr[0] = new int[]{4, 3, 5, 1, 2};
                arr[1] = new int[]{5, 4, 1, 2, 3};
                arr[2] = new int[]{2, 5, 5, 3, 1};
                arr[3] = new int[]{3, 1, 2, 5, 4};
                arr[4] = new int[]{1, 2, 3, 4, 5};
                break;
            case 23:
                arr[0] = new int[]{5, 3, 4, 1, 2};
                arr[1] = new int[]{4, 5, 1, 2, 3};
                arr[2] = new int[]{2, 4, 5, 3, 1};
                arr[3] = new int[]{3, 1, 2, 4, 5};
                arr[4] = new int[]{1, 2, 3, 5, 4};
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
        return true;
    }
}