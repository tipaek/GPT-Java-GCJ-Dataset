import java.util.Scanner;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static class Act {
        public int start;
        public int end;

        public Act(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean compare(Act other) {
            return this.start > other.start || (this.start == other.start && this.end > other.end);
        }
    }

    public static void main(String[] args) {
        int numCases = in.nextInt();
        for (int i = 0; i < numCases; i++) {
            runCase(i + 1);
        }
    }

    public static void runCase(int caseNum) {
        String failStr = "IMPOSSIBLE";
        int numActs = in.nextInt();
        Act[] acts = new Act[numActs];
        for (int i = 0; i < numActs; i++) {
            acts[i] = new Act(in.nextInt(), in.nextInt());
        }
        sort(acts);
        char[] schedule = new char[numActs];
        boolean busyC = false;
        boolean busyJ = false;
        boolean onReval = false;
        for (int i = 0; i < numActs; i++) {
            if (!busyC) {
                schedule[i] = 'C';
                busyC = true;
                onReval = false;
            } else if (!busyJ) {
                schedule[i] = 'J';
                busyJ = true;
                onReval = false;
            } else {
                if (onReval) {
                    break;
                } else {
                    onReval = true;
                    busyC = updateBusy('C', schedule, acts, i);
                    busyJ = updateBusy('J', schedule, acts, i);
                    i--;
                }
            }
        }
        printCaseResult(caseNum, onReval ? failStr : new String(schedule));
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
        for (int i = 0; i < halfway; i++) {
            acts1[i] = acts[i];
        }
        for (int i = 0; i < acts.length - halfway; i++) {
            acts2[i] = acts[halfway + i];
        }
        sort(acts1);
        sort(acts2);
        combine(acts, acts1, acts2);
    }

    public static void combine(Act[] acts, Act[] acts1, Act[] acts2) {
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < acts.length; i++) {
            if (idx1 == acts1.length || acts1[idx1].compare(acts2[idx2])) {
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
        for (int i = idx; i >= 0; i--) {
            if (schedule[i] == p) {
                last = i;
                break;
            }
        }
        return acts[last].end > acts[idx].start;
    }

    public static void printCaseResult(int caseNum, String result) {
        System.out.printf("Case #%d: %s%n", caseNum, result);
    }
}
