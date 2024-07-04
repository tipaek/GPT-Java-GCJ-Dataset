import java.util.*;
import java.io.*;

class Node {
    Long x, y;
    StringBuilder path;

    public Node(Long x, Long y, String str) {
        this.x = x;
        this.y = y;
        this.path = new StringBuilder(str);
    }
}

class Solution {
    public static String pogo(Long x, Long y) {
        if (Math.abs(x) == Math.abs(y)) return "IMPOSSIBLE";

        int dist = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0L, 1L, "N"));
        queue.offer(new Node(-1L, 0L, "W"));
        queue.offer(new Node(0L, -1L, "S"));
        queue.offer(new Node(1L, 0L, "E"));

        char[] directions = {'N', 'E', 'S', 'W'};
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            if (dist > 100) return "IMPOSSIBLE";

            int size = queue.size();
            Long jump = (long) Math.pow(2, dist);
            while (size-- > 0) {
                Node current = queue.poll();

                for (int i = 0; i < 4; i++) {
                    Long newX = current.x + dx[i] * jump;
                    Long newY = current.y + dy[i] * jump;
                    String newPath = current.path.toString() + directions[i];

                    if (x.equals(newX) && y.equals(newY)) {
                        return newPath;
                    } else {
                        queue.offer(new Node(newX, newY, newPath));
                    }
                }
            }
            dist++;
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt(); // number of test cases

        for (int i = 1; i <= t; i++) {
            Long X = scanner.nextLong();
            Long Y = scanner.nextLong();
            System.out.println("Case #" + i + ": " + pogo(X, Y));
        }
        scanner.close();
    }
}