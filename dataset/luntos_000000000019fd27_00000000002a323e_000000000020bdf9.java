import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            List<Point> points = new ArrayList<>(2*n);
            String[] assignments = new String[n];
            for (int i = 0; i < n; i++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                points.add(new Point(s, true, i));
                points.add(new Point(e, false, i));
            }
            Collections.sort(points);
            int depth = 0;
            StringBuilder sb = new StringBuilder();
            boolean cFree = true;
            boolean possible = true;
            for (Point p : points) {
                if (p.start) {
                    depth++;
                    if (depth >= 3) {
                        possible = false;
                        break;
                    }else {
                        if (cFree) {
                            assignments[p.ind] = "C";
                            cFree = false;
                        } else {
                            assignments[p.ind] = "J";
                        }
                    }
                } else {
                    depth --;
                    if (assignments[p.ind].equals("C")) {
                        cFree = true;
                    }
                }
            }
            if (possible) {
                System.out.println("Case #" + t + ": " + String.join("", assignments));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}

class Point implements Comparable<Point> {
    int t;
    int ind;
    boolean start;

    public Point(int t, boolean start, int ind) {
        this.t = t;
        this.start = start;
        this.ind = ind;
    }

    @Override
    public int compareTo(Point o) {
        if (this.t != o.t) {
            return Integer.compare(this.t, o.t);
        }
        if (this.start && o.start) {
            return 0;
        }
        if (!this.start) {
            return -1;
        }
        return 1;
    }
}
