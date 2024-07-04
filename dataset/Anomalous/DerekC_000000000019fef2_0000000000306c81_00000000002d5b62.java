import java.util.*;
import java.io.*;

class Node {
    Long x, y;
    String path;

    public Node(Long x, Long y, String path) {
        this.x = x;
        this.y = y;
        this.path = path;
    }
}

public class Solution {
    public static String pogo(Long targetX, Long targetY) {
        if (Math.abs(targetX) == Math.abs(targetY)) return "IMPOSSIBLE";

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0L, 1L, "N"));
        queue.offer(new Node(-1L, 0L, "W"));
        queue.offer(new Node(0L, -1L, "S"));
        queue.offer(new Node(1L, 0L, "E"));

        char[] directions = {'N', 'E', 'S', 'W'};
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int distance = 1;

        while (!queue.isEmpty()) {
            if (distance > 100) return "IMPOSSIBLE";

            int size = queue.size();
            Long jump = (long) Math.pow(2, distance);

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                for (int j = 0; j < 4; j++) {
                    Long newX = current.x + dx[j] * jump;
                    Long newY = current.y + dy[j] * jump;
                    String newPath = current.path + directions[j];

                    if (newX.equals(targetX) && newY.equals(targetY)) {
                        return newPath;
                    } else {
                        queue.offer(new Node(newX, newY, newPath));
                    }
                }
            }
            distance++;
        }

        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            Long x = scanner.nextLong();
            Long y = scanner.nextLong();
            System.out.println("Case #" + i + ": " + pogo(x, y));
        }

        scanner.close();
    }
}