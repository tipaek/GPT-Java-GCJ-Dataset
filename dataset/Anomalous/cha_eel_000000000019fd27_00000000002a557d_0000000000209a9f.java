import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int test = 10; // 0 for local testing, 1 for std input
    static BufferedReader in;
    static PrintWriter out = new PrintWriter(System.out);
    static String file = "../in";
    static int inf = 1_000_000;

    static int readInt() throws Exception {
        return Integer.parseInt(in.readLine());
    }

    public static void main(String[] args) throws Exception {
        if (test > 0) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(file));
        }

        int t = readInt();

        for (int tt = 1; tt <= t; tt++) {
            String str = in.readLine();
            int n = str.length();
            Queue<Integer> q1 = new LinkedList<>();
            Queue<String> q2 = new LinkedList<>();

            for (char c : str.toCharArray()) {
                int val = c - '0';
                q1.offer(val);
                q2.offer(String.valueOf(c));
            }

            for (int i = 9; i >= 1; i--) {
                Queue<Integer> q3 = new LinkedList<>();
                Queue<String> q4 = new LinkedList<>();

                while (!q1.isEmpty()) {
                    if (q1.peek() < i) {
                        q3.offer(q1.poll());
                        q4.offer(q2.poll());
                    } else {
                        StringBuilder ss = new StringBuilder();
                        while (!q1.isEmpty() && q1.peek() == i) {
                            q1.poll();
                            ss.append(q2.poll());
                        }
                        q3.offer(i - 1);
                        q4.offer("(" + ss.toString() + ")");
                    }
                }
                q1 = q3;
                q2 = q4;
            }

            StringBuilder result = new StringBuilder();
            while (!q2.isEmpty()) {
                result.append(q2.poll());
            }
            out.printf("Case #%d: %s\n", tt, result.toString());
        }

        out.flush();
    }
}