import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
        Map<String, Queue<String>> jobAssignments = new HashMap<>();
        int lastEndC = 0, lastEndJ = 0;

        for (Interval interval : sortedIntervals) {
            String key = interval.start + "," + interval.end;
            jobAssignments.putIfAbsent(key, new LinkedList<>());

            if (interval.start >= lastEndC) {
                jobAssignments.get(key).add("C");
                lastEndC = interval.end;
            } else if (interval.start >= lastEndJ) {
                jobAssignments.get(key).add("J");
                lastEndJ = interval.end;
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (Interval interval : originalIntervals) {
            String key = interval.start + "," + interval.end;
            resultBuilder.append(jobAssignments.get(key).poll());
        }
        return resultBuilder.toString();
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