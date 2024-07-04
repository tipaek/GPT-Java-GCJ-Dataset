import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int T = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        final long MINR = 500000000;
        final long MAXR = MINR * 2;

        while (T-- > 0) {
            long hitx = 0, hity = 0;
            long[] dx = {0, 1, -1, 0, 0};
            long[] dy = {0, 0, 0, 1, -1};

            for (int d = 0; d < 5; d++) {
                out.println(dx[d] * MINR + " " + dy[d] * MINR);
                out.flush();
                String response = input.readLine();
                if ("HIT".equals(response)) {
                    hitx = dx[d] * MINR;
                    hity = dy[d] * MINR;
                    break;
                }
            }

            long rightd = findBoundary(out, input, hitx, hity, MAXR, true, true);
            long leftd = findBoundary(out, input, hitx, hity, MAXR, false, true);
            long upd = findBoundary(out, input, hitx, hity, MAXR, true, false);
            long downd = findBoundary(out, input, hitx, hity, MAXR, false, false);

            long avgx = (rightd + leftd) / 2;
            long avgy = (upd + downd) / 2;

            long[] dx2 = {0, 1, -1, 0, 0, 1, 1, -1, -1};
            long[] dy2 = {0, 0, 0, 1, -1, 1, -1, 1, -1};

            outerLoop:
            for (int dir = 1; dir <= 2; dir++) {
                for (int d = 0; d < dx2.length; d++) {
                    out.println((avgx + dx2[d] * dir) + " " + (avgy + dy2[d] * dir));
                    out.flush();
                    String response = input.readLine();
                    if ("CENTER".equals(response)) {
                        break outerLoop;
                    }
                }
            }
        }
        out.flush();
        out.close();
    }

    private static long findBoundary(PrintWriter out, BufferedReader input, long hitx, long hity, long maxr, boolean positive, boolean horizontal) throws IOException {
        long L = 0, R = maxr;
        while (L < R) {
            long MID = (L + R) / 2;
            long newX = horizontal ? (positive ? hitx + MID : hitx - MID) : hitx;
            long newY = horizontal ? hity : (positive ? hity + MID : hity - MID);
            if (newX > 2000000000 || newX < -2000000000 || newY > 2000000000 || newY < -2000000000) {
                R = MID - 1;
                continue;
            }
            out.println(newX + " " + newY);
            out.flush();
            String response = input.readLine();
            if ("MISS".equals(response) || "WRONG".equals(response)) {
                R = MID - 1;
            } else {
                L = MID;
            }
        }
        return horizontal ? (positive ? L + hitx : hitx - L) : (positive ? L + hity : hity - L);
    }
}