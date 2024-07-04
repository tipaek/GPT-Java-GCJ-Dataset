import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner sc;

            if (args.length > 0) {
            sc = new Scanner(new File(args[0]));
        } else {
            sc = new Scanner(System.in);
        }

        int t = sc.nextInt();
            for (int tt = 1; tt <= t; ++tt) {
            System.out.println("Case #" + tt + ": " + _s(sc));
        }
            sc.close();
    }

    static String _s(Scanner sc) {

        int n = sc.nextInt();
        HashSet<Integer> freePeriods = new HashSet();
        char result[] = new char[n];
        MyInterval periods[] = new MyInterval[n];
        for (int i = 0; i < n; ++i) {
            freePeriods.add(i);
            periods[i] = new MyInterval(sc.nextInt(), sc.nextInt());
        }
        distributeIntervals('C', freePeriods, periods, result, 0);
        distributeIntervals('J', freePeriods, periods, result, 0);

        return freePeriods.isEmpty() ? Arrays.toString(result) : "IMPOSSIBLE";
    }

    static void distributeIntervals(char person, HashSet<Integer> freePeriods, MyInterval periods[], char result[], int lastStart) {
        int starts = 1441;
        int ends = 0;
        int period = 0;
        boolean wasFound = false;
        for (Integer interval : freePeriods)
            if (lastStart <= periods[interval].s
                 && starts > periods[interval].s) {
                starts = periods[interval].s;
                ends = periods[interval].e;
                period = interval;
                wasFound = true;
            }
        if (wasFound) {
            result[period] = person;
            freePeriods.remove(period);
            distributeIntervals(person, freePeriods, periods, result, ends);
        }
    }

    static class MyInterval {
        int s, e;

        public MyInterval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}