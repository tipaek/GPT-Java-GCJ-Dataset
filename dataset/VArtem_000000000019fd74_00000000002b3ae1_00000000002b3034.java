import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int n = in.nextInt();
            List<String>[] str = new List[n];
            String[] pats = new String[n];
            for (int i = 0; i < n; i++) {
                pats[i] = in.next();
            }
            String maxPrefix = "", maxSuffix = "";
            for (int i = 0; i < n; i++) {
                str[i] = Arrays.asList(pats[i].split("\\*"));
                {
                    String pref = str[i].get(0);
                    if (pref.length() <= maxPrefix.length()) {
                        if (!maxPrefix.startsWith(pref)) {
                            out.println("*");
                            return;
                        }
                        // ok
                    } else {
                        if (!pref.startsWith(maxPrefix)) {
                            out.println("*");
                            return;
                        }
                        maxPrefix = pref;
                    }
                }
                {
                    String suf = str[i].get(str[i].size() - 1);
                    if (suf.length() <= maxSuffix.length()) {
                        if (!maxSuffix.endsWith(suf)) {
                            out.println("*");
                            return;
                        }
                    } else {
                        if (!suf.endsWith(maxSuffix)) {
                            out.println("*");
                            return;
                        }
                        maxSuffix = suf;
                    }
                }
            }
            out.print(maxPrefix);
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < str[i].size() - 1; j++) {
                    out.print(str[i].get(j));
                }
            }
            out.println(maxSuffix);
        }

    }

    static class FastScanner {
        public BufferedReader br;
        public StringTokenizer st;

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

    }
}

