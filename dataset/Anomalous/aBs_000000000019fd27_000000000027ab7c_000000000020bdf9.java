import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    private static final int SIZE = 1441;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            ArrayList<BitSet> slots = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                BitSet slot = new BitSet(SIZE);
                slot.set(start, end);
                slots.add(slot);
            }

            String result = scheduleActivities(slots, N);
            System.out.printf("Case #%d: %s\n", i, result);
        }
        scanner.close();
    }

    private static String scheduleActivities(ArrayList<BitSet> slots, int N) {
        if (N == 2) {
            return "CJ";
        }

        StringBuilder schedule = new StringBuilder("C");
        boolean conflictFound = false;

        for (int i = 0; i < N - 2 && !conflictFound; i++) {
            BitSet currentSlot = slots.get(i);
            for (int j = i + 1; j < N && !conflictFound; j++) {
                BitSet nextSlot = slots.get(j);
                BitSet intersection = (BitSet) currentSlot.clone();
                intersection.and(nextSlot);

                if (intersection.cardinality() > 0) {
                    schedule.append(schedule.charAt(i) == 'C' ? 'J' : 'C');
                    for (int k = j + 1; k < N && !conflictFound; k++) {
                        BitSet furtherIntersection = (BitSet) intersection.clone();
                        furtherIntersection.and(slots.get(k));
                        if (furtherIntersection.cardinality() > 0) {
                            conflictFound = true;
                        }
                    }
                }
            }
        }

        if (conflictFound) {
            return "IMPOSSIBLE";
        } else {
            while (schedule.length() < N) {
                schedule.append('C');
            }
            return schedule.toString();
        }
    }
}