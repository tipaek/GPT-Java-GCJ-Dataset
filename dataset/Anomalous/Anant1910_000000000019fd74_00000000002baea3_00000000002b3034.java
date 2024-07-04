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

            Vector<String> parts = new Vector<>();
            for (String pattern : patterns) {
                if (pattern.charAt(0) != '*') {
                    String[] splitParts = pattern.split("\\*");
                    for (String part : splitParts) {
                        parts.add(part);
                    }
                } else {
                    parts.add(pattern.substring(1));
                }
            }

            String output = "";
            int maxSizeIndex = 0;
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                if (patterns[i].length() > maxLength) {
                    maxSizeIndex = i;
                    maxLength = patterns[i].length();
                }

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        if (!parts.elementAt(i).contains(parts.elementAt(j)) && !parts.elementAt(j).contains(parts.elementAt(i))) {
                            output = "*";
                            break;
                        }
                    }
                }

                if (output.equals("*")) {
                    break;
                }
            }

            if (!output.equals("*")) {
                for (int i = 0; i < patterns[maxSizeIndex].length(); i++) {
                    if (patterns[maxSizeIndex].charAt(i) == '*') {
                        String prefix = patterns[maxSizeIndex].substring(0, i);
                        String suffix = patterns[maxSizeIndex].substring(i + 1);
                        output = prefix + suffix;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + output);
        }
    }
}