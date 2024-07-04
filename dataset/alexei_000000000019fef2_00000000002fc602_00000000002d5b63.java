import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        List<Point> points = new ArrayList<>();
        points.add(new Point(-1000000000, 1000000000));
        points.add(new Point(-500000000, 1000000000));
        points.add(new Point(0, 1000000000));
        points.add(new Point(500000000, 1000000000));
        points.add(new Point(1000000000, 1000000000));

        points.add(new Point(-1000000000, 500000000));
        points.add(new Point(-500000000, 500000000));
        points.add(new Point(0, 500000000));
        points.add(new Point(500000000, 500000000));
        points.add(new Point(1000000000, 500000000));

        points.add(new Point(-1000000000, 0));
        points.add(new Point(-500000000, 0));
        points.add(new Point(0, 0));
        points.add(new Point(500000000, 0));
        points.add(new Point(1000000000, 0));

        points.add(new Point(-1000000000, -500000000));
        points.add(new Point(-500000000, -500000000));
        points.add(new Point(0, -500000000));
        points.add(new Point(500000000, -500000000));
        points.add(new Point(1000000000, -500000000));

        points.add(new Point(-1000000000, -1000000000));
        points.add(new Point(-500000000, -1000000000));
        points.add(new Point(0, -1000000000));
        points.add(new Point(500000000, -1000000000));
        points.add(new Point(1000000000, -1000000000));

        points.add(new Point(250000000, 250000000));
        points.add(new Point(250000000, 750000000));
        points.add(new Point(750000000, 250000000));
        points.add(new Point(750000000, 750000000));

        points.add(new Point(-250000000, 250000000));
        points.add(new Point(-250000000, 750000000));
        points.add(new Point(-750000000, 250000000));
        points.add(new Point(-750000000, 750000000));

        points.add(new Point(250000000, -250000000));
        points.add(new Point(250000000, -750000000));
        points.add(new Point(750000000, -250000000));
        points.add(new Point(750000000, -750000000));

        points.add(new Point(-250000000, -250000000));
        points.add(new Point(-250000000, -750000000));
        points.add(new Point(-750000000, -250000000));
        points.add(new Point(-750000000, -750000000));

        for (int c = 1; c <= T ; c++) {
            boolean done = false;
            for (Point p : points) {
                System.out.println("" + p.x + " " + p.y);
                String s = in.next();
                if (s.equals("MISS")) {
                    continue;
                }
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                int from = p.x;
                int to = 1000000000;
                while (from + 1 < to) {
                    int mid = from + (to - from)/2;

                    System.out.println("" + mid + " " + p.y);
                    s = in.next();
                    if (s.equals("CENTER")) {
                        done = true;
                        break;
                    }
                    if (s.equals("HIT")) {
                        from = mid;
                    } else {
                        to = mid;
                    }
                }
                int r = from;


                from = p.y;
                to = 1000000000;
                while (from + 1 < to) {
                    int mid = from + (to - from)/2;

                    System.out.println("" + p.x + " " + mid);
                    s = in.next();
                    if (s.equals("CENTER")) {
                        done = true;
                        break;
                    }
                    if (s.equals("HIT")) {
                        from = mid;
                    } else {
                        to = mid;
                    }
                }
                int u = from;


                from = -1000000000;
                to = p.x;
                while (from + 1 < to) {
                    int mid = from + (to - from)/2;

                    System.out.println("" + mid + " " + p.y);
                    s = in.next();
                    if (s.equals("CENTER")) {
                        done = true;
                        break;
                    }
                    if (s.equals("HIT")) {
                        to = mid;
                    } else {
                        from = mid;
                    }
                }
                int l = to;


                from = -1000000000;
                to = p.y;
                while (from + 1 < to) {
                    int mid = from + (to - from)/2;

                    System.out.println("" + p.x + " " + mid);
                    s = in.next();
                    if (s.equals("CENTER")) {
                        done = true;
                        break;
                    }
                    if (s.equals("HIT")) {
                        to = mid;
                    } else {
                        from = mid;
                    }
                }
                int d = to;


                Point center = new Point((r+l)/2, (u+d)/2);

                System.out.println("" + (center.x-1) + " " + (center.y-1));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                System.out.println("" + (center.x-1) + " " + (center.y));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                System.out.println("" + (center.x-1) + " " + (center.y+1));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                System.out.println("" + (center.x) + " " + (center.y-1));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                System.out.println("" + (center.x) + " " + (center.y));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                System.out.println("" + (center.x) + " " + (center.y+1));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                System.out.println("" + (center.x+1) + " " + (center.y-1));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                System.out.println("" + (center.x+1) + " " + (center.y));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }

                System.out.println("" + (center.x+1) + " " + (center.y+1));
                s = in.next();
                if (s.equals("CENTER")) {
                    done = true;
                    break;
                }
            }
            if (done) {
                continue;
            }
        }
    }
}