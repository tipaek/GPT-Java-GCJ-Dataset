import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int n = 0; n < t; n++) {
            solveProblem3(scanner, n + 1);
        }
    }
    
    public static void solveProblem3(Scanner scanner, int caseNumber) {
        int numActivities = scanner.nextInt();
        char[] schedule = new char[numActivities];
        int[][] times = new int[numActivities][3];
        String result = "";

        for (int i = 0; i < numActivities; i++) {
            int startTime = scanner.nextInt();
            int endtime = scanner.nextInt();

            times[i][0] = startTime;
            times[i][1] = endtime;
            times[i][2] = i;
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        int cEndtime = 0;
        int jEndtime = 0;
        for (int i = 0; i < numActivities; i++) {
            int startTime = times[i][0];
            int endTime = times[i][1];
            int activityNum = times[i][2];

            // try assigning c

            if (startTime >= cEndtime) {
                schedule[activityNum] = 'C';
                cEndtime = endTime;
                continue;
            }

            // try assigning j
            if (startTime >= jEndtime) {
                schedule[activityNum] = 'J';
                jEndtime = endTime;
                continue;
            }


            // else we can't do it
            result = "IMPOSSIBLE";
            break;
        }

        if (result.equals("")) {
            result = new String(schedule);
        }

        System.out.println("Case #" + caseNumber + ": " + result);
    }
}