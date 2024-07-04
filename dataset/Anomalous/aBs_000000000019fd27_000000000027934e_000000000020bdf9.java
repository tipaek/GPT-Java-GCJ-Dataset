import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    private static final int SIZE = 1441;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numIntervals = scanner.nextInt();
            String result;
            ArrayList<BitSet> intervals = new ArrayList<>();

            for (int i = 0; i < numIntervals; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                BitSet interval = new BitSet(SIZE);
                interval.set(start, end);
                intervals.add(interval);
            }

            if (numIntervals == 2) {
                result = "CJ";
            } else {
                boolean conflictFound = false;
                StringBuilder schedule = new StringBuilder("C");

                for (int i = 0; i < numIntervals - 2 && !conflictFound; i++) {
                    BitSet firstInterval = intervals.get(i);

                    for (int j = i + 1; j < numIntervals && !conflictFound; j++) {
                        BitSet secondInterval = intervals.get(j);
                        BitSet intersection = (BitSet) firstInterval.clone();
                        intersection.and(secondInterval);

                        if (intersection.cardinality() > 0) {
                            schedule.append(schedule.charAt(i) == 'C' ? 'J' : 'C');

                            for (int k = j + 1; k < numIntervals && !conflictFound; k++) {
                                BitSet thirdInterval = intervals.get(k);
                                BitSet tripleIntersection = (BitSet) intersection.clone();
                                tripleIntersection.and(thirdInterval);

                                if (tripleIntersection.cardinality() > 0) {
                                    conflictFound = true;
                                }
                            }
                        }
                    }
                }

                if (conflictFound) {
                    result = "IMPOSSIBLE";
                } else {
                    while (schedule.length() < numIntervals) {
                        schedule.append('C');
                    }
                    result = schedule.toString();
                }
            }

            System.out.printf("Case #%d: %s\n", testCase, result);
        }

        scanner.close();
    }
}