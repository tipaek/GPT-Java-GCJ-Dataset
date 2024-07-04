import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] settings = scanner.nextLine().split(" ");
        int testCases = Integer.parseInt(settings[0]);
        int A = Integer.parseInt(settings[1]);
        int B = Integer.parseInt(settings[2]);

        for (int i = 1; i <= testCases; i++) {
            processCase(scanner, A, B);
        }
        
        scanner.close();
    }

    private static final int HALF_DISTANCE = 500000000;
    private static final int FULL_DISTANCE = 1000000000;

    private static void processCase(Scanner scanner, int minWidth, int maxWidth) {
        try {
            Point pointOnBoard = findStartingPoint(scanner);
            int left = binarySearch(scanner, -FULL_DISTANCE, pointOnBoard.x, pointOnBoard.y, Direction.LEFT).x;
            int right = binarySearch(scanner, pointOnBoard.x, FULL_DISTANCE, pointOnBoard.y, Direction.RIGHT).x;
            int up = binarySearch(scanner, -FULL_DISTANCE, pointOnBoard.y, pointOnBoard.x, Direction.UP).y;
            int down = binarySearch(scanner, pointOnBoard.y, FULL_DISTANCE, pointOnBoard.x, Direction.DOWN).y;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    throwDart(scanner, (left + right) / 2 + i, (up + down) / 2 + j);
                }
            }
        } catch (FoundCenterException e) {
            // Center found, no further action needed
        }
    }

    private enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    private static Point binarySearch(Scanner scanner, int min, int max, int fixed, Direction direction) throws FoundCenterException {
        if (max - min <= 1) {
            return new Point(direction == Direction.LEFT || direction == Direction.RIGHT ? min : fixed,
                             direction == Direction.UP || direction == Direction.DOWN ? min : fixed);
        }

        int mid = min + (max - min) / 2;
        String response = direction == Direction.LEFT || direction == Direction.RIGHT 
                          ? throwDart(scanner, mid, fixed) 
                          : throwDart(scanner, fixed, mid);

        if ((direction == Direction.LEFT || direction == Direction.UP) && response.equals("HIT") ||
            (direction == Direction.RIGHT || direction == Direction.DOWN) && response.equals("MISS")) {
            return binarySearch(scanner, min, mid, fixed, direction);
        } else {
            return binarySearch(scanner, mid, max, fixed, direction);
        }
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