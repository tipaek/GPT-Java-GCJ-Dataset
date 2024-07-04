import java.io.*;
import java.util.*;

public class Solution {

    private StreamTokenizer in;
    private PrintWriter out;

    public Solution(StreamTokenizer in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    private String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    private int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        Solution problem = new Solution(in, out);
        int T = problem.nextInt();
        for (int i = 1; i <= T; i++) {
            problem.solve(i);
        }
        out.flush();
        out.close();
    }

    private int N;

    private void solve(int T) throws IOException {
        N = nextInt();
        List<int[]> segments = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] segment = new int[]{nextInt(), nextInt(), i, 0};
            segments.add(segment);
        }
        segments.sort(Comparator.comparingInt(a -> a[0]));
        int prev = -1;
        for (int[] segment : segments) {
            if (prev <= segment[0]) {
                segment[3] = 1;
                prev = segment[1];
            }
        }
        prev = -1;
        for (int[] segment : segments) {
            if (segment[3] != 0) {
                continue;
            }
            if (segment[0] < prev) {
                out.println("Case #" + T + ": IMPOSSIBLE");
                return;
            }
            prev = segment[1];
        }

        segments.sort(Comparator.comparingInt(a -> a[2]));
        String output = segments.stream().map(a -> a[3] == 0 ? "J" : "C").reduce("", String::concat);
        out.println("Case #" + T + ": " + output);
    }


}
