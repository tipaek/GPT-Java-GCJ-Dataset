import java.io.*;
import java.util.*;

public class Solution {
    static InputStream inputStream;
    static PrintWriter out;
    static InputReader in;
    static int test;

    static void solve() throws Exception {
        StringBuilder result = new StringBuilder();
        List<List<String>> list = new ArrayList<>();
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            List<String> tmp = new ArrayList<>(Arrays.asList(("_" + in.next() + "_").split("\\*")));
            list.add(tmp);
        }

        String start = "";
        StringBuilder middle = new StringBuilder();
        String finish = "";

        for (int i = 0; i < N; i++) {
            String currentStart = list.get(i).get(0);
            if (start.isEmpty() || currentStart.contains(start) || start.contains(currentStart)) {
                if (currentStart.length() > start.length()) {
                    start = currentStart;
                }
            } else {
                out.println("*");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            int index = list.get(i).size() - 1;
            String currentFinish = list.get(i).get(index);
            if (finish.isEmpty() || currentFinish.contains(finish) || finish.contains(currentFinish)) {
                if (currentFinish.length() > finish.length()) {
                    finish = currentFinish;
                }
            } else {
                out.println("*");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < list.get(i).size() - 1; j++) {
                middle.append(list.get(i).get(j));
            }
        }

        out.println(start.substring(1) + middle.toString() + finish.substring(0, finish.length() - 1));
    }

    static int getVal(int row, int col) {
        return col == 0 ? 1 : row;
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    public static void main(String[] args) {
        try {
            inputStream = System.in;
            out = new PrintWriter(System.out);
            in = new InputReader(inputStream);

            int tests = in.nextInt();
            for (test = 1; test <= tests; test++) {
                printCase();
                solve();
            }
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
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
                    String str = reader.readLine();
                    if (str == null)
                        return "";
                    tokenizer = new StringTokenizer(str);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}