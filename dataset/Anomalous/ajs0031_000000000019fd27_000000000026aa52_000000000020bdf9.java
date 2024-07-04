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
            
            String result = "";
            HashMap<String, String> assignmentMap = assignJobs(intervals);
            
            if (assignmentMap == null) {
                result = "IMPOSSIBLE";
            } else {
                StringBuilder resultBuilder = new StringBuilder();
                for (Interval interval : originalIntervals) {
                    resultBuilder.append(assignmentMap.get(interval.start + "," + interval.end));
                }
                result = resultBuilder.toString();
            }
            System.out.println("CASE #" + curCase + ": " + result);
        }
    }

    private static HashMap<String, String> assignJobs(List<Interval> intervals) {
        HashMap<String, String> assignmentMap = new HashMap<>();
        int lastFreeC = -1;
        int lastFreeJ = -1;

        for (Interval interval : intervals) {
            if (interval.start >= lastFreeC) {
                assignmentMap.put(interval.start + "," + interval.end, "C");
                lastFreeC = interval.end;
            } else if (interval.start >= lastFreeJ) {
                assignmentMap.put(interval.start + "," + interval.end, "J");
                lastFreeJ = interval.end;
            } else {
                return null;
            }
        }
        return assignmentMap;
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