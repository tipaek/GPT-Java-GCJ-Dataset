import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static class Period {
        int index;
        int start;
        int end;
        //
        Period(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsCount = sc.nextInt();
        //
        for (int i = 1; i <= testsCount; i++) {
            Period[] ps = readPeriods(sc);
            System.out.println("Case #" + i + ": " + checkPeriods(ps));
        }
        //
        sc.close();
    }

    private static Period[] readPeriods(Scanner sc) {
        sc.nextLine();
        int count = sc.nextInt();
        Period[] ps = new Period[count];
        for (int i = 0; i < count; i++) {
            sc.nextLine();
            int start = sc.nextInt();
            int end = sc.nextInt();
            ps[i] = new Period(i, start, end);
        }
        return ps;
    }

    private static String checkPeriods(Period[] ps) {
        if (ps.length == 1) {
            return "C";
        }
        //
        Arrays.sort(ps, (p1, p2) -> p1.start - p2.start);
        char[] schedule = new char[ps.length];
        Period c = ps[0];
        schedule[ps[0].index] = 'C';
        Period j = ps[1];
        schedule[ps[1].index] = 'J';
        for (int i = 2; i < ps.length; i++) {
            if (c.end <= ps[i].start) {
                c = ps[i];
                schedule[ps[i].index] = 'C';
            } else if (j.end <= ps[i].start) {
                j = ps[i];
                schedule[ps[i].index] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        //
        return String.valueOf(schedule);
    }
}