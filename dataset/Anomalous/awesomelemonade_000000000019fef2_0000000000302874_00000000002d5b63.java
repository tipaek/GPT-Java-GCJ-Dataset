import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        final long BOUND = 2000000000L;
        final long DIAMETER = 1000000000L;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());

        for (int t = 0; t < testCases; t++) {
            long left = 0, right = BOUND;
            long top = 0, bottom = BOUND;

            while (true) {
                long rangeX = right - left;
                long rangeY = bottom - top;
                long quarterX = (rangeX + 3) / 4; // round up
                long quarterY = (rangeY + 3) / 4;
                long midX = left + rangeX / 2;
                long midY = top + rangeY / 2;

                String responseA = query(reader, writer, left + quarterX, midY);
                if (responseA.equals("CENTER")) break;
                if (responseA.equals("WRONG")) throw new IllegalStateException();

                if (responseA.equals("HIT")) {
                    right = left + quarterX + DIAMETER;
                    continue;
                }

                String responseB = query(reader, writer, right - quarterX, midY);
                if (responseB.equals("CENTER")) break;
                if (responseB.equals("WRONG")) throw new IllegalStateException();

                if (responseB.equals("HIT")) {
                    left = right - quarterX - DIAMETER;
                    continue;
                }

                String responseC = query(reader, writer, midX, top + quarterY);
                if (responseC.equals("CENTER")) break;
                if (responseC.equals("WRONG")) throw new IllegalStateException();

                if (responseC.equals("HIT")) {
                    bottom = top + quarterY + DIAMETER;
                    continue;
                }

                String responseD = query(reader, writer, midX, bottom - quarterY);
                if (responseD.equals("CENTER")) break;
                if (responseD.equals("WRONG")) throw new IllegalStateException();

                if (responseD.equals("HIT")) {
                    top = bottom - quarterY - DIAMETER;
                }
            }
        }
    }

    private static String query(BufferedReader reader, PrintWriter writer, long x, long y) throws Exception {
        writer.println(x + " " + y);
        writer.flush();
        return reader.readLine();
    }
}