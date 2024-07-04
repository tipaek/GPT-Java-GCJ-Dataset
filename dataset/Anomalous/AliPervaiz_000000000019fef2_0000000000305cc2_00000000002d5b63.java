import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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
            int MINR = 500000000;
            int MAXR = MINR * 2;
            int hitx = 0;
            int hity = 0;

            for (int d = 0; d < 5; d++) {
                out.println((dx[d] * MINR) + " " + (dy[d] * MINR));
                out.flush();
                String s = input.readLine();
                if (s.equals("HIT")) {
                    hitx = dx[d] * MINR;
                    hity = dy[d] * MINR;
                    break;
                }
            }

            int rightd = findBoundary(out, input, hitx, hity, MAXR, true, true);
            int leftd = findBoundary(out, input, hitx, hity, MAXR, true, false);
            int upd = findBoundary(out, input, hitx, hity, MAXR, false, true);
            int downd = findBoundary(out, input, hitx, hity, MAXR, false, false);

            int avgx = (rightd + leftd) / 2;
            int avgy = (upd + downd) / 2;

            int[] dx2 = {0, 1, -1, 0, 0, 1, 1, -1, -1};
            int[] dy2 = {0, 0, 0, 1, -1, 1, -1, 1, -1};

            for (int d = 0; d < dx2.length; d++) {
                out.println((avgx + dx2[d]) + " " + (avgy + dy2[d]));
                out.flush();
                String s = input.readLine();
                if (s.equals("CENTER")) {
                    break;
                }
            }
        }

        out.flush();
        out.close();
    }

    private static int findBoundary(PrintWriter out, BufferedReader input, int hitx, int hity, int MAXR, boolean isX, boolean isPositive) throws IOException {
        int L = 0;
        int R = MAXR;

        while (L != R) {
            int MID = (L + R) / 2;
            long newCoord = isPositive ? (isX ? hitx + (long) MID : hity + (long) MID) : (isX ? hitx - (long) MID : hity - (long) MID);

            if ((isX && (newCoord > 2000000000 || newCoord < -2000000000)) || (!isX && (newCoord > 2000000000 || newCoord < -2000000000))) {
                R = MID - 1;
                continue;
            }

            out.println((isX ? newCoord : hitx) + " " + (isX ? hity : newCoord));
            out.flush();
            String s = input.readLine();

            if (s.equals("MISS") || s.equals("WRONG")) {
                R = MID - 1;
            } else {
                L = MID;
            }
        }

        return isPositive ? L + (isX ? hitx : hity) : (isX ? hitx : hity) - L;
    }
}