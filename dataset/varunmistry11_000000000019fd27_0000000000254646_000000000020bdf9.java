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
        Comparator<Interval> compareByStart = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start > o2.start)
                    return 1;
                else
                    return 0;
            }
        };
        Collections.sort(list, compareByStart);
        int[] startTime = new int[2];
        startTime[0] = Integer.MAX_VALUE;
        startTime[1] = Integer.MAX_VALUE;
        int person1 = 0, person2 = 1;
        char[] c = {'C', 'J'};
        //int cStartTime = Integer.MAX_VALUE, jStartTime = Integer.MAX_VALUE;
        for (int i = list.size() - 1; i >= 0; i--) {
            boolean selected = false;
            Interval interval = list.get(i);
            if (startTime[person1] > startTime[person2]) {
                int temp = person1;
                person1 = person2;
                person2 = temp;
            }
            if (interval.end <= startTime[person1]) {
                selected = true;
                interval.partner = c[person1];
                startTime[person1] = interval.start;
            }
            if (!selected && interval.end <= startTime[person2]) {
                selected = true;
                interval.partner = c[person2];
                startTime[person2] = interval.start;
            }
            if (!selected) {
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
