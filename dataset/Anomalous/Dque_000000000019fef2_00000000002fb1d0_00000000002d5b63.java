import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    
    private static final int HALF_E92 = 1000000000 / 2;
    private static final int MAX_COORDINATE = 1000000000;
    private static final int MIN_COORDINATE = -1000000000;
    private static final int BUFFER = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int testCases = Integer.parseInt(tokenizer.nextToken());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int currentX = -1;
            int currentY = -1;
            boolean found = false;

            int[] initialGuesses = {0, HALF_E92, -HALF_E92, HALF_E92, -HALF_E92, 0, -HALF_E92, 0};
            for (int i = 0; i < initialGuesses.length; i += 2) {
                writer.println(initialGuesses[i] + " " + initialGuesses[i + 1]);
                writer.flush();
                String response = reader.readLine();

                if ("CENTER".equals(response)) {
                    found = true;
                    break;
                } else if ("HIT".equals(response)) {
                    currentX = initialGuesses[i];
                    currentY = initialGuesses[i + 1];
                }
            }

            if (found) continue;

            int upperBound = binarySearch(currentX, currentY, currentY, MAX_COORDINATE, true, writer, reader);
            int lowerBound = binarySearch(currentX, currentY, MIN_COORDINATE, currentY, true, writer, reader);
            int rightBound = binarySearch(currentX, currentY, currentX, MAX_COORDINATE, false, writer, reader);
            int leftBound = binarySearch(currentX, currentY, MIN_COORDINATE, currentX, false, writer, reader);

            if (found) continue;

            int centerX = (leftBound + rightBound) / 2;
            int centerY = (upperBound + lowerBound) / 2;

            for (int x = centerX - BUFFER; x <= centerX + BUFFER; x++) {
                if (found) break;
                for (int y = centerY - BUFFER; y <= centerY + BUFFER; y++) {
                    writer.println(x + " " + y);
                    writer.flush();
                    String response = reader.readLine();
                    if ("CENTER".equals(response)) {
                        found = true;
                        break;
                    }
                }
            }
        }

        writer.close();
    }

    private static int binarySearch(int curX, int curY, int low, int high, boolean isVertical, PrintWriter writer, BufferedReader reader) throws IOException {
        int mid, answer = isVertical ? curY : curX;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (isVertical) {
                writer.println(curX + " " + mid);
            } else {
                writer.println(mid + " " + curY);
            }
            writer.flush();
            String response = reader.readLine();

            if ("CENTER".equals(response)) {
                return mid;
            } else if ("HIT".equals(response)) {
                if (isVertical) {
                    low = mid + 1;
                } else {
                    low = mid + 1;
                }
                answer = mid;
            } else {
                if (isVertical) {
                    high = mid - 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return answer;
    }
}