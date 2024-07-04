import java.util.Scanner;
import java.util.function.IntFunction;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int boundary = 1000000000;
            int upper = findBoundary(scanner, test -> new Point(0, boundary - test));
            int lower = findBoundary(scanner, test -> new Point(0, -boundary + test));
            int left = findBoundary(scanner, test -> new Point(-boundary + test, 0));
            int right = findBoundary(scanner, test -> new Point(boundary - test, 0));
            
            int x = (-boundary + left + boundary - right) / 2;
            int y = (boundary - upper + -boundary + lower) / 2;
            
            if (attemptGuess(scanner, x, y)) continue;
        }
    }

    private static int findBoundary(Scanner scanner, IntFunction<Point> pointGenerator) {
        int miss = -1;
        int hit = 101;
        
        while (hit - miss > 1) {
            int mid = (hit - miss) / 2 + miss;
            makeGuess(pointGenerator.apply(mid));
            
            switch (readGuess(scanner)) {
                case CENTER:
                    throw new IllegalStateException("Unexpected CENTER guess");
                case HIT:
                    hit = mid;
                    break;
                case MISS:
                    miss = mid;
                    break;
                case WRONG:
                    throw new IllegalStateException("Unexpected WRONG guess");
            }
        }
        return hit;
    }

    private static boolean attemptGuess(Scanner scanner, int x, int y) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                makeGuess(new Point(x + dx, y + dy));
                
                switch (readGuess(scanner)) {
                    case CENTER:
                        return true;
                    case HIT:
                        break;
                    case MISS:
                        break;
                    case WRONG:
                        throw new IllegalStateException("Unexpected WRONG guess");
                }
            }
        }
        return false;
    }

    private static void makeGuess(Point point) {
        System.out.println(point.x + " " + point.y);
        System.out.flush();
    }

    private static Guess readGuess(Scanner scanner) {
        return Guess.valueOf(scanner.next());
    }

    public static class Point {
        public int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public enum Guess {
        CENTER, HIT, MISS, WRONG;
    }
}