import java.io.*;
import java.util.*;

public class Solution {
    static final int TEST_MODE = 1; // 0 for local testing, 1 for standard input
    static final String FILE_PATH = "../in";
    static final int INF = 1_000_000;

    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        if (TEST_MODE > 0) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(FILE_PATH));
        }

        int t = readInt();

        for (int tt = 1; tt <= t; tt++) {
            String str = in.readLine();
            int n = str.length();
            Deque<Integer> q1 = new ArrayDeque<>();
            Deque<String> q2 = new ArrayDeque<>();

            for (char c : str.toCharArray()) {
                int val = c - '0';
                q1.offerLast(val);
                q2.offerLast(String.valueOf(c));
            }

            for (int i = 9; i >= 1; i--) {
                Deque<Integer> q3 = new ArrayDeque<>();
                Deque<String> q4 = new ArrayDeque<>();

                while (!q1.isEmpty()) {
                    if (q1.peekFirst() < i) {
                        q3.offerLast(q1.pollFirst());
                        q4.offerLast(q2.pollFirst());
                    } else {
                        StringBuilder ss = new StringBuilder();
                        while (!q1.isEmpty() && q1.peekFirst() == i) {
                            q1.pollFirst();
                            ss.append(q2.pollFirst());
                        }
                        q3.offerLast(i - 1);
                        q4.offerLast("(" + ss + ")");
                    }
                }
                q1 = q3;
                q2 = q4;
            }

            StringBuilder result = new StringBuilder();
            while (!q2.isEmpty()) {
                result.append(q2.pollFirst());
            }
            out.printf("Case #%d: %s\n", tt, result.toString());
        }
        out.flush();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(in.readLine());
    }
}