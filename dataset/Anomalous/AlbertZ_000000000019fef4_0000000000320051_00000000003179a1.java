import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = 1000000000L;
    private static final double LN2 = Math.log(2);
    private double[] logFac;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            out.printf("Case #%d: %s%n", i, solution.solve());
        }
        out.flush();
        System.exit(0);
    }

    private String solve() {
        int u = sc.nextInt();
        int[] letterCount = new int[26];
        boolean[] isFirstLetter = new boolean[26];
        
        for (int i = 0; i < 10000; i++) {
            int m = sc.nextInt();
            char[] arr = sc.next().toCharArray();
            for (char c : arr) {
                letterCount[c - 'A']++;
            }
            isFirstLetter[arr[0] - 'A'] = true;
        }

        List<int[]> letterList = new ArrayList<>();
        char zeroChar = ' ';
        for (int i = 0; i < 26; i++) {
            if (letterCount[i] == 0) continue;
            if (!isFirstLetter[i]) {
                zeroChar = (char) (i + 'A');
            } else {
                letterList.add(new int[]{i, letterCount[i]});
            }
        }

        letterList.sort((o1, o2) -> o2[1] - o1[1]);

        StringBuilder result = new StringBuilder();
        result.append(zeroChar);
        for (int[] letter : letterList) {
            result.append((char) (letter[0] + 'A'));
        }

        return result.toString();
    }
}