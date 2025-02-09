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
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int a = 1; a <= T; a++) {
            long x = sc.nextInt();
            long y = sc.nextInt();

            System.out.print("Case #" + a + ": ");

            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(0, 0, 0, ""));

            boolean found = false;

            while (!queue.isEmpty()) {
                Pair current = queue.poll();
                if (current.x == x && current.y == y) {
                    System.out.println(current.path);
                    found = true;
                    break;
                }

                if (current.len > 8) {
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