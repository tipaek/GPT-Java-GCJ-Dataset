import java.util.*;
import java.io.*;

class Path {
    int r, c;
    String path;

    Path(int r, int c, String path) {
        this.r = r;
        this.c = c;
        this.path = path;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int k = 1; k <= t; k++) {
            int x = in.nextInt();
            int y = in.nextInt();

            String res = "IMPOSSIBLE";
            if ((x + y) % 2 == 1) {
                Queue<Path> queue = new LinkedList<>();
                Set<String> visited = new HashSet<>();

                queue.add(new Path(0, 0, ""));
                int level = 0;

                outerLoop:
                while (!queue.isEmpty() && level <= 32) {
                    int step = 1 << level;
                    int size = queue.size();

                    for (int i = 0; i < size; i++) {
                        Path current = queue.poll();

                        if (current.r == y && current.c == x) {
                            res = current.path;
                            break outerLoop;
                        }

                        if (visited.contains(current.r + "," + current.c)) continue;
                        visited.add(current.r + "," + current.c);

                        queue.add(new Path(current.r, current.c + step, current.path + "E"));
                        queue.add(new Path(current.r, current.c - step, current.path + "W"));
                        queue.add(new Path(current.r - step, current.c, current.path + "S"));
                        queue.add(new Path(current.r + step, current.c, current.path + "N"));
                    }
                    level++;
                }
            }

            System.out.println("Case #" + k + ": " + res);
        }
    }
}