import java.io.*;
import java.util.*;

public class Solution {
    private BufferedReader in;
    private StringTokenizer tokenizer;
    private Map<Integer, Integer> map = new HashMap<>();
    private List<Integer> integerList = new ArrayList<>();
    private List<Long> longList = new ArrayList<>();

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            int testCases = nextInt();
            for (int i = 0; i < testCases; i++) {
                String input = nextLine();
                StringBuilder output = new StringBuilder();
                int depth = 0;

                for (char ch : input.toCharArray()) {
                    int num = ch - '0';
                    while (num > depth) {
                        output.append("(");
                        depth++;
                    }
                    while (num < depth) {
                        output.append(")");
                        depth--;
                    }
                    output.append(ch);
                }
                while (depth > 0) {
                    output.append(")");
                    depth--;
                }
                System.out.println("Case #" + (i + 1) + ": " + output.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine().trim());
        }
        return tokenizer.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private String nextLine() throws IOException {
        return in.readLine().trim();
    }
}