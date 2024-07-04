import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int interval_count = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < interval_count; j++) {
                Interval cur = new Interval(in, j);
                intervals.add(cur);
            }

            intervals.sort(new SortByStart());

  /*          for ( Interval interval : intervals) {
                System.out.println(interval);
            }
*/
            int[] combs = new int[interval_count];
            Arrays.fill(combs, 0);
            int[] length = new int[interval_count];
            Arrays.fill(length, 2);
            int[] solution = nestedLoopOperation(combs, length, 0, intervals);

            String output = "";
            if(solution.length == 0) {
                output = "IMPOSSIBLE";
            } else {
                output = countersToPersons(solution, intervals);
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static String countersToPersons(int[] solution, List<Interval> intervals) {
        String output;
        String[] personMap = new String[2];
        personMap[0] = "C";
        personMap[1] = "J";

        String[] person_ordered = new String[solution.length];
        for (int i = 0; i < solution.length; i++) {
            String person = personMap[solution[i]];
            int location = intervals.get(i).position;
            person_ordered[location] = person;
        }

/*        StringBuilder tmp = new StringBuilder();

        for(int s : solution) {
            tmp.append(personMap[s]);
        }

        output = tmp.toString();*/
        return String.join("", person_ordered);
    }

    private static int[] nestedLoopOperation(int[] counters, int[] length, int level, List<Interval> intervals) {
        if (level == counters.length) {
            try {
                // Safe to return here as will throw if we don't successfully find a match
                return performOperation(counters, intervals);
            } catch (Exception e) {
                //System.out.println("Not a match: " + Arrays.toString(counters));
            }
        } else {
            for (counters[level] = 0; counters[level] < length[level]; counters[level]++) {
                int[] ret = nestedLoopOperation(counters, length, level + 1, intervals);
                if(ret.length != 0)
                    return ret;
            }
        }

        return new int[0];
    }

    private static int[] performOperation(int[] counters, List<Interval> intervals) throws Exception {
        //System.out.println("For counters: " + Arrays.toString(counters));
        int[] maxes = new int[2];
        for (int i = 0; i < counters.length; i++) {
            int person = counters[i];
            Interval interval = intervals.get(i);
            int cur_max = maxes[person];
            //System.out.println("Cur max: " + String.valueOf(cur_max));
            //System.out.println("Test start: " + String.valueOf(interval.start));
            if (interval.start >= cur_max) {
                maxes[person] = interval.end;
            } else {
                return new int[0];
            }
            //System.out.println(String.valueOf(person) + " has " + interval);
        }
        return counters;
    }

    private static class Interval {

        public int start;
        public int end;
        public int position;

        // Constructor reads two ints from standard in
        public Interval(Scanner in, int position) {
            start = in.nextInt();
            end = in.nextInt();
            this.position = position;
        }

        public String toString() {
            return "[ " + String.valueOf(start) + "," + String.valueOf(end) + " ]";
        }
    }

    private static class SortByStart implements Comparator<Interval> {

        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
}