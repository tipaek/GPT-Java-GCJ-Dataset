
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {

        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = input.nextInt();
        String[] solution = new String[testCases];
        for (int c = 0; c < testCases; c++) {
            int noActivities = input.nextInt();
            int[][] activities = new int[noActivities][4];
            for (int activity = 0; activity < noActivities; activity++) {
                activities[activity][0] = input.nextInt();
                activities[activity][1] = input.nextInt();
                activities[activity][2] = activity;
            }

            int[][] activitiesOrderedAndProcessed = processActivities(sortActivitiesStartTime(activities, true));
            String pp = "";
            int[][] sol = sortActivitiesStartTime(activitiesOrderedAndProcessed, false);

            for (int i = 0; i < sol.length; i++) {
                if (sol[i][3] == 2) {
                    pp = "IMPOSSIBLE";
                    break;
                } else {
                    pp += (sol[i][3] == 0) ? "J" : "C";
                }
            }

            solution[c] = pp;


        }


        for (int i = 0; i < testCases; i++) {
            System.out.format("Case #%d: %s \n", i + 1, solution[i]);
        }
    }

    private static int[][] sortActivitiesStartTime(int[][] x, boolean flag) {

        if (flag) {
            Arrays.sort(x, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
        } else {
            Arrays.sort(x, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[2] - b[2];
                }
            });
        }

        return x;
    }

    private static int[][] processActivities(int[][] x) {

        int jEnd = 0;
        int cEnd = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i][0] >= jEnd) {
                x[i][3] = 0;
                jEnd = x[i][1];
                continue;
            }
            if (x[i][0] >= cEnd) {
                x[i][3] = 1;
                cEnd = x[i][1];
                continue;
            }
            x[i][3] = 2;
            break;
        }
        return x;
    }
}




