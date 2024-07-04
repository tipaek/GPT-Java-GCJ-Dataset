import java.io.*;
import java.util.HashSet;
import java.util.Set;

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
    int[][] a;

    private void solve(int T) throws IOException {
        N = nextInt();
        a = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = nextInt();
            }
        }
        int trace = 0;
        for (int i = 0; i < N; i++) {
            trace += a[i][i];
        }
        Set<Integer> hash;
        int rows = 0;
        int columns = 0;

        for (int i = 0; i < N; i++) {
            hash = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (hash.contains(a[i][j])) {
                    rows++;
                    break;
                }
                hash.add(a[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            hash = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (hash.contains(a[j][i])) {
                    columns++;
                    break;
                }
                hash.add(a[j][i]);
            }
        }
        out.println("Case #" + T + ": " + trace + " " + rows + " " + columns);

    }




}
