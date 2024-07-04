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
            int maxSuffixLength = -1;
            int maxSuffixIndex = -1;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    if (s[i].charAt(j) == '*') {
                        suff[i] = j;
                        if (s[i].length() - suff[i] > maxSuffixLength) {
                            maxSuffixLength = s[i].length() - suff[i] + 1;
                            maxSuffixIndex = i;
                        }
                        break;
                    }
                }
            }
            
            boolean isValid = true;
            
            for (int i = 0; i < n; i++) {
                int l = s[maxSuffixIndex].length() - 1;
                for (int j = s[i].length() - 1; j >= 0; j--) {
                    if (j == suff[i]) break;
                    if (s[i].charAt(j) != s[maxSuffixIndex].charAt(l--)) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            if (!isValid) {
                System.out.println("Case #" + tt + ": *");
                continue;
            }
            
            maxSuffixLength = -1;
            int maxPrefixIndex = -1;
            
            for (int i = 0; i < n; i++) {
                if (maxSuffixLength < suff[i]) {
                    maxSuffixLength = suff[i];
                    maxPrefixIndex = i;
                }
            }
            
            isValid = true;
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < s[i].length(); j++) {
                    if (j == suff[i]) break;
                    if (s[i].charAt(j) != s[maxPrefixIndex].charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            if (!isValid) {
                System.out.println("Case #" + tt + ": *");
                continue;
            }
            
            StringBuilder result = new StringBuilder();
            result.append(s[maxPrefixIndex], 0, suff[maxPrefixIndex])
                  .append(s[maxSuffixIndex].substring(suff[maxSuffixIndex] + 1));
            System.out.println("Case #" + tt + ": " + result + "A");
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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