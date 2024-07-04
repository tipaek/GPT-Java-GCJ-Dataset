import java.util.*;
import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int testN = input.nextInt();
        for (int i = 0; i < testN; i++) {
            int intervalN = input.nextInt();
            List<Interval> intervals = new ArrayList<>();
            for (int j = 0; j < intervalN; j++) {
                intervals.add(new Interval(input.nextInt(), input.nextInt(), j));
            }
            intervals.sort(Comparator.comparingInt(i1 -> i1.startT));

            StringBuilder output = new StringBuilder();
            boolean isImpossible = false;
            List<Integer> J = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
            List<Integer> C = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
            int jEnd = 0;
            int cEnd = 0;

            for (Interval interval : intervals) {
                if (canAssign(J, interval) && canAssign(C, interval)) {
                    if (jEnd >= cEnd) {
                        assignInterval(J, interval, "J");
                        jEnd = interval.endT;
                    } else {
                        assignInterval(C, interval, "C");
                        cEnd = interval.endT;
                    }
                } else if (canAssign(J, interval)) {
                    assignInterval(J, interval, "J");
                    jEnd = interval.endT;
                } else if (canAssign(C, interval)) {
                    assignInterval(C, interval, "C");
                    cEnd = interval.endT;
                } else {
                    output.append("IMPOSSIBLE");
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + (i + 1) + ": " + output);
            } else {
                intervals.sort(Comparator.comparingInt(i1 -> i1.orgIndex));
                for (Interval interval : intervals) {
                    output.append(interval.assign);
                }
                System.out.println("Case #" + (i + 1) + ": " + output);
            }
        }
    }

    private static boolean canAssign(List<Integer> arr, Interval interval) {
        return arr.contains(interval.startT) && arr.contains(interval.endT) &&
               arr.indexOf(interval.endT) - arr.indexOf(interval.startT) == interval.endT - interval.startT;
    }

    private static void assignInterval(List<Integer> arr, Interval interval, String assignee) {
        int startIdx = arr.indexOf(interval.startT);
        int endIdx = arr.indexOf(interval.endT);
        for (int l = startIdx; l < endIdx; l++) {
            arr.remove(startIdx);
        }
        interval.assign = assignee;
    }

    private static class Interval {
        int startT;
        int endT;
        int orgIndex;
        String assign = "";

        Interval(int start, int end, int index) {
            this.startT = start;
            this.endT = end;
            this.orgIndex = index;
        }
    }
}