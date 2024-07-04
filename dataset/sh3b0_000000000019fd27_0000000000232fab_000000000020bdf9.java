import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point> {
    private int x;
    boolean flag;
    Interval in;

    Point(int x, boolean flag) {
        this.x = x;
        this.flag = flag;
    }

    @Override
    public int compareTo(Point that) {
        if (this.x < that.x) return -1;
        else if (this.x > that.x) return 1;
        else if (this.flag == that.flag) return 0;
        else if (!this.flag) return -1;
        else return 1;
    }
}

class Interval {
    int idx, s, e;

    Interval(int idx, int s, int e) {
        this.idx = idx;
        this.s = s;
        this.e = e;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), n, s, e;

        for (int w = 1; w <= t; w++) {
            n = sc.nextInt();
            ArrayList<Point> p = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                s = sc.nextInt();
                e = sc.nextInt();
                Interval in = new Interval(i, s, e);
                p.add(new Point(s, true));
                p.get(p.size() - 1).in = in;
                p.add(new Point(e, false));
                p.get(p.size() - 1).in = in;
            }
            Collections.sort(p);
            ArrayList<Interval> active = new ArrayList<>();
            boolean fail = false;
            char[] out = new char[n];
            System.out.print("Case #" + w + ": ");
            for (Point i : p) {
                if (!i.flag) {
                    // System.out.println("Removing " + i.in.s + " " + i.in.e);
                    active.remove(i.in);
                } else {
                    // System.out.println("Inserting " + i.in.s + " " + i.in.e);
                    if (active.isEmpty()) out[i.in.idx] = 'C';
                    else {
                        if (out[active.get(0).idx] == 'C') out[i.in.idx] = 'J';
                        else out[i.in.idx] = 'C';
                    }

                    active.add(i.in);

                    if (active.size() > 2) {
                        System.out.println("IMPOSSIBLE");
                        fail = true;
                    }
                }
            }
            if (!fail) {
                for (char i : out) System.out.print(i);
                System.out.println("");
            }
        }
    }
}