import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

class Solution {

    private Input reader = new Input();

    String openingDepth[] = new String[]{"", "(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
    String closingDepth[] = new String[]{"", ")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};


    public static void main(String args[]) throws Exception {
        Solution sol = new Solution();
        sol.solve();
    }

    void solve() throws Exception {

        int t = reader.readInt();
        for (int caseId = 1; caseId <= t; caseId++) {
            char s[] = reader.readLine().toCharArray();
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
                sbr.append(openingDepth[digit] + repeat(s[i], count) + closingDepth[digit]);
                i = j - 1;
            }
            System.out.printf("Case #%d: %s\n", caseId, sbr.toString());
        }

    }

    private String repeat(char c, int n) {
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sbr.append(c);
        }
        return sbr.toString();
    }

    private static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int readInt() throws Exception {
            return parseInt(br.readLine());
        }

        long readLong() throws Exception {
            return parseLong(br.readLine());
        }

        int[] readIntArray(int n) throws Exception {
            String[] s = br.readLine().split("\\s");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = parseInt(s[i]);
            }
            return a;
        }

        /*Reads and return square matrix of integer elements*/
        int[][] readIntMatrix(int n) throws Exception {
            int a[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split("\\s");
                for (int j = 0; j < n; j++) {
                    a[i][j] = parseInt(s[j]);
                }
            }
            return a;
        }

        long[] readLongArray(int n) throws Exception {
            String[] s = br.readLine().split("\\s");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = parseLong(s[i]);
            }
            return a;
        }

        String readLine() throws Exception {
            return br.readLine();
        }
    }
}

