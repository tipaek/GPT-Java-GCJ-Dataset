import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = in.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = in.next();
            }

            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            List<String> middles = new ArrayList<>();
            boolean isInvalid = false;

            for (String pattern : patterns) {
                int firstStar = pattern.indexOf('*');
                int lastStar = pattern.lastIndexOf('*');

                String currentPrefix = pattern.substring(0, firstStar);
                String currentSuffix = new StringBuilder(pattern.substring(lastStar + 1)).reverse().toString();
                String middle = pattern.substring(firstStar + 1, lastStar).replace("*", "");

                if (!prefix.toString().startsWith(currentPrefix) && !currentPrefix.startsWith(prefix.toString())) {
                    isInvalid = true;
                    break;
                }
                if (!suffix.toString().startsWith(currentSuffix) && !currentSuffix.startsWith(suffix.toString())) {
                    isInvalid = true;
                    break;
                }

                if (prefix.length() < currentPrefix.length()) {
                    prefix = new StringBuilder(currentPrefix);
                }
                if (suffix.length() < currentSuffix.length()) {
                    suffix = new StringBuilder(currentSuffix);
                }

                middles.add(middle);
            }

            if (isInvalid) {
                pw.println("Case #" + x + ": *");
            } else {
                StringBuilder result = new StringBuilder();
                result.append(prefix);
                for (String middle : middles) {
                    result.append(middle);
                }
                result.append(suffix.reverse());
                pw.println("Case #" + x + ": " + result.toString());
            }
        }

        pw.close();
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
            st = null;
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