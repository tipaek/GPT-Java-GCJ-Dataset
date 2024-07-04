import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            String result = "IMPOSSIBLE";
            String matrix = "";

            if (N == 2) {
                result = checkAndFetchResult(K, new int[]{2, 4}, new String[]{"null", "null", "1 2\n2 1\n", "null", "1 2\n2 1\n"});
            } else if (N == 3) {
                result = checkAndFetchResult(K, new int[]{3, 6, 9}, new String[]{"null", "null", "null", "1 2 3\n2 3 1\n3 1 2\n", "null", "null", "1 2 3\n2 3 1\n3 1 2\n", "null", "null", "1 2 3\n2 3 1\n3 1 2\n"});
            } else if (N == 4) {
                result = checkAndFetchResult(K, new int[]{16, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14}, new String[]{"null", "null", "null", "null", "4 3 2 1\n3 4 1 2\n2 1 4 3\n1 2 3 4\n", "null", "1 2 3 4\n2 1 4 3\n3 4 2 1\n4 3 1 2\n", "1 2 4 3\n2 4 3 1\n3 1 2 4\n4 3 1 2\n", "1 2 3 4\n2 1 4 3\n3 4 1 2\n4 3 2 1\n", "1 2 3 4\n2 1 4 3\n3 4 2 1\n4 3 1 2\n", "1 2 3 4\n2 4 1 3\n3 1 4 2\n4 3 2 1\n", "4 3 2 1\n3 4 1 2\n1 2 4 3\n2 1 3 4\n", "4 3 2 1\n3 4 1 2\n2 1 4 3\n1 2 3 4\n", "1 2 4 3\n2 4 3 1\n3 1 2 4\n4 3 1 2\n", "1 2 4 3\n2 1 3 4\n3 4 1 2\n4 3 2 1\n", "null", "1 2 3 4\n2 1 4 3\n3 4 1 2\n4 3 2 1\n"});
            } else if (N == 5) {
                result = checkAndFetchResult(K, new int[]{5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25}, new String[]{"null", "null", "null", "null", "null", "5 4 3 2 1\n3 5 4 1 2\n4 2 1 5 3\n2 1 5 3 4\n1 3 2 4 5\n", "null", "1 2 3 5 4\n2 1 4 3 5\n3 4 5 2 1\n4 5 2 1 3\n5 3 1 4 2\n", "5 4 3 2 1\n3 5 4 1 2\n4 1 2 5 3\n1 2 5 3 4\n2 3 1 4 5\n", "1 2 3 4 5\n2 3 1 5 4\n3 4 5 1 2\n4 5 2 3 1\n5 1 4 2 3\n", "1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n", "1 2 3 4 5\n2 1 4 5 3\n3 5 1 2 4\n4 3 5 1 2\n5 4 2 3 1\n", "1 2 3 4 5\n2 1 4 5 3\n3 5 1 2 4\n4 3 5 1 2\n5 4 2 3 1\n", "5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n", "5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n", "5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n", "5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n", "5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n", "1 2 3 4 5\n2 1 4 5 3\n3 5 1 2 4\n4 3 5 1 2\n5 4 2 3 1\n", "1 2 3 4 5\n2 1 4 5 3\n3 5 1 2 4\n4 3 5 1 2\n5 4 2 3 1\n", "1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n", "1 2 3 4 5\n2 1 5 3 4\n3 5 4 1 2\n4 3 2 5 1\n5 4 1 2 3\n", "1 2 3 4 5\n2 4 1 5 3\n3 5 4 1 2\n4 3 5 2 1\n5 1 2 3 4\n", "1 2 3 5 4\n2 3 1 4 5\n3 4 5 2 1\n4 5 2 1 3\n5 1 4 3 2\n", "null", "1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n"});
            }

            if (!result.equals("IMPOSSIBLE")) {
                System.out.println("Case #" + t + ": " + result + "\n" + matrix.trim());
            } else {
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }

    private static String checkAndFetchResult(int K, int[] validKs, String[] matrices) {
        for (int i = 0; i < validKs.length; i++) {
            if (K == validKs[i]) {
                return "POSSIBLE\n" + matrices[K];
            }
        }
        return "IMPOSSIBLE";
    }
}