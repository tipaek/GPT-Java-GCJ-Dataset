import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
        long X = nextInt();
        long Y = nextInt();
        StringBuilder sb = new StringBuilder();
        boolean solvable = stepOnce(X, Y, sb);
        if (solvable) {
            out.println("Case #" + T + ": " + sb.toString());
        } else {
            out.println("Case #" + T + ": IMPOSSIBLE");
        }

    }

    private boolean stepOnce(long x, long y, StringBuilder sb) {
        if (x == 0 && y == 1) {
            sb.append('N');
            return true;
        }
        if (x == 0 && y == -1) {
            sb.append('S');
            return true;
        }
        if (x == 1 && y == 0) {
            sb.append('E');
            return true;
        }
        if (x == -1 && y == 0) {
            sb.append('W');
            return true;
        }
        if ((x + y) % 2 == 0) {
            return false;
        }
        if (x % 2 != 0) {
            if ((((x - 1) + y) / 2) % 2 != 0) {
                sb.append('E');
                return stepOnce((x - 1) / 2, y / 2, sb);
            } else {
                sb.append('W');
                return stepOnce((x + 1) / 2, y / 2, sb);
            }
        } else {
            if (((x + (y - 1)) / 2) % 2 != 0) {
                sb.append('N');
                return stepOnce(x / 2, (y - 1) / 2, sb);
            } else {
                sb.append('S');
                return stepOnce(x / 2, (y + 1) / 2, sb);
            }
        }
    }


}
