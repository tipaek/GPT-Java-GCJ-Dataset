import java.util.*;

class Node {
    int i, j, steps;
    String path;

    Node(int i, int j, int steps, String path) {
        this.i = i;
        this.j = j;
        this.steps = steps;
        this.path = path;
    }
}

public class Solution {
    private static String constructKey(int x, int y) {
        return x + "x" + y + "y";
    }

    private static String solve(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1, ""));
        Set<String> visited = new HashSet<>();
        visited.add(constructKey(0, 0));

        int[] xDir = {-1, 1, 0, 0};
        int[] yDir = {0, 0, -1, 1};
        String key;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int curSteps = 1 << (current.steps - 1);

            if (current.i == x && current.j == y) {
                return current.path;
            }

            if (Math.abs(current.i) > 1000 || Math.abs(current.j) > 1000) {
                return "IMPOSSIBLE";
            }

            for (int i = 0; i < xDir.length; i++) {
                int newX = current.i + curSteps * xDir[i];
                int newY = current.j + curSteps * yDir[i];
                key = constructKey(newX, newY);

                if (!visited.contains(key)) {
                    char dir = 0;
                    if (xDir[i] == 1) dir = 'E';
                    else if (xDir[i] == -1) dir = 'W';
                    else if (yDir[i] == 1) dir = 'N';
                    else if (yDir[i] == -1) dir = 'S';

                    queue.offer(new Node(newX, newY, current.steps + 1, current.path + dir));
                    visited.add(key);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int iT = 1; iT <= t; iT++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println("Case #" + iT + ": " + solve(x, y));
        }
        sc.close();
    }
}