import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        long minRadius = scanner.nextInt();
        long maxRadius = scanner.nextInt();
        for (int t = 1; t <= tests; t++) {
            Solver solver = new Solver(scanner, minRadius, maxRadius);
            String answer = solver.solve();
            if (answer.equals("WRONG")) {
                break;
            }
        }
    }
}

class Solver {

    private static final String ANSWER_CENTER = "CENTER";
    private static final String ANSWER_HIT = "HIT";
    private static final String ANSWER_MISS = "MISS";
    private static final String ANSWER_WRONG = "WRONG";

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
        Point above = findAbove();
        if (above.isAnswer) {
            return "OK";
        }
        Point below = findBelow();
        if (below.isAnswer) {
            return "OK";
        }
        long y = mid(above.y, below.y);
        long len = above.y - below.y;
        long x = (long)Math.sqrt(Math.pow(radius, 2) - Math.pow(len / 2, 2));
        if (isCenter(x, y)) {
            return "OK";
        }
        if (isCenter(-x, y)) {
            return "OK";
        }
        if (isCenter(x-1, y)) {
            return "OK";
        }
        if (isCenter(x+1, y)) {
            return "OK";
        }
        if (isCenter(-x-1, y)) {
            return "OK";
        }
        if (isCenter(-x+1, y)) {
            return "OK";
        }
        return "WRONG";
    }

    private boolean isCenter(long x, long y) {
        String answer = ask(x, y);
        return answer.equals(ANSWER_HIT);
    }

    private long diameter() {
        return radius * 2;
    }

    private Point findAbove() {
        return find(0, 1_000_000);
    }

    private Point findBelow() {
        return find(-1_000_000, 0);
    }

    private Point find(int min, int max) {
        long x = 0;
        long loY = min;
        long hiY = max;

        while (loY < hiY) {
            long midY = mid(loY, hiY);
            String answer = ask(x, midY);
            if (answer.equals(ANSWER_CENTER)) {
                return new Point(x, loY, true);
            }
            boolean isHit = answer.equals(ANSWER_HIT);
            if (isHit) {
                loY = midY + 1;
            } else {
                hiY = midY - 1;
            }
        }
        return new Point(x, loY - 1);
    }

    private long mid(long a, long b) {
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
