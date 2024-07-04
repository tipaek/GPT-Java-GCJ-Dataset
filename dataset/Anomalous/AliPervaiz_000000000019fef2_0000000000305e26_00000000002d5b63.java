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
                String response = input.readLine();
                if (response.equals("HIT")) {
                    hitx = dx[d] * MINR;
                    hity = dy[d] * MINR;
                    break;
                }
            }

            int rightd = binarySearch(hitx, hity, MAXR, 1, 0, out, input);
            int leftd = binarySearch(hitx, hity, MAXR, -1, 0, out, input);
            int upd = binarySearch(hitx, hity, MAXR, 0, 1, out, input);
            int downd = binarySearch(hitx, hity, MAXR, 0, -1, out, input);

            int avgx = (rightd + leftd) / 2;
            int avgy = (upd + downd) / 2;

            int[] dx2 = {0, 1, -1, 0, 0, 1, 1, -1, -1};
            int[] dy2 = {0, 0, 0, 1, -1, 1, -1, 1, -1};

            for (int d = 0; d < dx2.length; d++) {
                out.println((avgx + dx2[d]) + " " + (avgy + dy2[d]));
                out.flush();
                String response = input.readLine();
                if (response.equals("CENTER")) {
                    break;
                }
            }
        }

        out.flush();
        out.close();
    }

    private static int binarySearch(int hitx, int hity, int maxRange, int dx, int dy, PrintWriter out, BufferedReader input) throws IOException {
        int L = 0;
        int R = maxRange;
        while (L < R) {
            int MID = (L + R) / 2;
            long newX = hitx + (long) dx * MID;
            long newY = hity + (long) dy * MID;

            if (newX > 2000000000 || newX < -2000000000 || newY > 2000000000 || newY < -2000000000) {
                R = MID - 1;
                continue;
            }

            out.println(newX + " " + newY);
            out.flush();
            String response = input.readLine();
            if (response.equals("MISS") || response.equals("WRONG")) {
                R = MID - 1;
            } else {
                L = MID;
            }
        }
        return hitx + dx * L;
    }
}