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
                if ("HIT".equals(response)) {
                    hitx = dx[d] * MINR;
                    hity = dy[d] * MINR;
                    break;
                }
            }

            int L, R, MID;
            String response;

            // Check right
            L = 0;
            R = MAXR;
            while (L != R) {
                MID = (L + R) / 2;
                out.println((hitx + MID) + " " + hity);
                out.flush();
                response = input.readLine();
                if ("MISS".equals(response) || "WRONG".equals(response)) {
                    R = MID - 1;
                } else {
                    L = MID;
                }
            }
            int rightd = L + hitx;

            // Check left
            L = 0;
            R = MAXR;
            while (L != R) {
                MID = (L + R) / 2;
                out.println((hitx - MID) + " " + hity);
                out.flush();
                response = input.readLine();
                if ("MISS".equals(response) || "WRONG".equals(response)) {
                    R = MID - 1;
                } else {
                    L = MID;
                }
            }
            int leftd = hitx - L;

            // Check up
            L = 0;
            R = MAXR;
            while (L != R) {
                MID = (L + R) / 2;
                out.println(hitx + " " + (hity + MID));
                out.flush();
                response = input.readLine();
                if ("MISS".equals(response) || "WRONG".equals(response)) {
                    R = MID - 1;
                } else {
                    L = MID;
                }
            }
            int upd = L + hity;

            // Check down
            L = 0;
            R = MAXR;
            while (L != R) {
                MID = (L + R) / 2;
                out.println(hitx + " " + (hity - MID));
                out.flush();
                response = input.readLine();
                if ("MISS".equals(response) || "WRONG".equals(response)) {
                    R = MID - 1;
                } else {
                    L = MID;
                }
            }
            int downd = hity - L;

            int avgx = (rightd + leftd) / 2;
            int avgy = (upd + downd) / 2;

            int[] dx2 = {0, 1, -1, 0, 0, 1, 1, -1, -1};
            int[] dy2 = {0, 0, 0, 1, -1, 1, -1, 1, -1};

            for (int d = 0; d < dx2.length; d++) {
                out.println((avgx + dx2[d]) + " " + (avgy + dy2[d]));
                out.flush();
                response = input.readLine();
                if ("CENTER".equals(response)) {
                    break;
                }
            }
        }
        out.flush();
        out.close();
    }
}