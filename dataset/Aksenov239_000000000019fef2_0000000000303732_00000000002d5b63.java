import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
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

    Random rnd = new Random(239);
    int x0 = 0, y0 = 0;
    int R = 999999995;

    public int send(int x, int y) throws IOException {
//        System.err.println(x + " " + y + " " + (1L * x * x + 1L * y * y - 1L * R * R));
        out.println(x + " " + y);
        out.flush();

//        if (x == x0 && y == y0) {
//            return 0;
//        }
//        if (1L * (x - x0) * (x - x0) + 1L * (y - y0) * (y - y0) <= 1L * R * R) {
//            return 1;
//        }
//        return 2;

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
            ny = Math.min(Math.max(ny, -MAX), MAX);
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

//        System.err.println("HIT! " + px + " " + py);

        int[][] dd = new int[4][];
        for (int k = 0; k < 4; k++) {
            dd[k] = findDirection(px, py, k);
//            System.err.println("FOUND " + dd[k][0] + " " + dd[k][1]);
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
