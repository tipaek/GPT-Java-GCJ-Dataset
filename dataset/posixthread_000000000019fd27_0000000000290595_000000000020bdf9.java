import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCases = Integer.parseInt(sc.nextLine());

        for (int k = 0; k < numCases; k++) {

            // Get the string
            int actNum = sc.nextInt();
            Activity[] acts = new Activity[actNum];

            for (int i = 0; i < actNum; i++) {
                acts[i] = new Activity(sc.nextInt(), sc.nextInt());
            }

            System.out.print("Case #" + (k + 1) + ": ");

            System.out.println(figureOutSchedule(acts));

        }

        sc.close();
    }

    private static String figureOutSchedule(Activity[] acts) {
        Arrays.sort(acts);

        int[] actorsEnd = new int[2];

        String schedule = "";

        // 0 -> C
        // 1 -> J

        for (Activity act : acts) {
            // Update actors
            if (actorsEnd[0] > act.start && actorsEnd[1] > act.start) {
                return "IMPOSSIBLE";
            }

            else if (actorsEnd[0] <= act.start) {
                actorsEnd[0] = act.end;
                schedule += "C";
            } else if (actorsEnd[1] <= act.start) {
                actorsEnd[1] = act.end;
                schedule += "J";
            }

        }
        return schedule;
    }
}


class Activity implements Comparable<Activity> {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
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
