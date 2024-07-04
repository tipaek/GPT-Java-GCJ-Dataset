import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    private static final int MIN_COORD = -1000000000;
    private static final int MAX_COORD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int T = Integer.parseInt(tokenizer.nextToken());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= T; i++) {
            int x = MIN_COORD + A;
            int y = MIN_COORD + A;

            writer.write(String.format("%d %d\n", x, y));
            writer.flush();

            String response = reader.readLine();
            while ("MISS".equals(response)) {
                x += A;
                if (x > MAX_COORD) {
                    x = MIN_COORD + A;
                    y += A;
                }
                if (y > MAX_COORD) {
                    break;
                }
                writer.write(String.format("%d %d\n", x, y));
                writer.flush();
                response = reader.readLine();
            }

            if ("CENTER".equals(response)) {
                continue;
            }
            if ("WRONG".equals(response) || "MISS".equals(response)) {
                break;
            }

            int xL = binarySearch(writer, reader, MIN_COORD, x, y, true, true);
            if (xL == Integer.MIN_VALUE) break;

            int xR = binarySearch(writer, reader, x, MAX_COORD, y, true, false);
            if (xR == Integer.MIN_VALUE) break;

            int yL = binarySearch(writer, reader, MIN_COORD, y, x, false, true);
            if (yL == Integer.MIN_VALUE) break;

            int yU = binarySearch(writer, reader, y, MAX_COORD, x, false, false);
            if (yU == Integer.MIN_VALUE) break;

            writer.write(String.format("%d %d\n", (xL + xR) / 2, (yL + yU) / 2));
            writer.flush();
            response = reader.readLine();
            if (!"CENTER".equals(response)) {
                break;
            }
        }

        writer.close();
    }

    private static int binarySearch(BufferedWriter writer, BufferedReader reader, int low, int high, int fixed, boolean isX, boolean findLow) throws IOException {
        int mid;
        String response;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (isX) {
                writer.write(String.format("%d %d\n", mid, fixed));
            } else {
                writer.write(String.format("%d %d\n", fixed, mid));
            }
            writer.flush();
            response = reader.readLine();
            if ("MISS".equals(response)) {
                if (findLow) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if ("HIT".equals(response)) {
                if (findLow) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if ("CENTER".equals(response)) {
                return Integer.MIN_VALUE;
            } else {
                break;
            }
        }
        return findLow ? low : high;
    }
}