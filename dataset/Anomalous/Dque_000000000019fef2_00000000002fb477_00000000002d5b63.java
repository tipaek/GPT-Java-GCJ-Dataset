import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    
    private static final int HALF_MAX = 1000000000 / 2;
    private static final int MAX_COORD = 1000000000;
    private static final int MIN_COORD = -1000000000;
    private static final int BUF = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int t = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int q = 1; q <= t; q++) {
            int curX = -1, curY = -1;

            curX = checkHit(reader, writer, 0, HALF_MAX);
            if (curX == -1) continue;

            curY = checkHit(reader, writer, 0, -HALF_MAX);
            if (curY == -1) continue;

            curX = checkHit(reader, writer, HALF_MAX, 0);
            if (curX == -1) continue;

            curY = checkHit(reader, writer, -HALF_MAX, 0);
            if (curY == -1) continue;

            if (binarySearch(reader, writer, curX, curY, true)) continue;
            if (binarySearch(reader, writer, curX, curY, false)) continue;

            int ansY = (binarySearch(reader, writer, curX, curY, true) + binarySearch(reader, writer, curX, curY, false)) / 2;
            int ansX = (binarySearch(reader, writer, curX, curY, false) + binarySearch(reader, writer, curX, curY, true)) / 2;

            if (!findCenter(reader, writer, ansX, ansY)) {
                writer.close();
                return;
            }
        }

        writer.close();
    }

    private static int checkHit(BufferedReader reader, PrintWriter writer, int x, int y) throws IOException {
        writer.println(x + " " + y);
        writer.flush();
        String response = reader.readLine();
        if (response.equals("CENTER")) return -1;
        return response.equals("HIT") ? x : -1;
    }

    private static boolean binarySearch(BufferedReader reader, PrintWriter writer, int curX, int curY, boolean isVertical) throws IOException {
        int l = isVertical ? curY : MIN_COORD;
        int r = isVertical ? MAX_COORD : curX;
        int ans = isVertical ? curY : curX;

        while (l != r) {
            int mid = l + (r - l) / 2;
            writer.println((isVertical ? curX : mid) + " " + (isVertical ? mid : curY));
            writer.flush();
            String response = reader.readLine();
            if (response.equals("CENTER")) return true;
            if (response.equals("HIT")) {
                if (isVertical) l = mid + 1;
                else r = mid - 1;
                ans = mid;
            } else {
                if (isVertical) r = mid - 1;
                else l = mid + 1;
            }
        }
        return false;
    }

    private static boolean findCenter(BufferedReader reader, PrintWriter writer, int ansX, int ansY) throws IOException {
        for (int x = ansX - BUF; x <= ansX + BUF; x++) {
            for (int y = ansY - BUF; y <= ansY + BUF; y++) {
                writer.println(x + " " + y);
                writer.flush();
                if (reader.readLine().equals("CENTER")) return true;
            }
        }
        return false;
    }
}