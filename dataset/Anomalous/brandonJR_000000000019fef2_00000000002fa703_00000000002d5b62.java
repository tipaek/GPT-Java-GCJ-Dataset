package gcj201bExpogo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            int destX = scanner.nextInt();
            int destY = scanner.nextInt();
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

        int hop = (int) Math.pow(2, k - 1);

        if (hop > 2 * Math.max(Math.abs(destX), Math.abs(destY))) {
            return false;
        }

        if (tryMove(path, x, y + hop, destX, destY, k, 'N', shortestPath)) return true;
        if (tryMove(path, x, y - hop, destX, destY, k, 'S', shortestPath)) return true;
        if (tryMove(path, x + hop, y, destX, destY, k, 'E', shortestPath)) return true;
        if (tryMove(path, x - hop, y, destX, destY, k, 'W', shortestPath)) return true;

        return false;
    }

    private static boolean tryMove(Stack<Character> path, int newX, int newY, int destX, int destY, int k, char direction, StringBuilder shortestPath) {
        path.push(direction);
        if (explorePath(path, newX, newY, destX, destY, k + 1, shortestPath)) {
            return true;
        } else {
            path.pop();
            return false;
        }
    }
}