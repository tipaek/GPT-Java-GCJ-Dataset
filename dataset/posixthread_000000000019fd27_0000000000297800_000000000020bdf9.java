import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    static char[] finalSchedule;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        finalSchedule = new char[1001];
        int numCases = Integer.parseInt(sc.nextLine());

        for (int k = 0; k < numCases; k++) {

            // Get the string
            int actNum = sc.nextInt();
            Activity[] acts = new Activity[actNum];

            for (int i = 0; i < actNum; i++) {
                acts[i] = new Activity(sc.nextInt(), sc.nextInt(), i);
            }

            Arrays.sort(acts);
            char[] schedule = new char[1001];
            Arrays.fill(finalSchedule, '\0');

            System.out.print("Case #" + (k + 1) + ": ");
            schedule = figureOutSchedule(acts, 0, 0, 0, schedule);
            System.out.println((schedule[0] == '0')? "IMPOSSIBLE" : new String(finalSchedule));

        }

        sc.close();
    }

    private static char[] figureOutSchedule(Activity[] acts, int actNum, int endC,
            int endJ, char[] schedule) {

        if (actNum == acts.length) {
            return schedule;
        }

        // 0 -> C
        // 1 -> J
        Activity act = acts[actNum];

        if (endC <= act.start) {
            schedule[actNum] = 'C';
            finalSchedule[act.order] = 'C';
            schedule = figureOutSchedule(acts, actNum + 1, act.end, endJ, schedule);
            if (schedule[actNum + 1] != '0') {
                return schedule;
            }
        }
        
        if (endJ <= act.start) {
            schedule[actNum] = 'J';
            finalSchedule[act.order] = 'J';
            schedule = figureOutSchedule(acts, actNum + 1, endC, act.end, schedule);
            if (schedule[actNum + 1] != '0') {
                return schedule;
            }
        }

        schedule[actNum] = '0';
        
        return schedule;
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
