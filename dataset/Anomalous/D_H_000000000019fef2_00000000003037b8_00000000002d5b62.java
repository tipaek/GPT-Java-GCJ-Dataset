import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static Map<Coordinate, String> answerMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            answerMap.clear();
            int xTarget = scanner.nextInt();
            int yTarget = scanner.nextInt();
            String result = findPath(0, 0, 1, xTarget, yTarget, "");
            if (result == null) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
        scanner.close();
    }

    static String findPath(int x, int y, int jump, int xTarget, int yTarget, String steps) {
        Coordinate current = new Coordinate(x, y, jump);
        if (answerMap.containsKey(current)) {
            return answerMap.get(current);
        }
        if (x == xTarget && y == yTarget) {
            return steps;
        }
        if (jump > Math.abs(xTarget) + Math.abs(yTarget)) {
            return null;
        }
        
        String[] directions = {"W", "E", "S", "N"};
        int[][] moves = {{-jump, 0}, {jump, 0}, {0, -jump}, {0, jump}};
        String shortestPath = null;

        for (int i = 0; i < directions.length; i++) {
            int newX = x + moves[i][0];
            int newY = y + moves[i][1];
            String path = findPath(newX, newY, jump * 2, xTarget, yTarget, steps + directions[i]);
            if (path != null && (shortestPath == null || path.length() < shortestPath.length())) {
                shortestPath = path;
            }
        }

        answerMap.put(current, shortestPath);
        return shortestPath;
    }
}

class Coordinate {
    int x;
    int y;
    int jump;

    public Coordinate(int x, int y, int jump) {
        this.x = x;
        this.y = y;
        this.jump = jump;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate that = (Coordinate) obj;
        return x == that.x && y == that.y && jump == that.jump;
    }

    @Override
    public int hashCode() {
        return 31 * x + 31 * y + jump;
    }
}