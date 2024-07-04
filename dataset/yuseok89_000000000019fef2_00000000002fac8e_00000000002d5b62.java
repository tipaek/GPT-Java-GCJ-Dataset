import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Coord {
        int y;
        int x;
        int k;
        List<Character> path = new ArrayList<>();

        Coord(int y, int x, int k, List<Character> path) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.path = path;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();

        for (int test = 1; test <= T; ++test) {
            int y, x;

            x = in.nextInt();
            y = in.nextInt();

            Queue<Coord> queue = new LinkedList<>();

            queue.add(new Coord(0, 0, 1, new ArrayList<>()));

            while (!queue.isEmpty()) {
                Coord cur = queue.poll();

                if (y == cur.y && x == cur.x) {
                    System.out.print("Case #" + test + ": ");

                    for (Character c : cur.path) {
                        System.out.print(c);
                    }

                    System.out.println();

                    break;
                }

                if (cur.k > 500) {
                    continue;
                }

                List<Character> newPath;

                if (cur.y != y) {
                    newPath = new ArrayList<>(cur.path);
                    newPath.add('N');
                    queue.add(new Coord(cur.y + cur.k, cur.x, cur.k * 2, newPath));

                    newPath = new ArrayList<>(cur.path);
                    newPath.add('S');
                    queue.add(new Coord(cur.y - cur.k, cur.x, cur.k * 2, newPath));
                }

                if (cur.x != x) {
                    newPath = new ArrayList<>(cur.path);
                    newPath.add('E');
                    queue.add(new Coord(cur.y, cur.x + cur.k, cur.k * 2, newPath));

                    newPath = new ArrayList<>(cur.path);
                    newPath.add('W');
                    queue.add(new Coord(cur.y, cur.x - cur.k, cur.k * 2, newPath));
                }
            }

            if (queue.isEmpty()) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            }
        }
    }
}
