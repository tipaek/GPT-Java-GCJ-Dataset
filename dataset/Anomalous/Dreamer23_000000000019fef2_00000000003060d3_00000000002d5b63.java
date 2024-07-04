import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    
    private static final int HALF_DISTANCE = 500000000;
    private static final int FULL_DISTANCE = 1000000000;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            String[] settings = scanner.nextLine().split(" ");
            int t = Integer.parseInt(settings[0]);
            int A = Integer.parseInt(settings[1]);
            int B = Integer.parseInt(settings[2]);

            for (int i = 0; i < t; i++) {
                processCase(scanner, A, B);
            }
        }
    }

    private static void processCase(Scanner scanner, int minWidth, int maxWidth) {
        try {
            Point pointOnBoard = findStartingPoint(scanner);
            int left = binarySearch(scanner, -FULL_DISTANCE, pointOnBoard.x, pointOnBoard.y, true, true);
            int right = binarySearch(scanner, pointOnBoard.x, FULL_DISTANCE, pointOnBoard.y, false, true);
            int up = binarySearch(scanner, -FULL_DISTANCE, pointOnBoard.y, pointOnBoard.x, true, false);
            int down = binarySearch(scanner, pointOnBoard.y, FULL_DISTANCE, pointOnBoard.x, false, false);

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    throwDart(scanner, (left + right) / 2 + i, (up + down) / 2 + j);
                }
            }
        } catch (FoundCenterException ignored) {
        }
    }

    private static int binarySearch(Scanner scanner, int min, int max, int fixed, boolean isMin, boolean isHorizontal) throws FoundCenterException {
        while (max - min > 1) {
            int mid = min + (max - min) / 2;
            String response = isHorizontal ? throwDart(scanner, mid, fixed) : throwDart(scanner, fixed, mid);
            if ((response.equals("HIT") && isMin) || (response.equals("MISS") && !isMin)) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return isMin ? min : max;
    }

    private static Point findStartingPoint(Scanner scanner) throws FoundCenterException {
        if (throwDart(scanner, 0, 0).equals("HIT")) return new Point(0, 0);
        if (throwDart(scanner, -HALF_DISTANCE, 0).equals("HIT")) return new Point(-HALF_DISTANCE, 0);
        if (throwDart(scanner, HALF_DISTANCE, 0).equals("HIT")) return new Point(HALF_DISTANCE, 0);
        if (throwDart(scanner, 0, HALF_DISTANCE).equals("HIT")) return new Point(0, HALF_DISTANCE);
        return new Point(0, -HALF_DISTANCE);
    }

    private static String throwDart(Scanner scanner, int x, int y) throws FoundCenterException {
        System.out.println(x + " " + y);
        System.out.flush();
        String response = scanner.nextLine();
        if (response.equals("CENTER")) throw new FoundCenterException();
        return response;
    }

    private static class FoundCenterException extends Exception {
        private static final long serialVersionUID = 1L;
    }

    private static class Point {
        private final int x, y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}