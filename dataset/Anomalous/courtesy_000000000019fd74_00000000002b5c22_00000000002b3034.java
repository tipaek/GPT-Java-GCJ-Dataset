import java.io.*;
import java.util.*;

public class Solution {
    public static FastReader fr = new FastReader();
    public static OutputWriter op = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int T = fr.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = fr.nextInt();
            String[] ss = new String[N];
            for (int i = 0; i < N; i++) {
                ss[i] = fr.next();
            }

            System.out.print("Case #" + cs + ": ");

            boolean prefixMismatch = false;
            StringBuilder prefix = new StringBuilder();
            for (String s : ss) {
                for (int j = 0; j < s.length() && j < prefix.length(); j++) {
                    if (s.charAt(j) == '*') break;
                    if (s.charAt(j) != prefix.charAt(j)) {
                        prefixMismatch = true;
                        break;
                    }
                }
                if (prefixMismatch) break;

                for (int j = prefix.length(); j < s.length() && s.charAt(j) != '*'; j++) {
                    prefix.append(s.charAt(j));
                }
            }
            if (prefixMismatch) {
                System.out.println("*");
                continue;
            }

            boolean suffixMismatch = false;
            StringBuilder suffix = new StringBuilder();
            for (String s : ss) {
                for (int j = s.length() - 1, k = 0; j >= 0 && k < suffix.length(); j--, k++) {
                    if (s.charAt(j) == '*') break;
                    if (s.charAt(j) != suffix.charAt(k)) {
                        suffixMismatch = true;
                        break;
                    }
                }
                if (suffixMismatch) break;

                for (int j = s.length() - 1 - suffix.length(); j >= 0 && s.charAt(j) != '*'; j--) {
                    suffix.append(s.charAt(j));
                }
            }
            if (suffixMismatch) {
                System.out.println("*");
                continue;
            }

            List<StringBuilder> middleParts = new ArrayList<>();
            for (String s : ss) {
                String[] parts = s.split("\\*");
                int limit = s.endsWith("*") ? parts.length : parts.length - 1;
                for (int j = 1; j < limit; j++) {
                    if (j - 1 < middleParts.size()) {
                        middleParts.get(j - 1).append(parts[j]);
                    } else {
                        middleParts.add(new StringBuilder(parts[j]));
                    }
                }
            }

            StringBuilder result = new StringBuilder(prefix);
            for (StringBuilder part : middleParts) {
                result.append(part);
            }
            result.append(suffix.reverse());

            System.out.println(result.toString());
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

    static class FastReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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