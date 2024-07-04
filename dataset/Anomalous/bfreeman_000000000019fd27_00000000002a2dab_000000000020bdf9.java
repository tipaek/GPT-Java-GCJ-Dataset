import java.util.Arrays;
import java.util.Comparator;
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
    }

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            int numActs = in.nextInt();
            Act[] acts = new Act[numActs];
            for (int j = 0; j < numActs; j++) {
                acts[j] = new Act(in.nextInt(), in.nextInt(), j);
            }
            processCase(i + 1, numActs, acts);
        }
    }

    private static void processCase(int caseNum, int numActs, Act[] acts) {
        Arrays.sort(acts, Comparator.comparingInt((Act act) -> act.start).thenComparingInt(act -> act.end));

        char[] schedule = new char[numActs];
        boolean[] assigned = new boolean[numActs];
        boolean possible = true;

        for (int i = 0; i < numActs; i++) {
            if (!assign('C', schedule, acts, i, assigned) && !assign('J', schedule, acts, i, assigned)) {
                possible = false;
                break;
            }
        }

        if (possible) {
            char[] finalSchedule = new char[numActs];
            for (int i = 0; i < numActs; i++) {
                finalSchedule[acts[i].id] = schedule[i];
            }
            printResult(caseNum, new String(finalSchedule));
        } else {
            printResult(caseNum, "IMPOSSIBLE");
        }
    }

    private static boolean assign(char person, char[] schedule, Act[] acts, int idx, boolean[] assigned) {
        for (int i = 0; i < idx; i++) {
            if (schedule[i] == person && acts[i].end > acts[idx].start) {
                return false;
            }
        }
        schedule[idx] = person;
        assigned[idx] = true;
        return true;
    }

    private static void printResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}