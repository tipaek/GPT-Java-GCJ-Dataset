import java.util.*;

class Node {
    int x, y, steps;
    String path;

    Node(int x, int y, int steps, String path) {
        this.x = x;
        this.y = y;
        this.steps = steps;
        this.path = path;
    }
}

public class Solution {
    private static String constructKey(int x, int y) {
        return x + "x" + y + "y";
    }

    private static String solve(int targetX, int targetY) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, ""));
        Set<String> visited = new HashSet<>();
        visited.add(constructKey(0, 0));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char[] directions = {'W', 'E', 'S', 'N'};

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int stepSize = 1 << (current.steps - 1);

            if (current.x == targetX && current.y == targetY) {
                return current.path;
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + stepSize * dx[i];
                int newY = current.y + stepSize * dy[i];
                String key = constructKey(newX, newY);

                if (!visited.contains(key)) {
                    queue.offer(new Node(newX, newY, current.steps + 1, current.path + directions[i]));
                    visited.add(key);
                }
            }
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(x, y));
        }

        scanner.close();
    }
}