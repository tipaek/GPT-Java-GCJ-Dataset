import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false; 
    private static enum Dir { N, S, W, E }
    private static final Point ORIGIN = new Point(0, 0);
   
    private static class Point {

        final long x;
        final long y;
        
        @Override
        public int hashCode() {
            int hash = 5;
            hash = 73 * hash + (int) (this.x ^ (this.x >>> 32));
            hash = 73 * hash + (int) (this.y ^ (this.y >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Point other = (Point) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
        
        public long distance(Point other) {
            return Math.abs(x - other.x) + Math.abs(y - other.y);
        }
    }
    
    private static class Jump {
        final int number;
        final Dir dir;

        public Jump(int number, Dir dir) {
            this.number = number;
            this.dir = dir;
        }
        
    }
    
    private static void addPoint(PriorityQueue<Point> frontier, HashMap<Point, Jump> explored, HashMap<Point, Point> parents, Point target, Point from, int jumpNumber, Dir dir) {
        Point to;
        switch (dir) {
            case N:
                to = new Point(from.x, from.y + (1L << (jumpNumber - 1)));
                break;
            case S:
                to = new Point(from.x, from.y - (1L << (jumpNumber - 1)));
                break;
            case E:
                to = new Point(from.x + (1L << (jumpNumber - 1)), from.y);
                break;
            case W:
                to = new Point(from.x - (1L << (jumpNumber - 1)), from.y);
                break;
            default:
                throw new AssertionError(dir.name());
            
        }
        if (explored.containsKey(to)) {
            Jump jump = explored.get(to);
            if (jumpNumber < jump.number) {
                explored.replace(to, new Jump(jumpNumber, dir));
                parents.replace(to, from);
            }
        } else if (to.distance(target) <= ORIGIN.distance(target) * 2) {
            explored.put(to, new Jump(jumpNumber, dir));
            frontier.add(to);
            parents.put(to, from);
        }
    }
    
    private static String findShortestPath(Point target) {
        HashMap<Point, Point> parents = new HashMap<>();
        PriorityQueue<Point> frontier = new PriorityQueue<>((a, b) -> a.distance(target) > b.distance(target) ? 1 : a.distance(target) < b.distance(target) ? -1 : 0);
        HashMap<Point, Jump> explored = new HashMap<>();
        frontier.add(ORIGIN);
        explored.put(ORIGIN, new Jump(0, Dir.N));
        while (!frontier.isEmpty()) {
            Point from = frontier.poll();
            if (from.equals(target)) {
                StringBuilder result = new StringBuilder();
                while (!from.equals(ORIGIN)) {
                    Jump jump = explored.get(from);
                    result.insert(0, jump.dir.toString());
                    from = parents.get(from);
                }
                return result.toString();
            }
            Jump fromJump = explored.get(from);
            addPoint(frontier, explored, parents, target, from, fromJump.number + 1, Dir.S);
            addPoint(frontier, explored, parents, target, from, fromJump.number + 1, Dir.E);
            addPoint(frontier, explored, parents, target, from, fromJump.number + 1, Dir.W);
            addPoint(frontier, explored, parents, target, from, fromJump.number + 1, Dir.N);
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/round1b/ProblemA-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int targetX = scanner.nextInt();
                int targetY = scanner.nextInt();
                String result = findShortestPath(new Point(targetX, targetY));
                System.out.println("Case #" + testNumber + ": " + result);
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}