import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Solution {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    private static final String CAMERON = "C";
    private static final String JAMIE = "J";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            solveCase(i);
        }
    }

    private static void solveCase(int caseNumber) {
        int n = in.nextInt();
        StringBuilder schedule = new StringBuilder();
        List<Integer> C = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        List<Range> ranges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ranges.add(new Range(in.nextInt(), in.nextInt(), i));
        }
        Collections.sort(ranges);
        for(int i = 0; i < n; i++) {
            Range r = ranges.get(i);
            int start = r.start;
            int end = r.end;
            boolean isCValid = checkIfValid(C, start, end);
            boolean isJValid = checkIfValid(J, start, end);
            if(isCValid) {
                C.add(start);
                C.add(end);
                r.setToWhom(CAMERON);
                schedule.append(CAMERON);
            } else if(isJValid) {
                J.add(start);
                J.add(end);
                r.setToWhom(JAMIE);
                schedule.append(JAMIE);
            } else {
                schedule.setLength(0);
                schedule.append(IMPOSSIBLE);
                break;
            }
        }
        ranges.sort(Comparator.comparing((Range o) -> o.position));
        String out = ranges.stream().map(x -> x.toWhom).collect(Collectors.joining());
        System.out.println("Case #" + caseNumber + ": " + (schedule.toString().equals(IMPOSSIBLE) ? IMPOSSIBLE : out));
    }

    private static boolean checkIfValid(List<Integer> personSchedule, int start, int end) {
        if(personSchedule.isEmpty())
            return true;
        for(int i = 0; i < personSchedule.size(); i += 2) {
            if(isOverlapping(start, end, personSchedule.get(i), personSchedule.get(i+1))) {
                return false;
            }
        }
        return true;
    }

    static boolean isOverlapping(int x1, int x2, int y1, int y2) {
        return x1 < y2 && y1 < x2;
    }

    static class Range implements Comparable<Range> {
        Integer start;
        Integer end;
        Integer position;
        String toWhom;

        public Range(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        public void setToWhom(String toWhom) {
            this.toWhom = toWhom;
        }

        @Override
        public int compareTo(Range o) {
            return this.start.compareTo(o.start);
        }
    }
    
}