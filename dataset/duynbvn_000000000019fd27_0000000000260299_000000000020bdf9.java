import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCase = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int testCase = 1; testCase <= numberOfTestCase; ++testCase) {
            int numberOfActivities = in.nextInt();
            List<TimeDuration> cList = new ArrayList<>(numberOfActivities);
            List<TimeDuration> jList = new ArrayList<>(numberOfActivities);
            String result = "";
            boolean impossible = false;
            for (int i = 0; i < numberOfActivities; i++) {
                int begin = in.nextInt();
                int end = in.nextInt();
                boolean canPutC = canPut(begin, end, cList);
                if (canPutC) {
                    cList.add(new TimeDuration(begin, end));
                    result = result + "C";
                } else {
                    boolean canPutL = canPut(begin, end, jList);
                    if (canPutL) {
                        jList.add(new TimeDuration(begin, end));
                        result = result + "J";
                    } else {
                        impossible = true;
                    }
                }
            }

            if (impossible) {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }

    public static boolean canPut(int begin, int end, List<TimeDuration> list) {
        if (list.isEmpty()) return true;
        for (TimeDuration timeDuration : list) {
            if (begin > timeDuration.begin && begin < timeDuration.end) return false;
            if (end > timeDuration.begin && end < timeDuration.end) return false;
            if (begin<=timeDuration.begin && end >= timeDuration.end) return false;
        }
        return true;
    }

    public static class TimeDuration {
        int begin;
        int end;

        public TimeDuration(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}