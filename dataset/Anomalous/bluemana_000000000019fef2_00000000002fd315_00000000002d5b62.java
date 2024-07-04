import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Solution {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             Writer writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            process(reader, writer);
        }
    }

    private static void process(BufferedReader reader, Writer writer) throws Exception {
        int numberOfTests = Integer.parseInt(reader.readLine());
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            handleTestCase(testIndex, reader, writer);
        }
    }

    private static void handleTestCase(int testIndex, BufferedReader reader, Writer writer) throws Exception {
        String[] input = reader.readLine().split(" ");
        long x = Long.parseLong(input[0]);
        long y = Long.parseLong(input[1]);
        String result = computePath(x, y);
        writer.write(String.format("Case #%d: %s\n", testIndex + 1, result == null ? "IMPOSSIBLE" : result));
        writer.flush();
    }

    private static String computePath(long x, long y) {
        long distance = Math.abs(x) + Math.abs(y);
        long maxJump = (int) (Math.log(distance * 2) / Math.log(2));
        StringBuilder path = new StringBuilder();

        while (maxJump > 0) {
            long jumpDistance = (long) Math.pow(2, maxJump - 1);
            if (Math.abs(y) >= Math.abs(x)) {
                if (y >= 0) {
                    y -= jumpDistance;
                    path.append("N");
                } else {
                    y += jumpDistance;
                    path.append("S");
                }
            } else {
                if (x >= 0) {
                    x -= jumpDistance;
                    path.append("E");
                } else {
                    x += jumpDistance;
                    path.append("W");
                }
            }
            maxJump--;
        }

        if (x == 0 && y == 0 && path.length() > 0) {
            return path.reverse().toString();
        } else {
            return "IMPOSSIBLE";
        }
    }
}