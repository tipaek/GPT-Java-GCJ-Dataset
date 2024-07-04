import java.io.*;
import java.util.*;

public class Solution {

    public void solve() {
        int ntest = reader.nextInt();
        for (int test = 1; test <= ntest; test++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            String s = reader.nextToken();
            String answer = find(x, y, s);
            writer.printf("Case #%d: %s\n", test, answer);
        }
//        writer.println(find(4, 4, "SSSS"));
    }

    private String find(int x, int y, String s) {
        if (x == 0 && y == 0) return "0";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'N': y++;
                case 'S': y--;
                case 'E': x++;
                case 'W': x--;
            }
            int steps = i + 1;
            if (can(x, y, steps)) return Integer.toString(steps);
        }

        return "IMPOSSIBLE";
    }

    private boolean can(int x, int y, int steps) {
        int moves = Math.abs(x) + Math.abs(y);
        boolean res = moves <= steps;
//        writer.println("can " + x + " " + y + " " + steps + " -> " + res);
        return res;
    }

    private InputReader reader;
    private PrintWriter writer;

    public Solution(InputReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        Solution solution = new Solution(reader, writer);
        solution.solve();

        writer.flush();
    }

    static class InputReader {
        private static final int BUFFER_SIZE = 1 << 20;

        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), BUFFER_SIZE);
            tokenizer = null;
        }

        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }
    }
}

