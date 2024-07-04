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
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = input.nextLine();
            }

            Vector<String> segments = new Vector<>();
            for (String pattern : patterns) {
                if (pattern.charAt(0) != '*') {
                    String[] parts = pattern.split("\\*");
                    for (String part : parts) {
                        segments.add(part);
                    }
                } else {
                    segments.add(pattern.substring(1));
                }
            }

            String result = "";
            int maxLength = 0;
            int maxIndex = 0;

            for (int i = 0; i < n; i++) {
                if (patterns[i].length() > maxLength) {
                    maxLength = patterns[i].length();
                    maxIndex = i;
                }

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (!segments.elementAt(i).contains(segments.elementAt(j)) &&
                            !segments.elementAt(j).contains(segments.elementAt(i))) {
                            result = "*";
                            break;
                        }
                    }
                }
                if (result.equals("*")) {
                    break;
                }
            }

            if (!result.equals("*")) {
                for (int i = 0; i < patterns[maxIndex].length(); i++) {
                    if (patterns[maxIndex].charAt(i) == '*') {
                        String prefix = patterns[maxIndex].substring(0, i);
                        String suffix = patterns[maxIndex].substring(i + 1);
                        result = prefix + "A" + suffix;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}