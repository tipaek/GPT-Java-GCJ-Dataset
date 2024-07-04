import java.util.*;

class Solution {
    static class Position {
        public StringBuilder path;
        public long x, y;

        public Position(long x, long y, StringBuilder path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            long x = in.nextLong();
            long y = in.nextLong();

            if (Math.abs(x) == Math.abs(y)) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
                continue;
            }

            int jumps = calculateJumps(x, y);
            Queue<Position> bfsQueue = initializeQueue();
            long currentStep = 1;
            int stepsTaken = 0;

            while (stepsTaken < jumps && !bfsQueue.isEmpty()) {
                Position currentPosition = bfsQueue.poll();

                if (isStepMarker(currentPosition)) {
                    bfsQueue.add(new Position(-1, -1, new StringBuilder()));
                    stepsTaken++;
                    currentStep <<= 1;
                    continue;
                }

                addNewPositions(bfsQueue, currentPosition, currentStep);
            }

            String result = findPath(bfsQueue, x, y);
            printResult(t, result);
        }
    }

    private static int calculateJumps(long x, long y) {
        int jumps = 0;
        long absX = Math.abs(x), absY = Math.abs(y);

        jumps += countSetBits(absX);
        jumps += countSetBits(absY);

        return jumps;
    }

    private static int countSetBits(long n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    private static Queue<Position> initializeQueue() {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, new StringBuilder()));
        queue.add(new Position(-1, -1, new StringBuilder()));
        return queue;
    }

    private static boolean isStepMarker(Position p) {
        return p.x == -1 && p.y == -1 && p.path.length() == 0;
    }

    private static void addNewPositions(Queue<Position> queue, Position p, long step) {
        if (p.x - step >= -1_000_000_000)
            queue.add(new Position(p.x - step, p.y, new StringBuilder(p.path).append("W")));
        if (p.x + step <= 1_000_000_000)
            queue.add(new Position(p.x + step, p.y, new StringBuilder(p.path).append("E")));
        if (p.y - step >= -1_000_000_000)
            queue.add(new Position(p.x, p.y - step, new StringBuilder(p.path).append("S")));
        if (p.y + step <= 1_000_000_000)
            queue.add(new Position(p.x, p.y + step, new StringBuilder(p.path).append("N")));
    }

    private static String findPath(Queue<Position> queue, long targetX, long targetY) {
        while (!queue.isEmpty()) {
            Position p = queue.poll();
            if (p.x == targetX && p.y == targetY) {
                return p.path.toString();
            }
        }
        return "IMPOSSIBLE";
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}