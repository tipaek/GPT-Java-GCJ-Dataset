import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    private static class Interval {
        int start;
        int end;
        int position;
        char partner;

        Interval (int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }

    public static String solve (ArrayList<Interval> list, int n) {
        String res = "";
        Comparator<Interval> compareByEnd = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end < o2.end)
                    return -1;
                else if (o1.end > o2.end)
                    return 1;
                else
                    return 0;
            }
        };
        Collections.sort(list, compareByEnd);
        int c = 0, j = 0;
        for (Interval interval : list) {
            if (interval.start >= c) {
                interval.partner = 'C';
                c = interval.end;
                //System.out.println("C assigned for interval " + interval.start + ", " + interval.end);
            } else if (interval.start >= j) {
                interval.partner = 'J';
                j = interval.end;
                //System.out.println("J assigned for interval " + interval.start + ", " + interval.end);
            } else {
                return "IMPOSSIBLE";
            }
        }
        Comparator<Interval> compareByPosition = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.position < o2.position) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        Collections.sort(list, compareByPosition);
        for (Interval interval : list) {
            res += interval.partner;
        }
        return res;
    }

    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        ArrayList<Interval> list = new ArrayList<Interval>();
        for (int i = 1; i <= t; i++) {
            int n = input.nextInt();
            for (int j = 0; j < n; j++) {
                Interval interval = new Interval(input.nextInt(), input.nextInt(), j);
                list.add(interval);
            }
            System.out.println("Case #" + i + ": " + solve(list, n));
        }
        input.close();
    }
}
