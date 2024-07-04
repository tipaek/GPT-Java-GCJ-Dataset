import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void solve() {
        int n = scan.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = scan.next();
        }
        StringBuilder firstPart = new StringBuilder();
        for (String pattern : patterns) {
            int j = 0;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '*') break;
                if (firstPart.length() > j) {
                    if (firstPart.charAt(j) == pattern.charAt(i)) {
                        j++;
                    } else {
                        out.println("*");
                        return;
                    }
                } else {
                    firstPart.append(pattern.charAt(i));
                    j++;
                }
            }
        }
        StringBuilder middlePart = new StringBuilder();
        for (String pattern : patterns) {
            int start = pattern.indexOf("*");
            int end = pattern.lastIndexOf("*");
            for (int i = start + 1; i < end; i++) {
                if (pattern.charAt(i) == '*') continue;
                middlePart.append(pattern.charAt(i));
            }
        }
        StringBuilder lastPart = new StringBuilder();
        for (String pattern : patterns) {
            int j = 0;
            for (int i = pattern.length() - 1; i >= 0; i--) {
                if (pattern.charAt(i) == '*') break;
                if (lastPart.length() > j) {
                    if (lastPart.charAt(j) == pattern.charAt(i)) {
                        j++;
                    } else {
                        out.println("*");
                        return;
                    }
                } else {
                    lastPart.append(pattern.charAt(i));
                    j++;
                }
            }
        }
        lastPart.reverse();
        out.println(firstPart.append(middlePart).append(lastPart));
    }

    public static void main(String[] args) throws Exception {
        scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        // your code
        int t = scan.nextInt();
        for (int ttc = 1; ttc <= t; ttc++) {
            out.print("Case #" + ttc + ": ");
            solve();
        }

        out.close();
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
    public static MyScanner scan;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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
    //--------------------------------------------------------

}