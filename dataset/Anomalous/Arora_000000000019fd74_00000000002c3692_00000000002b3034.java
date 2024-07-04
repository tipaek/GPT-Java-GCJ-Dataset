import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        
        for (int p1 = 0; p1 < t; p1++) {
            int n = sc.nextInt();
            String[] a = new String[n];
            int[] len = new int[n];
            boolean hasNonStarPrefix = false;
            int maxLength = 0;
            String maxString = "";

            for (int i = 0; i < n; i++) {
                a[i] = sc.next();
                len[i] = a[i].length();
                if (a[i].charAt(0) != '*') {
                    hasNonStarPrefix = true;
                }
                if (maxLength < len[i]) {
                    maxLength = len[i];
                    maxString = a[i];
                }
            }

            if (!hasNonStarPrefix) {
                String ans = handleCase1(a, maxString, n, maxLength);
                System.out.println("Case #" + (p1 + 1) + ": " + ans);
            } else {
                String val1 = a[0];
                boolean isInvalid = false;
                for (int i = 1; i < n; i++) {
                    val1 = handleCase2(val1, a[i]);
                    if (val1.equals("-1")) {
                        isInvalid = true;
                        break;
                    }
                }
                if (isInvalid) {
                    System.out.println("Case #" + (p1 + 1) + ": *");
                } else {
                    String ans = val1.replace("*", "");
                    System.out.println("Case #" + (p1 + 1) + ": " + ans);
                }
            }
        }
    }

    static String handleCase1(String[] a, String maxString, int n, int maxLength) {
        for (int i = 0; i < n; i++) {
            int k1 = maxLength - 1;
            int k2 = a[i].length() - 1;
            while (k1 > 0 && k2 > 0) {
                if (maxString.charAt(k1) != a[i].charAt(k2)) {
                    return "*";
                }
                k1--;
                k2--;
            }
        }
        return maxString.substring(1);
    }

    static String handleCase2(String p, String s) {
        int x = p.indexOf("*");
        int y = s.indexOf("*");
        int k1 = 0, k2 = 0;
        
        while (k1 < x && k2 < y) {
            if (p.charAt(k1) != s.charAt(k2)) {
                return "-1";
            }
            k1++;
            k2++;
        }

        k1 = p.length() - 1;
        k2 = s.length() - 1;
        while (k1 > x && k2 > y) {
            if (p.charAt(k1) != s.charAt(k2)) {
                return "-1";
            }
            k1--;
            k2--;
        }

        String p1 = p.substring(0, x);
        String p2 = p.substring(x + 1);
        String s1 = s.substring(0, y);
        String s2 = s.substring(y + 1);

        StringBuilder ans = new StringBuilder();
        ans.append(p1.length() >= s1.length() ? p1 : s1);
        ans.append("*");
        ans.append(p2.length() >= s2.length() ? p2 : s2);

        return ans.toString();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
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

        String nextLine() { 
            String str = ""; 
            try {
                str = br.readLine(); 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}