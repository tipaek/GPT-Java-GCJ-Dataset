import java.util.*;

public class Solution {
    public static class Pair {
        long x, y;
        int len;
        String path;

        public Pair(long x, long y, int len, String path) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testCase = 1; testCase <= T; testCase++) {
            long targetX = sc.nextLong();
            long targetY = sc.nextLong();

            System.out.print("Case #" + testCase + ": ");

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, 0, 0, ""));

            boolean found = false;

            while (!queue.isEmpty() && !found) {
                Pair current = queue.poll();

                if (current.x == targetX && current.y == targetY) {
                    System.out.println(current.path);
                    found = true;
                    break;
                }

                if (current.len > 8) {
                    System.out.println("IMPOSSIBLE");
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