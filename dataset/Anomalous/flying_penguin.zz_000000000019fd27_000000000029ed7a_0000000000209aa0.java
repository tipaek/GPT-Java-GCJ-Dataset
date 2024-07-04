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

            String result = findMatrix(N, K);
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static String findMatrix(int N, int K) {
        Map<Integer, String[]> matrixMap = new HashMap<>();
        matrixMap.put(2, new String[]{"null", "null", "1 2\n2 1\n", "null", "2 1\n1 2\n"});
        matrixMap.put(3, new String[]{"null", "null", "null", "1 3 2\n2 1 3\n3 2 1\n", "null", "null", "2 1 3\n3 2 1\n1 3 2\n", "null", "null", "3 2 1\n1 3 2\n2 1 3\n"});
        matrixMap.put(4, new String[]{"null", "null", "null", "null", "1 2 3 4\n2 1 4 3\n3 4 1 2\n4 3 2 1\n", "null", "1 2 4 3\n2 1 3 4\n4 3 2 1\n3 4 1 2\n", "1 3 4 2\n4 2 1 3\n2 1 3 4\n3 4 2 1\n", "3 4 1 2\n2 1 4 3\n1 2 3 4\n4 3 2 1\n", "3 4 1 2\n1 2 4 3\n2 1 3 4\n4 3 2 1\n", "4 3 2 1\n3 1 4 2\n2 4 1 3\n1 2 3 4\n", "2 1 4 3\n3 4 2 1\n4 3 1 2\n1 2 3 4\n", "2 1 4 3\n3 4 1 2\n4 3 2 1\n1 2 3 4\n", "2 1 3 4\n3 4 2 1\n1 3 4 2\n4 2 1 3\n", "3 4 2 1\n4 3 1 2\n2 1 4 3\n1 2 3 4\n", "null", "4 3 2 1\n3 4 1 2\n2 1 4 3\n1 2 3 4\n"});
        matrixMap.put(5, new String[]{"null", "null", "null", "null", "null", "1 2 3 4 5\n2 1 4 5 3\n3 5 1 2 4\n4 3 5 1 2\n5 4 2 3 1\n", "null", "1 2 5 4 3\n3 1 2 5 4\n2 4 1 3 5\n4 5 3 2 1\n5 3 4 1 2\n", "1 2 3 4 5\n2 1 4 5 3\n3 5 2 1 4\n4 3 5 2 1\n5 4 1 3 2\n", "4 5 1 3 2\n2 1 5 4 3\n1 3 2 5 4\n3 2 4 1 5\n5 4 3 2 1\n", "3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n5 4 3 2 1\n", "4 2 1 5 3\n2 1 5 3 4\n1 3 2 4 5\n5 4 3 2 1\n3 5 4 1 2\n", "2 1 5 3 4\n1 3 2 4 5\n5 4 3 2 1\n3 5 4 1 2\n4 2 1 5 3\n", "2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n1 2 3 4 5\n", "1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n", "5 3 2 1 4\n1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n4 5 1 3 2\n", "4 5 1 3 2\n5 3 2 1 4\n1 2 3 4 5\n2 1 4 5 3\n3 4 5 2 1\n", "3 4 5 2 1\n4 5 1 3 2\n5 3 2 1 4\n1 2 3 4 5\n2 1 4 5 3\n", "1 3 2 4 5\n5 4 3 2 1\n3 5 4 1 2\n4 2 1 5 3\n2 1 5 3 4\n", "5 4 3 2 1\n3 5 4 1 2\n4 2 1 5 3\n2 1 5 3 4\n1 3 2 4 5\n", "4 1 2 3 5\n5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n", "3 2 1 4 5\n5 4 3 2 1\n4 3 5 1 2\n2 1 4 5 3\n1 5 2 3 4\n", "5 4 3 2 1\n3 5 1 4 2\n2 1 4 5 3\n1 2 5 3 4\n4 3 2 1 5\n", "4 5 3 2 1\n5 4 1 3 2\n1 2 5 4 3\n3 1 2 5 4\n2 3 4 1 5\n", "null", "5 4 3 2 1\n3 5 4 1 2\n1 2 5 4 3\n2 3 1 5 4\n4 1 2 3 5\n"});

        if (matrixMap.containsKey(N) && K < matrixMap.get(N).length && matrixMap.get(N)[K] != null) {
            return "POSSIBLE\n" + matrixMap.get(N)[K].trim();
        } else {
            return "IMPOSSIBLE";
        }
    }
}