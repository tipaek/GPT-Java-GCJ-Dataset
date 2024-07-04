import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final int POW = (int) Math.pow(10, 9);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        String[] inputs = reader.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int range = POW - a;

            long leftBoundary = findFirstHit(0, 3 * range, 'x', reader);
            long topBoundary = findFirstHit(0, 3 * range, 'y', reader);
            long rightBoundary = findLastHit(POW - 3 * range, POW, 'x', reader);
            long bottomBoundary = findLastHit(POW - 3 * range, POW, 'y', reader);

            long centerX = (leftBoundary + rightBoundary) / 2L;
            long centerY = (topBoundary + bottomBoundary) / 2L;

            searchCenter(centerX, centerY, reader);
        }
    }

    private static long findLastHit(long left, long right, char axis, BufferedReader reader) throws IOException {
        long lastHit = -1;
        while (left <= right) {
            long mid = (left + right) / 2L;
            System.out.println(axis == 'x' ? mid + " 0" : "0 " + mid);
            System.out.flush();
            String response = reader.readLine();
            if (response.equals("HIT")) {
                lastHit = mid;
                left = mid + 1;
            } else if (response.equals("MISS")) {
                right = mid - 1;
            } else {
                throw new IllegalStateException("Unexpected response");
            }
        }
        return lastHit;
    }

    private static long findFirstHit(long left, long right, char axis, BufferedReader reader) throws IOException {
        long firstHit = -1;
        while (left <= right) {
            long mid = (left + right) / 2L;
            System.out.println(axis == 'x' ? mid + " 0" : "0 " + mid);
            System.out.flush();
            String response = reader.readLine();
            if (response.equals("HIT")) {
                firstHit = mid;
                right = mid - 1;
            } else if (response.equals("MISS")) {
                left = mid + 1;
            } else {
                throw new IllegalStateException("Unexpected response");
            }
        }
        return firstHit;
    }

    private static void searchCenter(long centerX, long centerY, BufferedReader reader) throws IOException {
        outerLoop:
        for (long x = centerX - 2; x <= centerX + 2; x++) {
            for (long y = centerY - 2; y <= centerY + 2; y++) {
                System.out.println(x + " " + y);
                System.out.flush();
                String response = reader.readLine();
                if (response.equals("CENTER")) {
                    break outerLoop;
                } else if (response.equals("WRONG")) {
                    throw new IllegalStateException("Incorrect response");
                }
            }
        }
    }
}