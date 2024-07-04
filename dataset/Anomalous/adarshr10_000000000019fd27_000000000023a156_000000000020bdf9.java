import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int size = scanner.nextInt();
            List<Pair> intervals = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Pair(start, end));
            }
            
            String result = solve(intervals);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    static String solve(List<Pair> intervals) {
        int n = intervals.size();
        List<Pair> cam = new ArrayList<>();
        List<Pair> jam = new ArrayList<>();
        StringBuilder assignment = new StringBuilder();

        for (Pair interval : intervals) {
            if (canAssign(cam, interval)) {
                cam.add(interval);
                assignment.append("C");
            } else if (canAssign(jam, interval)) {
                jam.add(interval);
                assignment.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        return assignment.toString();
    }

    static boolean canAssign(List<Pair> assigned, Pair newInterval) {
        for (Pair interval : assigned) {
            if (!(newInterval.end <= interval.start || newInterval.start >= interval.end)) {
                return false;
            }
        }
        return true;
    }
}

class Pair {
    int start;
    int end;

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return start == pair.start && end == pair.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}