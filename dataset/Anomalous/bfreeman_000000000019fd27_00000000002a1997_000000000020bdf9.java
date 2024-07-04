import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    private static final Scanner in = new Scanner(System.in);

    private static class Act {
        private final int start;
        private final int end;
        private final int id;

        private Act(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        private boolean isLaterThan(Act other) {
            return this.start > other.start || (this.start == other.start && this.end > other.end);
        }
    }

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            processCase(i);
        }
    }

    private static void processCase(int caseNum) {
        int numActs = in.nextInt();
        Act[] acts = new Act[numActs];
        for (int i = 0; i < numActs; i++) {
            acts[i] = new Act(in.nextInt(), in.nextInt(), i);
        }
        sortActs(acts);

        char[] schedule = new char[numActs];
        boolean isBusyC, isBusyJ;
        int booked = 0;

        while (booked < numActs) {
            isBusyC = isPersonBusy('C', schedule, acts, booked);
            isBusyJ = isPersonBusy('J', schedule, acts, booked);
            if (!isBusyC) {
                schedule[booked] = 'C';
            } else if (!isBusyJ) {
                schedule[booked] = 'J';
            } else {
                break;
            }
            booked++;
        }

        if (booked == numActs) {
            reorderSchedule(schedule, acts);
        }

        printResult(caseNum, booked == numActs ? new String(schedule) : "IMPOSSIBLE");
    }

    private static void sortActs(Act[] acts) {
        if (acts.length <= 1) return;

        int mid = acts.length / 2;
        Act[] left = new Act[mid];
        Act[] right = new Act[acts.length - mid];

        System.arraycopy(acts, 0, left, 0, mid);
        System.arraycopy(acts, mid, right, 0, acts.length - mid);

        sortActs(left);
        sortActs(right);
        merge(acts, left, right);
    }

    private static void merge(Act[] acts, Act[] left, Act[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].isLaterThan(right[j])) {
                acts[k++] = right[j++];
            } else {
                acts[k++] = left[i++];
            }
        }
        while (i < left.length) {
            acts[k++] = left[i++];
        }
        while (j < right.length) {
            acts[k++] = right[j++];
        }
    }

    private static boolean isPersonBusy(char person, char[] schedule, Act[] acts, int idx) {
        for (int i = idx - 1; i >= 0; i--) {
            if (schedule[i] == person && acts[i].end > acts[idx].start) {
                return true;
            }
        }
        return false;
    }

    private static void reorderSchedule(char[] schedule, Act[] acts) {
        HashMap<Integer, Character> orderMap = new HashMap<>(schedule.length);
        for (int i = 0; i < schedule.length; i++) {
            orderMap.put(acts[i].id, schedule[i]);
        }
        for (int i = 0; i < schedule.length; i++) {
            schedule[i] = orderMap.get(i);
        }
    }

    private static void printResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}