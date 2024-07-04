import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static char[] finalSchedule;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        finalSchedule = new char[1010];
        int numCases = Integer.parseInt(sc.nextLine());

        for (int k = 0; k < numCases; k++) {

            // Get the string
            int actNum = sc.nextInt();
            Activity[] acts = new Activity[actNum];

            for (int i = 0; i < actNum; i++) {
                acts[i] = new Activity(sc.nextInt(), sc.nextInt(), i);
            }

            Arrays.sort(acts);

            Arrays.fill(finalSchedule, '\0');

            System.out.print("Case #" + (k + 1) + ": ");
            System.out.println((!figureOutSchedule(acts, 0, 0, 0)) ? "IMPOSSIBLE"
                    : new String(finalSchedule));

        }

        sc.close();
    }

    private static boolean figureOutSchedule(Activity[] acts, int actNum, int endC,
            int endJ) {

        if (actNum == acts.length) {
            return true;
        }

        // 0 -> C
        // 1 -> J
        Activity act = acts[actNum];

        if (endC <= act.start) {
            finalSchedule[act.order] = 'C';
            if (figureOutSchedule(acts, actNum + 1, act.end, endJ)) {
                return true;
            } else {
                finalSchedule[act.order] = '\0';
            }
        }

        if (endJ <= act.start) {
            finalSchedule[act.order] = 'J';
            if (figureOutSchedule(acts, actNum + 1, endC, act.end)) {
                return true;
            } else {
                finalSchedule[act.order] = '\0';
            }
        }
        return false;
    }
}


class Activity implements Comparable<Activity> {
    int start;
    int end;
    int order;

    public Activity(int start, int end, int order) {
        this.start = start;
        this.end = end;
        this.order = order;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.start < other.start) {
            return -1;
        } else if (this.start > other.start) {
            return 1;
        }
        return 0;
    }

}
