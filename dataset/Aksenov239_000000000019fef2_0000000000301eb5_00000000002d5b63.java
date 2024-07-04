import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by vaksenov on 04.04.2020.
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    int A, B;
    int MAX = 1_000_000_000;

    public int send(int x, int y) throws IOException {
        out.println(x + " " + y);
        out.flush();
        String result = nextToken();
        switch (result) {
            case "CENTER":
                return 0;
            case "HIT":
                return 1;
            case "MISS":
                return 2;
        }
        return -1;
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    int[] findDirection(int x, int y, int k) throws IOException {
        for (int i = 31; i >= 0; i--) {
            long nx = x + (1L << i) * dx[k];
            long ny = y + (1L << i) * dy[k];
            nx = Math.min(Math.max(nx, -MAX), MAX);
            ny = Math.min(Math.min(ny, -MAX), MAX);
            int type = send((int) nx, (int) ny);
            if (type == 1) {
                x = (int) nx;
                y = (int) ny;
            }
        }
        return new int[]{x, y};
    }

    public void solve() throws IOException {
        int px = 0, py = 0;
        for (int X = -MAX; X <= MAX; X += 200_000_000) {
            for (int Y = -MAX; Y <= MAX; Y += 200_000_000) {
                int type = send(X, Y);
                if (type == 1) {
                    px = X;
                    py = Y;
                    break;
                }
            }
        }

        int[][] dd = new int[4][];
        for (int k = 0; k < 4; k++) {
            dd[k] = findDirection(px, py, k);
        }

        int ppx = (dd[0][0] + dd[2][0]) / 2;
        int ppy = (dd[1][1] + dd[3][1]) / 2;
        for (int X = -5; X < 5; X++) {
            for (int Y = -5; Y < 5; Y++){
                if (send(ppx + X, ppy + Y) == 0) {
                    return;
                }
            }
        }
        throw new AssertionError();
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            A = nextInt();
            B = nextInt();
            for (int i = 0; i < t; i++) {
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
