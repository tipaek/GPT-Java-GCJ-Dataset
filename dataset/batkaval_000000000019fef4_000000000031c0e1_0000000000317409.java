import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int num = 1; num <= t; num++) {

            System.out.print("Case #" + num + ": ");

            int x = in.nextInt();
            int y = in.nextInt();
            String m = in.next();
            List<Point> reachablePoints = new ArrayList<>();
            int time = m.length();
            for (int i = 0; i < time; i++) {
                switch (m.charAt(i)) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'E':
                        x++;
                }
                if (abs(x) + abs(y) <= i+1) {
                    reachablePoints.add(new Point(x,y, i +1));
                }
            }

            if (reachablePoints.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            Optional<Point> min = reachablePoints.stream().min(Comparator.comparingLong(p -> p.t));

            System.out.println(min.get().t);
        }
    }

    public static class Point {
        int x;
        int y;
        int t;

        public Point() {

        }

        public Point(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
