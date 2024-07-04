import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
            Collections.sort(intervals);
            System.out.println("CASE #" + curCase + ": " + assignJobs(intervals));
        }
    }

    public static String assignJobs(List<Interval> intervals) {
        StringBuilder result = new StringBuilder();
        int lastFreeC = -1;
        int lastFreeJ = -1;

        for (Interval interval : intervals) {
            if (interval.start >= lastFreeC) {
                result.append("C");
                lastFreeC = interval.end;
            } else if (interval.start >= lastFreeJ) {
                result.append("J");
                lastFreeJ = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
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
    public String toString() {
        return "[" + start + "," + end + "]";
    }

    @Override
    public int compareTo(Interval other) {
        if (this.start != other.start) {
            return this.start - other.start;
        } else {
            return this.end - other.end;
        }
    }
}