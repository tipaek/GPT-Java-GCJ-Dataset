import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final int POW = (int) Math.pow(10, 9);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int a = Integer.parseInt(input[1]);
        int b = Integer.parseInt(input[2]);

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int d = POW - a;

            long left = binarySearchFirst(-POW, -POW + 3 * d, 'x', reader);
            long top = binarySearchFirst(-POW, -POW + 3 * d, 'y', reader);
            long right = binarySearchLast(POW - 3 * d, POW, 'x', reader);
            long bottom = binarySearchLast(POW - 3 * d, POW, 'y', reader);

            long centerX = (left + right) / 2;
            long centerY = (top + bottom) / 2;

            boolean found = false;
            for (long x = centerX - 2; x <= centerX + 2 && !found; x++) {
                for (long y = centerY - 2; y <= centerY + 2 && !found; y++) {
                    System.out.println(x + " " + y);
                    System.out.flush();
                    String response = reader.readLine();
                    if ("CENTER".equals(response)) {
                        found = true;
                    } else if ("WRONG".equals(response)) {
                        throw new IllegalStateException("Received WRONG response");
                    }
                }
            }
        }
    }

    private static long binarySearchLast(long left, long right, char axis, BufferedReader reader) throws IOException {
        long lastHit = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (axis == 'x') {
                System.out.println(mid + " 0");
            } else if (axis == 'y') {
                System.out.println("0 " + mid);
            }
            System.out.flush();
            String response = reader.readLine();
            if ("HIT".equals(response)) {
                lastHit = mid;
                left = mid + 1;
            } else if ("MISS".equals(response)) {
                right = mid - 1;
            } else {
                throw new IllegalStateException("Unexpected response: " + response);
            }
        }
        return lastHit;
    }

    private static long binarySearchFirst(long left, long right, char axis, BufferedReader reader) throws IOException {
        long firstHit = -1;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (axis == 'x') {
                System.out.println(mid + " 0");
            } else if (axis == 'y') {
                System.out.println("0 " + mid);
            }
            System.out.flush();
            String response = reader.readLine();
            if ("HIT".equals(response)) {
                firstHit = mid;
                right = mid - 1;
            } else if ("MISS".equals(response)) {
                left = mid + 1;
            } else {
                throw new IllegalStateException("Unexpected response: " + response);
            }
        }
        return firstHit;
    }
}