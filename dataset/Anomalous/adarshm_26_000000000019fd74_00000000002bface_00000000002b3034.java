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

            boolean foundConflict = false;
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            List<String> middleParts = new ArrayList<>();

            for (String pattern : patterns) {
                if (foundConflict) break;

                int firstStar = pattern.indexOf('*');
                int lastStar = pattern.lastIndexOf('*');

                StringBuilder currentPrefix = new StringBuilder(pattern.substring(0, firstStar));
                StringBuilder currentSuffix = new StringBuilder(pattern.substring(lastStar + 1)).reverse();

                if (!isCompatible(prefix, currentPrefix)) {
                    foundConflict = true;
                    break;
                }

                if (prefix.length() < currentPrefix.length()) {
                    prefix = currentPrefix;
                }

                if (!isCompatible(suffix, currentSuffix)) {
                    foundConflict = true;
                    break;
                }

                if (suffix.length() < currentSuffix.length()) {
                    suffix = currentSuffix;
                }

                String middlePart = pattern.substring(firstStar + 1, lastStar).replace("*", "");
                middleParts.add(middlePart);
            }

            if (foundConflict) {
                pw.println("Case #" + x + ": *");
            } else {
                StringBuilder result = new StringBuilder();
                result.append(prefix);
                for (String middlePart : middleParts) {
                    result.append(middlePart);
                }
                result.append(suffix.reverse());
                pw.println("Case #" + x + ": " + result.toString());
            }
        }
        pw.close();
    }

    private static boolean isCompatible(StringBuilder a, StringBuilder b) {
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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