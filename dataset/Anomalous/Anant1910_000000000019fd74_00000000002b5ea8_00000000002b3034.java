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

            Vector<String> substrings = new Vector<>();
            for (String pattern : patterns) {
                int startIndex = 0;
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == '*') {
                        substrings.add(pattern.substring(startIndex, j));
                        startIndex = j + 1;
                    }
                }
            }

            String result = "";
            int maxLengthIndex = 0;
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                if (patterns[i].length() > maxLength) {
                    maxLengthIndex = i;
                    maxLength = patterns[i].length();
                }
                for (int j = 0; j < n; j++) {
                    if (i != j && !substrings.elementAt(i).contains(substrings.elementAt(j))) {
                        result = "*";
                        break;
                    }
                }
            }

            for (int i = 0; i < patterns[maxLengthIndex].length(); i++) {
                if (patterns[maxLengthIndex].charAt(i) == '*') {
                    String prefix = patterns[maxLengthIndex].substring(0, i);
                    String suffix = patterns[maxLengthIndex].substring(i + 1);
                    result = prefix + "A" + suffix;
                }
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }
}