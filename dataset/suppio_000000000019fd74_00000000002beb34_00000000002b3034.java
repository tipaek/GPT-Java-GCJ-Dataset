import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    private static class FastReader {
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

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();

            String[] prefixes = new String[n];
            String[] suffixes = new String[n];

            String longestPrefix = "";
            String longestSuffix = "";
            boolean goodPrefix = true;
            boolean goodSuffix = true;

            for (int j = 0; j < n; j++) {
                String p = in.next();
                int asteriskPosition = p.indexOf('*');

                prefixes[j] = p.substring(0, asteriskPosition);
                suffixes[j] = p.substring(asteriskPosition + 1);

                if (prefixes[j].length() > longestPrefix.length()) {
                    longestPrefix = prefixes[j];
                } else if (prefixes[j].length() == longestPrefix.length() && !prefixes[j].equals(longestPrefix)) {
                    goodPrefix = false;
                }

                if (suffixes[j].length() > longestSuffix.length()) {
                    longestSuffix = suffixes[j];
                } else if (suffixes[j].length() == longestSuffix.length() && !suffixes[j].equals(longestSuffix)) {
                    goodSuffix = false;
                }
            }

            // Check prefixes and suffixes
            for (int j = 0; j < n; j++) {
                if (!longestPrefix.startsWith(prefixes[j])) {
                    goodPrefix = false;
                    break;
                }
                if (!longestSuffix.endsWith(suffixes[j])) {
                    goodSuffix = false;
                    break;
                }
            }

            if (goodPrefix && goodSuffix) {
                out.printf("Case #%d: %s%n", i, longestPrefix + longestSuffix);
            } else {
                out.printf("Case #%d: %s%n", i, "*");
            }
        }
    }
}
