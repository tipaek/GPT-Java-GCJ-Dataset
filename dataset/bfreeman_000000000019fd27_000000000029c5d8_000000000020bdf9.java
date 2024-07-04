import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import static java.util.Comparator.comparing;

public class Solution {
    public final static Scanner in = new Scanner(System.in);

    public static class Act {
        public int start;
        public int end;

        public Act(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int start() {
            return this.start;
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
        ArrayList<Act> actsList = new ArrayList<>(numActs);
        for (int i = 0; i < numActs; i++) {
            actsList.add(new Act(in.nextInt(), in.nextInt()));
        }
        //Collections.sort(acts, (Act a1, Act a2) -> (a1.start - a2.start));
        Collections.sort(actsList, comparing(Act::start));
        Act[] acts = new Act[numActs];
        acts = actsList.toArray(acts);
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
