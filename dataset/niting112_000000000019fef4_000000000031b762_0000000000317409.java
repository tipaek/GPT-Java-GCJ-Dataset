import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= T; ++t) {
            String[] input = in.nextLine().split(" ");
            int x = Integer.valueOf(input[0]);
            int y = Integer.valueOf(input[1]);
            int mx = 0;
            int my = 0;
            if (x == mx && y == my) {
                sb.append("Case #" + t + ": " + 0);
                continue;
            }
            String path = input[2];
            int time = 1;
            boolean found = false;
            for (int i = 0; i < path.length(); ++i) {
                if (path.charAt(i) == 'S') {
                    y = y - 1;
                    x = x;

                } else if (path.charAt(i) == 'N') {
                    y = y + 1;
                    x = x;
                } else if (path.charAt(i) == 'W') {
                    y = y;
                    x = x - 1;
                } else {
                    y = y;
                    x = x + 1;
                }
                if (Math.abs(x - mx) + Math.abs(y - my) <= time) {
                    found = true;
                    break;
                }
                time += 1;
            }
            if (found)
                sb.append("Case #" + t + ": " + time + "\n");
            else
                sb.append("Case #" + t + ": IMPOSSIBLE\n");
        }

        System.out.print(sb.toString());
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
