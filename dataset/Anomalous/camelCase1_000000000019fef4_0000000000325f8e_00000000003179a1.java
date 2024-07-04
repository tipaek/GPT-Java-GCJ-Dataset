import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int caseNumber = 1;
        PrintWriter out = new PrintWriter(System.out);

        while (t-- > 0) {
            int u = nextInt();
            boolean[][] limit = new boolean[26][10];
            for (boolean[] c : limit) {
                Arrays.fill(c, true);
            }

            int[] poss = new int[26];
            boolean[] used = new boolean[26];

            for (int i = 0; i < 10000; i++) {
                char[] q = next().toCharArray();
                char[] arr = next().toCharArray();
                limit[arr[0] - 'A'][0] = false;

                if (q[0] != '-' && arr.length == q.length) {
                    for (int j = 0; j < q.length; j++) {
                        for (int k = q[j] - '0' + 1; k < 10; k++) {
                            limit[arr[j] - 'A'][k] = false;
                        }
                        int t1 = checkPossibility(limit, arr[j]);
                        if (t1 == -1 || t1 != q[j] - '0') {
                            break;
                        }
                    }
                }

                poss[arr[0] - 'A']++;
                for (char c : arr) {
                    used[c - 'A'] = true;
                }
            }

            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                int largest = 0;
                for (int i = 1; i < 26; i++) {
                    if (poss[i] > poss[largest]) {
                        largest = i;
                    }
                }
                used[largest] = false;
                poss[largest] = 0;
                ans.append((char) (largest + 'A'));
            }

            for (int i = 0; i < 26; i++) {
                if (used[i]) {
                    ans.insert(0, (char) (i + 'A'));
                    break;
                }
            }

            for (int i = 0; i < 26; i++) {
                int pos = checkPossibility(limit, (char) ('A' + i));
                if (pos != -1) {
                    int idx = ans.indexOf(Character.toString((char) ('A' + i)));
                    ans.setCharAt(pos, ans.charAt(idx));
                    ans.setCharAt(idx, (char) ('A' + i));
                }
            }

            for (int i = 0; i < 10; i++) {
                if (!limit[ans.charAt(i) - 'A'][i]) {
                    for (int j = 0; j < 10; j++) {
                        if (limit[ans.charAt(j) - 'A'][i] && limit[ans.charAt(i) - 'A'][i]) {
                            char temp = ans.charAt(i);
                            ans.setCharAt(i, ans.charAt(j));
                            ans.setCharAt(j, temp);
                            break;
                        }
                    }
                }
            }

            out.println("Case #" + (caseNumber++) + ": " + ans);
        }
        out.close();
    }

    private static int checkPossibility(boolean[][] limit, char c) {
        int digit = -1;
        for (int i = 0; i < 10; i++) {
            if (limit[c - 'A'][i]) {
                if (digit == -1) {
                    digit = i;
                } else {
                    return -1;
                }
            }
        }
        return digit;
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}