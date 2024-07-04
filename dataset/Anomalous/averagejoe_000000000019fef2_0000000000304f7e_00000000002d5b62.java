import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expogo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int targetX = sc.nextInt();
            int targetY = sc.nextInt();

            String result = findPath(targetX, targetY);
            System.out.println(String.format("Case #%d: %s", caseNum, result));
        }
    }

    private static String findPath(int targetX, int targetY) {
        int maxSize = Math.max(Math.abs(targetX), Math.abs(targetY)) * 10;
        boolean[][] visited = new boolean[maxSize][maxSize];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, ""));
        visited[maxSize / 2][maxSize / 2] = true;

        int power = 0;
        while (!queue.isEmpty()) {
            int step = (int) Math.pow(2, power);
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                Node current = queue.poll();
                Node[] neighbors = {
                    new Node(current.x + step, current.y, current.path + "E"),
                    new Node(current.x - step, current.y, current.path + "W"),
                    new Node(current.x, current.y + step, current.path + "N"),
                    new Node(current.x, current.y - step, current.path + "S")
                };

                for (Node neighbor : neighbors) {
                    int adjustedX = neighbor.x + maxSize / 2;
                    int adjustedY = neighbor.y + maxSize / 2;

                    if (adjustedX >= maxSize || adjustedY >= maxSize || adjustedX < 0 || adjustedY < 0) {
                        continue;
                    }

                    if (!visited[adjustedX][adjustedY]) {
                        visited[adjustedX][adjustedY] = true;

                        if (neighbor.x == targetX && neighbor.y == targetY) {
                            return neighbor.path;
                        }

                        queue.add(neighbor);
                    }
                }
            }
            power++;
        }

        return "IMPOSSIBLE";
    }

    static class Node {
        int x, y;
        String path;

        Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}