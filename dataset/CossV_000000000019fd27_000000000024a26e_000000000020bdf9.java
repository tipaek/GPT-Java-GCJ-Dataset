import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            int n = Integer.parseInt(sc.nextLine());
            String output = "";
            List<Interval> cIntervals = new ArrayList<>();
            List<Interval> jIntervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ("IMPOSSIBLE".equals(output)) {
                } else {
                    String[] line = sc.nextLine().split(" ");
                    int start = Integer.parseInt(line[0]);
                    int end = Integer.parseInt(line[1]);
                    Interval interval = new Interval(start, end);
                    if (listHasOverlappingInterval(cIntervals, interval)) {
                        if (listHasOverlappingInterval(jIntervals, interval)) {
                            output = "IMPOSSIBLE";
                        } else {
                            jIntervals.add(interval);
                            output += "J";
                        }
                    } else {
                        cIntervals.add(interval);
                        output += "C";
                    }
                }
            }

            System.out.println("Case #" + k + ": " + output);
        }
    }

    public static boolean listHasOverlappingInterval(List<Interval> list, Interval interval) {
        for (int i = 0; i < list.size(); i++) {
            Interval currInterval = list.get(i);
            if (overlaps(currInterval, interval)) {
                return true;
            }
        }

        return false;
    }

    public static boolean overlaps(Interval i1, Interval i2) {
        return ((i1.start < i2.end) && (i2.start < i1.end)) || (i1.start == i1.end && i2.start == i2.end && i1.end == i2.start);
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
