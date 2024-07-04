import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {



    static class Step {
        int x;
        int y;
        int move;
        String dir;

        public Step(int x, int y, int move, String dir) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.dir = dir;
        }
    }

    static void solve(int tx, int ty) {
        HashSet<String> visited = new HashSet<>();

        Queue<Step> q = new LinkedList<>();
        q.add(new Step(0, 0, 1, ""));

        while (!q.isEmpty()) {
            Step cur = q.poll();

            if (cur.x == tx && cur.y == ty) {
                System.out.println(cur.dir);
                return;
            }

            int x = cur.x;
            int y = cur.y;
            int step = cur.move;



            if (visited.contains(x + ":" + y+":"+step)) {
                continue;
            }



            if (step > Math.log(1000000000)) {
                System.out.println("IMPOSSIBLE");
                return;
            }

            visited.add(x + ":" + y+":"+step);

            q.add(new Step(x + step, y, 2 * step, cur.dir + "E"));
            q.add(new Step(x - step, y, 2 * step, cur.dir + "W"));
            q.add(new Step(x, y - step, 2 * step, cur.dir + "S"));
            q.add(new Step(x, y + step, 2 * step, cur.dir + "N"));
        }

        System.out.println("IMPOSSIBLE");

    }

    public static void main(String[] args) {
        Scanner sc = null;
        //  try {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int cs = 1; cs <= cases; cs++) {
            int tx = in.nextInt();
            int ty = in.nextInt();
            System.out.print(String.format("CASE #%d: ", cs));
            solve(tx, ty);
        }
    }
}
