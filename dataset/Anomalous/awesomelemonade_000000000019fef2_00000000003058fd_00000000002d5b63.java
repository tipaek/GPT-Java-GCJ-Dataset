import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    private static final long BOUND = 1_000_000_000L;
    private static final long DIAMETER = 1_000_000_000L;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());

        for (int t = 0; t < testCases; t++) {
            long left = -BOUND;
            long right = BOUND;
            long top = -BOUND;
            long bottom = BOUND;

            while (true) {
                long rangeX = right - left;
                long rangeY = bottom - top;
                long quarterX = (rangeX + 3) / 4;
                long quarterY = (rangeY + 3) / 4;
                long midX = left + rangeX / 2;
                long midY = top + rangeY / 2;

                long newLeft = left;
                long newRight = right;
                long newTop = top;
                long newBottom = bottom;

                if (processQuery(reader, writer, left + quarterX, midY, new long[]{newLeft, newRight}, true)) break;
                if (processQuery(reader, writer, right - quarterX, midY, new long[]{newLeft, newRight}, false)) break;
                if (processQuery(reader, writer, midX, top + quarterY, new long[]{newTop, newBottom}, true)) break;
                if (processQuery(reader, writer, midX, bottom - quarterY, new long[]{newTop, newBottom}, false)) break;

                left = newLeft;
                right = newRight;
                top = newTop;
                bottom = newBottom;

                if (isHit(reader, writer, midX, midY)) break;
            }
        }
    }

    private static boolean processQuery(BufferedReader reader, PrintWriter writer, long x, long y, long[] bounds, boolean isFirstHalf) throws Exception {
        String response = query(reader, writer, x, y);
        if (response.equals("CENTER")) return true;
        if (response.equals("WRONG")) throw new IllegalStateException("Invalid coordinates: " + x + " " + y);

        if (response.equals("HIT")) {
            if (isFirstHalf) {
                bounds[1] = x + DIAMETER;
            } else {
                bounds[0] = x - DIAMETER;
            }
        }
        return false;
    }

    private static boolean isHit(BufferedReader reader, PrintWriter writer, long x, long y) throws Exception {
        return query(reader, writer, x, y).equals("CENTER");
    }

    private static String query(BufferedReader reader, PrintWriter writer, long x, long y) throws Exception {
        writer.println(x + " " + y);
        writer.flush();
        return reader.readLine();
    }
}