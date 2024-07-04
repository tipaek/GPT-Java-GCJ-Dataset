import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            int no = Integer.parseInt(br.readLine());
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < no; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(str.nextToken());
                int end = Integer.parseInt(str.nextToken());
                intervals.add(new Interval(start, end));
            }

            intervals.sort(new IntervalComparator());

            int endC = -1;
            int endJ = -1;
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (Interval interval : intervals) {
                if (interval.start >= endC) {
                    endC = interval.end;
                    result.append('C');
                } else if (interval.start >= endJ) {
                    endJ = interval.end;
                    result.append('J');
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Impossible");
            } else {
                System.out.println(result.toString());
            }
        }
    }
}

class Interval {
    public int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        return Integer.compare(o1.start, o2.start);
    }
}