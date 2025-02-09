import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static class Act {
        public int start;
        public int end;
        public int id;

        public Act(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        public boolean compare(Act other) {
            return this.start > other.start || (this.start == other.start && this.end > other.end);
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
            runCase(i + 1, numActs, acts);
        }
    }

    public static void runCase(int caseNum, int numActs, Act[] acts) {
        sort(acts);

        char[] schedule = new char[numActs];
        int booked = 0;
        for (; booked < numActs; booked++) {
            boolean busyC = updateBusy('C', schedule, acts, booked);
            boolean busyJ = updateBusy('J', schedule, acts, booked);
            if (!busyC) {
                schedule[booked] = 'C';
            } else if (!busyJ) {
                schedule[booked] = 'J';
            } else {
                break;
            }
        }

        sort(schedule, acts);

        printCaseResult(caseNum, booked == numActs ? new String(schedule) : "IMPOSSIBLE");
    }

    public static void sort(char[] schedule, Act[] acts) {
        HashMap<Integer, Character> order = new HashMap<>(schedule.length);
        for (int i = 0; i < schedule.length; i++) {
            order.put(acts[i].id, schedule[i]);
        }
        for (int i = 0; i < schedule.length; i++) {
            schedule[i] = order.get(i);
        }
    }

    public static void sort(Act[] acts) {
        if (acts.length <= 1) {
            return;
        }
        if (acts.length == 2) {
            if (acts[0].compare(acts[1])) {
                swap(acts, 0, 1);
            }
            return;
        }
        int halfway = acts.length / 2;
        Act[] acts1 = new Act[halfway];
        Act[] acts2 = new Act[acts.length - halfway];
        System.arraycopy(acts, 0, acts1, 0, halfway);
        System.arraycopy(acts, halfway, acts2, 0, acts.length - halfway);
        sort(acts1);
        sort(acts2);
        combine(acts, acts1, acts2);
    }

    public static void combine(Act[] acts, Act[] acts1, Act[] acts2) {
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < acts.length; i++) {
            if (idx1 == acts1.length || (idx2 != acts2.length && acts1[idx1].compare(acts2[idx2]))) {
                acts[i] = acts2[idx2++];
            } else {
                acts[i] = acts1[idx1++];
            }
        }
    }

    public static void swap(Act[] acts, int i, int j) {
        Act temp = acts[i];
        acts[i] = acts[j];
        acts[j] = temp;
    }

    public static boolean updateBusy(char p, char[] schedule, Act[] acts, int idx) {
        int last = -1;
        for (int i = idx - 1; i >= 0; i--) {
            if (schedule[i] == p) {
                last = i;
                break;
            }
        }
        return last != -1 && acts[last].end > acts[idx].start;
    }

    public static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}