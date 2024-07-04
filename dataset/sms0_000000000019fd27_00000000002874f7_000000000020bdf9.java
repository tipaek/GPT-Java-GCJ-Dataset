import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        in.useDelimiter(System.getProperty("line.separator"));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                String input = in.next();
                intervals.add(createInterval(input, j));
            }
            Collections.sort(intervals, new IntervalStartComparator());
            int timeJ=0;
            int timeC=0;
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (interval.start>= timeJ) {
                    interval.owner="J";
                    timeJ = interval.end;
                } else if(interval.start>=timeC) {
                    interval.owner="C";
                    timeC = interval.end;
                } else {
                    impossible =true;
                    break;
                }
            }
            StringBuffer output= new StringBuffer();
            if (impossible) {
                output.append("IMPOSSIBLE");
            } else {
                Collections.sort(intervals, new IntervalNumberComparator());
                for (Interval interval : intervals) {
                    output.append(interval.owner);
                }
            }
            System.out.println("Case #" + i + ": " + output);
        }
    }

    private static Interval createInterval(String input, int number) {
        String[] times = input.split(" ");
        return new Interval(Integer.parseInt(times[0]), Integer.parseInt(times[1]), number);
    }

}

class Interval {
    int start;
    int end;
    int number;
    String owner;

    public Interval(int start, int end, int number) {
        this.start = start;
        this.end = end;
        this.number = number;
    }
}

class IntervalStartComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval first, Interval second) {
        return Integer.compare(first.start, second.start);
    }
}

class IntervalNumberComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval first, Interval second) {
        return Integer.compare(first.number, second.number);
    }
}