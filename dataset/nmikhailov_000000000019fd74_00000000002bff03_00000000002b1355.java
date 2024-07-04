import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nikita Mikhailov
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskC {
        private boolean keep(int[][] board, int x, int y) {
            long cnt = 0;
            long sum = 0;

            for (int i = x + 1; i < board.length; i++) {
                if (board[i][y] == -1) {
                    continue;
                }

                cnt++;
                sum += board[i][y];

                break;
            }

            for (int i = x - 1; i >= 0; i--) {
                if (board[i][y] == -1) {
                    continue;
                }

                cnt++;
                sum += board[i][y];

                break;
            }
            /// y
            for (int i = y + 1; i < board[0].length; i++) {
                if (board[x][i] == -1) {
                    continue;
                }

                cnt++;
                sum += board[x][i];

                break;
            }

            for (int i = y - 1; i >= 0; i--) {
                if (board[x][i] == -1) {
                    continue;
                }

                cnt++;
                sum += board[x][i];

                break;
            }

            return (board[x][y] * cnt) >= sum;
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {

            int r = in.readInt();
            int c = in.readInt();

            int[][] board = new int[r][c];
            int[][] boardNg = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    board[i][j] = in.readInt();
                }
            }

            long interest = 0;


            while (true) {
                boolean removedAny = false;
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        boardNg[i][j] = board[i][j];

                        if (board[i][j] == -1) {
                            continue;
                        }
                        interest += board[i][j];

                        if (!keep(board, i, j)) {
                            boardNg[i][j] = -1;
                            removedAny = true;
                        }
                    }
                }
                int[][] tmp = board;
                board = boardNg;
                boardNg = tmp;
                if (!removedAny) {
                    break;
                }

            }

            out.println("Case #" + testNumber + ": " + interest);
        }

    }

    static class FastScanner {
        private StringTokenizer st;
        private BufferedReader in;

        public FastScanner(final InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String readToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (final IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int readInt() {
            return Integer.parseInt(readToken());
        }

        public String next() {
            return readToken();
        }

    }
}

