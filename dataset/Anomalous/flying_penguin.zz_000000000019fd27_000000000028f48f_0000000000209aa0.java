import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();
            
            String result = isPossible(N, K) ? "POSSIBLE" : "IMPOSSIBLE";
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static boolean isPossible(int N, int K) {
        switch (N) {
            case 2:
                return K == 2 || K == 4;
            case 3:
                return K == 3 || K == 6 || K == 9;
            case 4:
                int[] t4 = {16, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14};
                return contains(t4, K);
            case 5:
                int[] t5 = {5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25};
                return contains(t5, K);
            default:
                return false;
        }
    }

    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}