import java.io.*;
import java.util.*;

public class PatternMatchingCodeJam {
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

            String prefix = "";
            String suffix = "";
            List<String> middleParts = new ArrayList<>();
            boolean isInvalid = false;

            for (String pattern : patterns) {
                int firstStar = pattern.indexOf('*');
                int lastStar = pattern.lastIndexOf('*');

                String currentPrefix = pattern.substring(0, firstStar);
                String currentSuffix = new StringBuilder(pattern.substring(lastStar + 1)).reverse().toString();
                String middlePart = pattern.substring(firstStar + 1, lastStar).replace("*", "");

                if (!prefix.startsWith(currentPrefix) && !currentPrefix.startsWith(prefix)) {
                    isInvalid = true;
                    break;
                }
                if (!suffix.startsWith(currentSuffix) && !currentSuffix.startsWith(suffix)) {
                    isInvalid = true;
                    break;
                }

                if (currentPrefix.length() > prefix.length()) {
                    prefix = currentPrefix;
                }
                if (currentSuffix.length() > suffix.length()) {
                    suffix = currentSuffix;
                }

                middleParts.add(middlePart);
            }

            if (isInvalid) {
                pw.println("Case #" + x + ": *");
            } else {
                StringBuilder result = new StringBuilder(prefix);
                for (String middlePart : middleParts) {
                    result.append(middlePart);
                }
                result.append(new StringBuilder(suffix).reverse().toString());
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