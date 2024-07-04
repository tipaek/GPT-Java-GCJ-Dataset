import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        final long MOD = 1000000007;
        int t = sc.nextInt();
        int caseNumber = 1;

        while (caseNumber <= t) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            boolean isFaulty = false;

            for (int i = 0; i < n; i++) {
                patterns[i] = "#" + sc.nextLine() + "#";
            }

            String prefix = "#", suffix = "#";

            for (int i = 0; i < n; i++) {
                String[] parts = patterns[i].split("\\*");

                if ((parts[0].length() <= prefix.length() && !prefix.startsWith(parts[0])) ||
                    (parts[0].length() >= prefix.length() && !parts[0].startsWith(prefix))) {
                    isFaulty = true;
                    break;
                }

                if ((parts[1].length() <= suffix.length() && !suffix.endsWith(parts[1])) ||
                    (parts[1].length() >= suffix.length() && !parts[1].endsWith(suffix))) {
                    isFaulty = true;
                    break;
                }

                if (parts[0].length() > prefix.length()) {
                    prefix = parts[0];
                }

                if (parts[1].length() > suffix.length()) {
                    suffix = parts[1];
                }

                if (prefix.length() + suffix.length() > 10000) {
                    isFaulty = true;
                    break;
                }
            }

            if (isFaulty) {
                out.println("Case #" + caseNumber + ": *");
            } else {
                out.println("Case #" + caseNumber + ": " + (prefix + suffix).substring(1, prefix.length() + suffix.length() - 1));
            }

            caseNumber++;
        }

        out.close();
    }

    public String solve(int n, int[] s, int[] e) {
        return "";
    }

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
}