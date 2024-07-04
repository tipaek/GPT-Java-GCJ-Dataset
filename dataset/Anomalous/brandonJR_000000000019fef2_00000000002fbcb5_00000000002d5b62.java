import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());

        for (int t = 1; t <= T; t++) {
            int destX = in.nextInt();
            int destY = in.nextInt();
            String result = findShortestPath(destX, destY);
            System.out.printf("Case #%d: %s%n", t, result);
        }
    }

    private static String findShortestPath(int destX, int destY) {
        Stack<Character> path = new Stack<>();
        StringBuilder shortestPath = new StringBuilder();
        if (explorePath(path, 0, 0, destX, destY, 1, shortestPath)) {
            return shortestPath.toString();
        } else {
            return "IMPOSSIBLE";
        }
    }

    private static boolean explorePath(Stack<Character> path, int x, int y, int destX, int destY, int k, StringBuilder shortestPath) {
        if (x == destX && y == destY) {
            if (shortestPath.length() == 0 || shortestPath.length() > path.size()) {
                shortestPath.setLength(0);
                path.forEach(shortestPath::append);
            }
            return true;
        }

        int hop = 1 << (k - 1); // equivalent to Math.pow(2, k-1)

        if (hop > Math.abs(destX - x) + Math.abs(destY - y)) {
            return false;
        }

        // Try moving North
        path.push('N');
        if (explorePath(path, x, y + hop, destX, destY, k + 1, shortestPath)) {
            return true;
        }
        path.pop();

        // Try moving South
        path.push('S');
        if (explorePath(path, x, y - hop, destX, destY, k + 1, shortestPath)) {
            return true;
        }
        path.pop();

        // Try moving East
        path.push('E');
        if (explorePath(path, x + hop, y, destX, destY, k + 1, shortestPath)) {
            return true;
        }
        path.pop();

        // Try moving West
        path.push('W');
        if (explorePath(path, x - hop, y, destX, destY, k + 1, shortestPath)) {
            return true;
        }
        path.pop();

        return false;
    }
}