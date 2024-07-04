import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String[] input = scan.readLine().split(" ");
        int T = Integer.parseInt(input[0]);

        final int MID = 500000000;
        String[] testPoints = {
            "0 0",
            MID + " " + MID,
            -MID + " " + MID,
            MID + " " + -MID,
            -MID + " " + -MID
        };

        for (int t = 1; t <= T; t++) {
            int x = 0;
            int y = 0;
            boolean foundCenter = false;

            for (String point : testPoints) {
                System.out.println(point);
                System.out.flush();
                String response = scan.readLine();
                if (response.equals("CENTER")) {
                    foundCenter = true;
                    break;
                } else if (response.equals("HIT")) {
                    String[] coordinates = point.split(" ");
                    x = Integer.parseInt(coordinates[0]);
                    y = Integer.parseInt(coordinates[1]);
                    break;
                }
            }

            if (foundCenter) continue;

            long minX = x, maxX = 2 * MID;
            long rightX = binarySearch(scan, y, minX, maxX, true);
            if (foundCenter) continue;

            maxX = x;
            minX = -2 * MID;
            long leftX = binarySearch(scan, y, minX, maxX, false);
            if (foundCenter) continue;

            long minY = y, maxY = 2 * MID;
            long topY = binarySearch(scan, x, minY, maxY, true);
            if (foundCenter) continue;

            minY = -2 * MID;
            maxY = y;
            long bottomY = binarySearch(scan, x, minY, maxY, false);
            if (foundCenter) continue;

            long centerX = (rightX + leftX) / 2;
            long centerY = (topY + bottomY) / 2;

            System.out.println(centerX + " " + centerY);
            System.out.flush();
            if (scan.readLine().equals("CENTER")) {
                continue;
            } else {
                break;
            }
        }
    }

    private static long binarySearch(BufferedReader scan, int fixed, long min, long max, boolean isIncreasing) throws IOException {
        while (max - min > 1) {
            long mid = (min + max) / 2;
            System.out.println(isIncreasing ? mid + " " + fixed : fixed + " " + mid);
            System.out.flush();
            String response = scan.readLine();
            if (response.equals("CENTER")) {
                return mid;
            } else if (response.equals("HIT")) {
                if (isIncreasing) {
                    min = mid;
                } else {
                    max = mid;
                }
            } else {
                if (isIncreasing) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
        }
        return isIncreasing ? min : max;
    }
}