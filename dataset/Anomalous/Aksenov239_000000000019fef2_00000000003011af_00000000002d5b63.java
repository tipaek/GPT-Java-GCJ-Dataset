import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static final int MAX = 1_000_000_000;
    private int A, B;

    private int send(int x, int y) throws IOException {
        out.println(x + " " + y);
        out.flush();
        switch (nextToken()) {
            case "CENTER":
                return 0;
            case "HIT":
                return 1;
            case "MISS":
                return 2;
            default:
                return -1;
        }
    }

    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    private int[] findDirection(int x, int y, int k) throws IOException {
        for (int i = 31; i >= 0; i--) {
            long nx = x + (1L << i) * dx[k];
            long ny = y + (1L << i) * dy[k];
            nx = Math.max(-MAX, Math.min(nx, MAX));
            ny = Math.max(-MAX, Math.min(ny, MAX));
            if (send((int) nx, (int) ny) == 1) {
                x = (int) nx;
                y = (int) ny;
            }
        }
        return new int[]{x, y};
    }

    private void solve() throws IOException {
        int px = 0, py = 0;
        outerLoop:
        for (int X = -MAX; X <= MAX; X += 200_000_000) {
            for (int Y = -MAX; Y <= MAX; Y += 200_000_000) {
                if (send(X, Y) == 1) {
                    px = X;
                    py = Y;
                    break outerLoop;
                }
            }
        }

        int[][] directions = new int[4][];
        for (int k = 0; k < 4; k++) {
            directions[k] = findDirection(px, py, k);
        }

        int centerX = (directions[0][0] + directions[2][0]) / 2;
        int centerY = (directions[1][1] + directions[3][1]) / 2;
        for (int X = -5; X < 5; X++) {
            for (int Y = -5; Y < 5; Y++) {
                if (send(centerX + X, centerY + Y) == 0) {
                    return;
                }
            }
        }
    }

    private void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            A = nextInt();
            B = nextInt();
            for (int i = 0; i < t; i++) {
                out.print(String.format("Case #%d: ", i + 1));
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}