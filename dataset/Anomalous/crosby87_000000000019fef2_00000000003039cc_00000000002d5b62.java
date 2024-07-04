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
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            long targetX = scanner.nextInt();
            long targetY = scanner.nextInt();

            System.out.print("Case #" + i + ": ");

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, 0, 0, ""));

            boolean found = false;

            while (!queue.isEmpty()) {
                Pair current = queue.poll();
                if (current.x == targetX && current.y == targetY) {
                    System.out.println(current.path);
                    found = true;
                    break;
                }

                if (current.len > 30) {
                    System.out.println("IMPOSSIBLE");
                    found = true;
                    break;
                }

                int step = 1 << current.len;
                queue.add(new Pair(current.x, current.y + step, current.len + 1, current.path + "N"));
                queue.add(new Pair(current.x, current.y - step, current.len + 1, current.path + "S"));
                queue.add(new Pair(current.x + step, current.y, current.len + 1, current.path + "E"));
                queue.add(new Pair(current.x - step, current.y, current.len + 1, current.path + "W"));
            }

            if (!found) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}