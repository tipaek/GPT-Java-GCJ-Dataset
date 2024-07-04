import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    boolean canMakeIt(int newActivity, List<Integer> activities, int start[], int end[]) {
        boolean canMakeIt = true;
        Iterator<Integer> it = activities.iterator();
        for (Integer activityToCheck : activities) {
            if ((start[activityToCheck] < start[newActivity] && start[newActivity] < end[activityToCheck])
                    || (start[activityToCheck] < end[newActivity] && end[newActivity] < end[activityToCheck])) {
                canMakeIt = false;
            }
        }
        return canMakeIt;
    }

    private String schedule(int start[], int end[]) {
        StringBuffer sb = new StringBuffer();
        List cActivities = new ArrayList<Integer>();
        List jActivities = new ArrayList<Integer>();
        for (int j = 0; j < start.length; j++) {
            if (canMakeIt(j, cActivities, start, end)) {
                cActivities.add(j);
                sb.append("C");
            } else if (canMakeIt(j, jActivities, start, end)) {
                jActivities.add(j);
                sb.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }

    private void run() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int intervals = sc.nextInt();
            int start[] = new int[intervals];
            int end[] = new int[intervals];
            for (int j = 0; j < intervals; j++) {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
            }
            System.out.println("Case #" + i + ": " + schedule(start, end));
        }
        sc.close();
    }

    public static void main(String args[]) {
        new Solution().run();
    }

}
