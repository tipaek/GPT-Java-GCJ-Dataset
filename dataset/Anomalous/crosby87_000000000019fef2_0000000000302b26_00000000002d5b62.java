import java.util.*;

public class Solution {
    static class Pair {
        long x, y;
        int len;
        String path;

        Pair(long x, long y, int len, String path) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            long targetX = scanner.nextInt();
            long targetY = scanner.nextInt();

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, 0, 0, ""));

            boolean found = false;
            String resultPath = "";

            while (!queue.isEmpty()) {
                Pair current = queue.poll();

                if (current.x == targetX && current.y == targetY) {
                    resultPath = current.path;
                    found = true;
                    break;
                }

                if (current.len > 8) {
                    System.out.println("IMPOSSIBLE");
                    found = true;
                    break;
                }

                long step = 1L << current.len;
                queue.add(new Pair(current.x, current.y + step, current.len + 1, current.path + "N"));
                queue.add(new Pair(current.x, current.y - step, current.len + 1, current.path + "S"));
                queue.add(new Pair(current.x + step, current.y, current.len + 1, current.path + "E"));
                queue.add(new Pair(current.x - step, current.y, current.len + 1, current.path + "W"));
            }

            if (!found) {
                System.out.println(resultPath);
            }
        }

        scanner.close();
    }
}