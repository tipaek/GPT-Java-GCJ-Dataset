import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int t = in.nextInt();
        for (int q = 1; q <= t; q++) {
            int n = in.nextInt();
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strings.add(in.next());
            }
            Collections.sort(strings, Comparator.comparingInt(String::length));
            Collections.reverse(strings);
            StringBuilder res = new StringBuilder();
            if (b(strings) && e(strings)) {
                for (char c : strings.get(0).toCharArray()) {
                    if (c != '*') {
                        res.append(c);
                    }
                }
            } else {
                res.append("*");
            }

            out.println(get(q, res));
        }
        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    static boolean b(ArrayList<String> strings) {
        boolean found = true;
        if (strings.get(0).split("\\*").length == 2) {
            String max = strings.get(0).split("\\*")[1];
            for (int i = 1; i < strings.size(); i++) {
                if (strings.get(i).split("\\*").length == 2) {
                    String end = strings.get(i).split("\\*")[1];
                    if (max.endsWith(end)) {
                        continue;
                    } else {
                        found = false;
                        return found;
                    }
                }
            }
        }
        return found;
    }

    static boolean e(ArrayList<String> strings) {
        boolean found = true;
        String max = strings.get(0).split("\\*")[0];
        for (int i = 1; i < strings.size(); i++) {
            String end = strings.get(i).split("\\*")[0];
            if (max.startsWith(end)) {
                continue;
            } else {
                found = false;
                return found;
            }
        }
        return found;
    }

    static String commonPrefix(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0 && a.charAt(i) == b.charAt(j) && a.charAt(i) != '*' && b.charAt(j) != '*') {
            res.append(a.charAt(i));
            i--;
            j--;
        }
        return res.reverse().toString();
    }

    static String get(Object... args) {
        String res = "Case #" + args[0] + ":";
        for (int i = 1; i < args.length; i++) {
            res += " ";
            res += args[i];
        }
        return res;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void exit(int a) {
        out.close();
        err.close();
        System.exit(a);
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static OutputStream errStream = System.err;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    static PrintWriter err = new PrintWriter(errStream);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
