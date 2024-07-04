import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class P2 {

    private static final int E92 = 1000000000 / 2;
    private static final int LIMIT = 1000000000;
    private static final int BUF = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int q = 1; q <= t; q++) {
            int curx = -1;
            int cury = -1;

            if (checkCenter(writer, reader, 0, E92)) continue;
            if (checkHit(writer, reader, 0, E92)) {
                curx = 0;
                cury = E92;
            }

            if (checkCenter(writer, reader, 0, -E92)) continue;
            if (checkHit(writer, reader, 0, -E92)) {
                curx = 0;
                cury = -E92;
            }

            if (checkCenter(writer, reader, E92, 0)) continue;
            if (checkHit(writer, reader, E92, 0)) {
                curx = E92;
                cury = 0;
            }

            if (checkCenter(writer, reader, -E92, 0)) continue;
            if (checkHit(writer, reader, -E92, 0)) {
                curx = -E92;
                cury = 0;
            }

            boolean found = false;

            // Binary search in four directions
            int ansUp = binarySearch(writer, reader, curx, cury, cury, LIMIT, true, found);
            if (found) continue;

            int ansDown = binarySearch(writer, reader, curx, cury, -LIMIT, cury, true, found);
            if (found) continue;

            int ansLeft = binarySearch(writer, reader, curx, cury, -LIMIT, curx, false, found);
            if (found) continue;

            int ansRight = binarySearch(writer, reader, curx, cury, curx, LIMIT, false, found);
            if (found) continue;

            int ansy = (ansUp + ansDown) / 2;
            int ansx = (ansLeft + ansRight) / 2;

            for (int k = ansx - BUF; k <= ansx + BUF; k++) {
                if (found) break;
                for (int j = ansy - BUF; j <= ansy + BUF; j++) {
                    if (!inBounds(k, j)) continue;
                    writer.println(k + " " + j);
                    writer.flush();

                    String response = reader.readLine();
                    if ("CENTER".equals(response)) {
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                writer.close();
                return;
            }
        }

        writer.close();
    }

    private static boolean checkCenter(PrintWriter writer, BufferedReader reader, int x, int y) throws IOException {
        writer.println(x + " " + y);
        writer.flush();
        return "CENTER".equals(reader.readLine());
    }

    private static boolean checkHit(PrintWriter writer, BufferedReader reader, int x, int y) throws IOException {
        writer.println(x + " " + y);
        writer.flush();
        return "HIT".equals(reader.readLine());
    }

    private static int binarySearch(PrintWriter writer, BufferedReader reader, int curx, int cury, int l, int r, boolean vertical, boolean found) throws IOException {
        int ans = vertical ? cury : curx;
        while (l != r) {
            int mid = l + (r - l) / 2;
            if (vertical) {
                writer.println(curx + " " + mid);
            } else {
                writer.println(mid + " " + cury);
            }
            writer.flush();

            String response = reader.readLine();
            if ("CENTER".equals(response)) {
                found = true;
                break;
            } else if ("HIT".equals(response)) {
                if (vertical) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                ans = mid;
            } else {
                if (vertical) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return ans;
    }

    private static boolean inBounds(int x, int y) {
        return x >= -LIMIT && x <= LIMIT && y >= -LIMIT && y <= LIMIT;
    }
}