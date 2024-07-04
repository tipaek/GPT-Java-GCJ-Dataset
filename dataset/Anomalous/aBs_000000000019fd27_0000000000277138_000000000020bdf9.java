import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    private static final int SIZE = 1441;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            String result = determineSchedule(N, scanner);
            System.out.printf("Case #%d: %s\n", i, result);
        }
    }

    private static String determineSchedule(int N, Scanner scanner) {
        if (N == 2) {
            return "CJ";
        }

        ArrayList<BitSet> slots = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            BitSet bitSet = new BitSet(SIZE);
            bitSet.set(start, end);
            slots.add(bitSet);
        }

        String schedule = "C";
        boolean conflictFound = false;

        for (int j = 0; j < N - 2 && !conflictFound; j++) {
            BitSet current = slots.get(j);

            for (int k = j + 1; k < N && !conflictFound; k++) {
                BitSet next = slots.get(k);
                BitSet overlap = (BitSet) current.clone();
                overlap.and(next);

                if (overlap.cardinality() > 0) {
                    schedule += (schedule.charAt(j) == 'C') ? "J" : "C";

                    for (int l = k + 1; l < N && !conflictFound; l++) {
                        BitSet furtherOverlap = (BitSet) overlap.clone();
                        BitSet furtherSlot = slots.get(l);
                        furtherOverlap.and(furtherSlot);

                        if (furtherOverlap.cardinality() > 0) {
                            conflictFound = true;
                        }
                    }
                }
            }
        }

        if (conflictFound) {
            return "IMPOSSIBLE";
        }

        int remaining = N - schedule.length();
        for (int m = 0; m < remaining; m++) {
            schedule += "C";
        }

        return schedule;
    }
}