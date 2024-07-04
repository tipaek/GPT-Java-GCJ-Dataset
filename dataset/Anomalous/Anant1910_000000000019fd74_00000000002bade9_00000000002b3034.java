import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

class Solution {

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

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int T = input.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = input.nextInt();
            String[] p = new String[n];
            for (int i = 0; i < n; i++) {
                p[i] = input.nextLine();
            }

            Vector<String> a = new Vector<>();
            for (String s : p) {
                if (s.charAt(0) != '*') {
                    String[] b = s.split("\\*");
                    for (String value : b) {
                        a.add(value);
                    }
                } else {
                    a.add(s.substring(1));
                }
            }

            String out = "";
            int maxLengthIndex = 0;
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                if (p[i].length() > maxLength) {
                    maxLengthIndex = i;
                    maxLength = p[i].length();
                }
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (!a.elementAt(i).contains(a.elementAt(j)) && !a.elementAt(j).contains(a.elementAt(i))) {
                            out = "*";
                            break;
                        }
                    }
                }
            }

            if (!out.equals("*")) {
                for (int i = 0; i < p[maxLengthIndex].length(); i++) {
                    if (p[maxLengthIndex].charAt(i) == '*') {
                        String q = p[maxLengthIndex].substring(0, i);
                        String r = p[maxLengthIndex].substring(i + 1);
                        out = q + q + r;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + out);
        }
    }
}