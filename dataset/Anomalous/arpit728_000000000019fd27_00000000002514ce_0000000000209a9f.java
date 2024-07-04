import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution {
    private final Input reader = new Input();

    private static final String[] OPENING_DEPTH = {"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
    private static final String[] CLOSING_DEPTH = {"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};

    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    void solve() throws IOException {
        int t = reader.readInt();
        for (int caseId = 1; caseId <= t; caseId++) {
            char[] s = reader.readLine().toCharArray();
            StringBuilder sbr = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                int count = 0;
                int digit = Character.digit(s[i], 10);
                int j;
                for (j = i; j < s.length; j++) {
                    if (s[i] == s[j]) {
                        count++;
                    } else {
                        break;
                    }
                }
                sbr.append(OPENING_DEPTH[digit]).append(repeat(s[i], count)).append(CLOSING_DEPTH[digit]);
                i = j - 1;
            }
            System.out.printf("Case #%d: %s\n", caseId, sbr.toString());
        }
    }

    private String repeat(char c, int n) {
        StringBuilder sbr = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sbr.append(c);
        }
        return sbr.toString();
    }

    private static class Input {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int readInt() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        long readLong() throws IOException {
            return Long.parseLong(br.readLine());
        }

        int[] readIntArray(int n) throws IOException {
            String[] s = br.readLine().split("\\s");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            return a;
        }

        int[][] readIntMatrix(int n) throws IOException {
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split("\\s");
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            return a;
        }

        long[] readLongArray(int n) throws IOException {
            String[] s = br.readLine().split("\\s");
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(s[i]);
            }
            return a;
        }

        String readLine() throws IOException {
            return br.readLine();
        }
    }
}