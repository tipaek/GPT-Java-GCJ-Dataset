import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.next();
            }
            int[] suff = new int[n];
            int maxLen = -1;
            int maxIndex = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    if (s[i].charAt(j) == '*') {
                        suff[i] = j;
                        int suffixLen = s[i].length() - j;
                        if (suffixLen > maxLen) {
                            maxLen = suffixLen;
                            maxIndex = i;
                        }
                        break;
                    }
                }
            }

            boolean isSuffixMatching = true;
            for (int i = 0; i < n; i++) {
                int l = s[maxIndex].length() - 1;
                for (int j = s[i].length() - 1; j >= suff[i]; j--) {
                    if (s[i].charAt(j) != s[maxIndex].charAt(l--)) {
                        isSuffixMatching = false;
                        break;
                    }
                }
                if (!isSuffixMatching) break;
            }

            if (!isSuffixMatching) {
                System.out.println("Case #" + tt + ": *");
                continue;
            }

            maxLen = -1;
            int maxPrefixIndex = -1;
            for (int i = 0; i < n; i++) {
                if (suff[i] > maxLen) {
                    maxLen = suff[i];
                    maxPrefixIndex = i;
                }
            }

            boolean isPrefixMatching = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < suff[i]; j++) {
                    if (s[i].charAt(j) != s[maxPrefixIndex].charAt(j)) {
                        isPrefixMatching = false;
                        break;
                    }
                }
                if (!isPrefixMatching) break;
            }

            if (!isPrefixMatching) {
                System.out.println("Case #" + tt + ": *");
                continue;
            }

            StringBuilder result = new StringBuilder();
            result.append(s[maxPrefixIndex], 0, suff[maxPrefixIndex])
                  .append(s[maxIndex].substring(suff[maxIndex] + 1));
            System.out.println("Case #" + tt + ": " + result);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}