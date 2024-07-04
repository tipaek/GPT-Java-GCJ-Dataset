import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    private static final int SIZE = 1441;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int numIntervals = scanner.nextInt();
            ArrayList<BitSet> intervals = new ArrayList<>();

            for (int intervalIndex = 0; intervalIndex < numIntervals; intervalIndex++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                BitSet interval = new BitSet(SIZE);
                interval.set(start, end);
                intervals.add(interval);
            }

            String result = assignIntervals(numIntervals, intervals);
            System.out.printf("Case #%d: %s\n", caseNumber, result);
        }
    }

    private static String assignIntervals(int numIntervals, ArrayList<BitSet> intervals) {
        if (numIntervals == 2) {
            return "CJ";
        }

        StringBuilder assignment = new StringBuilder("C");
        boolean isImpossible = false;

        for (int i = 0; i < numIntervals - 2 && !isImpossible; i++) {
            BitSet current = intervals.get(i);

            for (int j = i + 1; j < numIntervals && !isImpossible; j++) {
                BitSet next = intervals.get(j);
                BitSet overlap = (BitSet) current.clone();
                overlap.and(next);

                if (overlap.cardinality() > 0) {
                    assignment.append(assignment.charAt(i) == 'C' ? "J" : "C");

                    for (int k = j + 1; k < numIntervals && !isImpossible; k++) {
                        BitSet furtherOverlap = (BitSet) overlap.clone();
                        furtherOverlap.and(intervals.get(k));

                        if (furtherOverlap.cardinality() > 0) {
                            isImpossible = true;
                        }
                    }
                }
            }
        }

        if (isImpossible) {
            return "IMPOSSIBLE";
        }

        while (assignment.length() < numIntervals) {
            assignment.append("C");
        }

        return assignment.toString();
    }
}