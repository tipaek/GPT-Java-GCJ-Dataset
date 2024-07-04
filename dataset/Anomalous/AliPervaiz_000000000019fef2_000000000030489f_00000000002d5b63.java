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

        while (T-- > 0) {
            int[] dx = {0, 1, -1, 0, 0};
            int[] dy = {0, 0, 0, 1, -1};
            final int MINR = 500000000;
            final int MAXR = MINR * 2;
            int hitx = 0, hity = 0;

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

            int rightd = binarySearch(hitx, hity, MAXR, true, out, input, true);
            int leftd = binarySearch(hitx, hity, MAXR, true, out, input, false);
            int upd = binarySearch(hitx, hity, MAXR, false, out, input, true);
            int downd = binarySearch(hitx, hity, MAXR, false, out, input, false);

            int avgx = (rightd + leftd) / 2;
            int avgy = (upd + downd) / 2;

            int[] dx2 = {0, 1, -1, 0, 0, 1, 1, -1, -1};
            int[] dy2 = {0, 0, 0, 1, -1, 1, -1, 1, -1};

            for (int d = 0; d < dx2.length; d++) {
                out.println((avgx + dx2[d]) + " " + (avgy + dy2[d]));
                out.flush();
                String response = input.readLine();
                if ("CENTER".equals(response)) {
                    break;
                }
            }
        }

        out.flush();
        out.close();
    }

    private static int binarySearch(int hitx, int hity, int maxRange, boolean isHorizontal, PrintWriter out, BufferedReader input, boolean isPositive) throws IOException {
        int L = 0, R = maxRange;
        while (L != R) {
            int MID = (L + R) / 2;
            int x = isHorizontal ? (isPositive ? hitx + MID : hitx - MID) : hitx;
            int y = isHorizontal ? hity : (isPositive ? hity + MID : hity - MID);
            out.println(x + " " + y);
            out.flush();
            String response = input.readLine();
            if ("MISS".equals(response) || "WRONG".equals(response)) {
                R = MID - 1;
            } else {
                L = MID;
            }
        }
        return isHorizontal ? (isPositive ? L + hitx : hitx - L) : (isPositive ? L + hity : hity - L);
    }
}