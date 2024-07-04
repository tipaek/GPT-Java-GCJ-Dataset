import java.util.*;
import java.io.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    static boolean isValid(Interval[] intervals) {
        for (int i = 0; i < intervals.length; ++i) {
            int count = 0;
            int start1 = intervals[i].start;
            int end1 = intervals[i].end;
            HashSet<Integer> set = new HashSet<>();
            set.add(end1);
            
            for (int j = i + 1; j < intervals.length; ++j) {
                int start2 = intervals[j].start;
                int end2 = intervals[j].end;

                if (end2 >= start1 && end2 < end1 && !set.contains(start2)) {
                    ++count;
                }

                if (set.contains(start2)) {
                    set.remove(start2);
                }

                set.add(end2);
            }
            
            if (count >= 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; ++t) {
            int numIntervals = Integer.parseInt(scanner.nextLine());
            Interval[] intervals = new Interval[numIntervals];

            for (int i = 0; i < numIntervals; ++i) {
                int start = Integer.parseInt(scanner.next());
                int end = Integer.parseInt(scanner.next());
                intervals[i] = new Interval(start, end);
            }
            scanner.nextLine();

            if (!isValid(intervals)) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                StringBuilder result = new StringBuilder();
                result.append("J");
                char currentChar = 'J';
                int previousEnd = intervals[0].end;

                for (int i = 1; i < intervals.length; ++i) {
                    int currentStart = intervals[i].start;

                    if (currentStart < previousEnd) {
                        currentChar = (currentChar == 'C') ? 'J' : 'C';
                    }
                    result.append(currentChar);
                    previousEnd = intervals[i].end;
                }
                System.out.printf("Case #%d: %s\n", t, result.toString());
            }
        }
        scanner.close();
    }
}