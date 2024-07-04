import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        long minRadius = scanner.nextLong();
        long maxRadius = scanner.nextLong();
        
        for (int t = 1; t <= testCases; t++) {
            Solver solver = new Solver(scanner, minRadius, maxRadius);
            String result = solver.solve();
            if (result.equals("WRONG")) {
                break;
            }
        }
        scanner.close();
    }
}

class Solver {

    private static final String RESPONSE_CENTER = "CENTER";
    private static final String RESPONSE_HIT = "HIT";
    private static final String RESPONSE_MISS = "MISS";
    private static final String RESPONSE_WRONG = "WRONG";

    private final Scanner scanner;
    private final long minRadius;
    private final long maxRadius;
    private final long radius;

    public Solver(Scanner scanner, long minRadius, long maxRadius) {
        this.scanner = scanner;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.radius = minRadius;
    }

    public String solve() {
        Point upperPoint = findUpperPoint();
        if (upperPoint.isAnswer) {
            return "OK";
        }
        
        Point lowerPoint = findLowerPoint();
        if (lowerPoint.isAnswer) {
            return "OK";
        }
        
        long yMid = calculateMidpoint(upperPoint.y, lowerPoint.y);
        long yLength = upperPoint.y - lowerPoint.y;
        long xOffset = (long) Math.sqrt(Math.pow(radius, 2) - Math.pow(yLength / 2, 2));
        
        if (checkCenter(xOffset, yMid) || checkCenter(-xOffset, yMid) ||
            checkCenter(xOffset - 1, yMid) || checkCenter(xOffset + 1, yMid) ||
            checkCenter(-xOffset - 1, yMid) || checkCenter(-xOffset + 1, yMid)) {
            return "OK";
        }
        
        return "WRONG";
    }

    private boolean checkCenter(long x, long y) {
        return ask(x, y).equals(RESPONSE_HIT);
    }

    private Point findUpperPoint() {
        return searchPoint(0, 1_000_000);
    }

    private Point findLowerPoint() {
        return searchPoint(-1_000_000, 0);
    }

    private Point searchPoint(int lowerBound, int upperBound) {
        long x = 0;
        long lowerY = lowerBound;
        long upperY = upperBound;

        while (lowerY < upperY) {
            long midY = calculateMidpoint(lowerY, upperY);
            String response = ask(x, midY);
            if (response.equals(RESPONSE_CENTER)) {
                return new Point(x, midY, true);
            }
            if (response.equals(RESPONSE_HIT)) {
                lowerY = midY + 1;
            } else {
                upperY = midY - 1;
            }
        }
        return new Point(x, lowerY - 1);
    }

    private long calculateMidpoint(long a, long b) {
        return (a + b) / 2;
    }

    private String ask(long x, long y) {
        System.out.println(x + " " + y);
        return scanner.next();
    }
}

class Point {

    final long x;
    final long y;
    final boolean isAnswer;

    public Point(long x, long y, boolean isAnswer) {
        this.x = x;
        this.y = y;
        this.isAnswer = isAnswer;
    }

    public Point(long x, long y) {
        this(x, y, false);
    }
}