import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = scanner.nextInt();
        for (int curCase = 1; curCase <= numCases; curCase++) {
            int numJobs = scanner.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int job = 0; job < numJobs; job++) {
                intervals.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }
            List<Interval> originalIntervals = new ArrayList<>(intervals);
            Collections.sort(intervals);
            String result = assignJobs(intervals, originalIntervals);
            System.out.println("Case #" + curCase + ": " + result);
        }
        scanner.close();
    }

    private static String assignJobs(List<Interval> sortedIntervals, List<Interval> originalIntervals) {
        HashMap<Interval, String> jobAssignments = new HashMap<>();
        int lastEndC = 0;
        int lastEndJ = 0;

        for (Interval interval : sortedIntervals) {
            if (interval.start >= lastEndC) {
                jobAssignments.put(interval, "C");
                lastEndC = interval.end;
            } else if (interval.start >= lastEndJ) {
                jobAssignments.put(interval, "J");
                lastEndJ = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (Interval interval : originalIntervals) {
            result.append(jobAssignments.get(interval));
        }
        return result.toString();
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start != other.start) {
            return this.start - other.start;
        }
        return this.end - other.end;
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}