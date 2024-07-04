import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final PrintWriter OUT = new PrintWriter(System.out);
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = 1000000000;
    private double[] logFac;
    private static final double LN2 = Math.log(2);

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int testCases = SCANNER.nextInt();
        for (int i = 1; i <= testCases; i++) {
            OUT.printf("Case #%d: %s%n", i, solution.solve());
        }
        OUT.flush();
        System.exit(0);
    }

    private String solve() {
        int u = SCANNER.nextInt();
        int[] count = new int[26];
        int[] result = new int[26];
        boolean[] visited = new boolean[26];

        for (int i = 0; i < 10000; i++) {
            long m = SCANNER.nextLong();
            char[] characters = SCANNER.next().toCharArray();
            for (char c : characters) {
                count[c - 'A']++;
            }
            result[characters[0] - 'A']++;
            visited[characters[0] - 'A'] = true;
        }

        List<int[]> list = new ArrayList<>();
        char zeroChar = ' ';
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) continue;
            if (!visited[i]) {
                zeroChar = (char) (i + 'A');
            } else {
                list.add(new int[]{i, result[i]});
            }
        }

        list.sort((o1, o2) -> Integer.compare(o2[1], o1[1]));

        StringBuilder sb = new StringBuilder();
        sb.append(zeroChar);
        for (int[] num : list) {
            sb.append((char) (num[0] + 'A'));
        }
        return sb.toString();
    }
}