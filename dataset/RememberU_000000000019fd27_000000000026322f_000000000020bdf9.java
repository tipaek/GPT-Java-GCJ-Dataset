
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
            int[][] activities = new int[noActivities][2];
            for (int activity = 0; activity < noActivities; activity++) {
                activities[activity][0] = input.nextInt();
                activities[activity][1] = input.nextInt();
            }

            int[][] activitiesOrdered = sortActivitiesStartTime(activities);
            String pp = "";
            String sol = processActivities(activitiesOrdered);
            if (!"IMPOSSIBLE".equalsIgnoreCase(sol)) {

                for (int i=0; i<activities.length;i++) {
                    pp += search(activitiesOrdered,activities[i][0], activities[i][1], sol);
                }
            } else pp = "IMPOSSIBLE";
            solution[c] = pp;


        }


        for (int i = 0; i < testCases; i++) {
            System.out.format("Case #%d: %s \n", i + 1, solution[i]);
        }
    }

    private static int[][] sortActivitiesStartTime(int[][] x) {

        Arrays.sort(x, new java.util.Comparator<int[]>(){
            public int compare(int[]a,int[]b){
                return a[0]-b[0];
            }});

        return x;
    }

    private static String search(int[][] ordered, int start, int end, String solution) {

        for (int i=0; i<ordered.length;i++) {
            if (ordered[i][0] == start && ordered[i][1] == end) {
                return "" + solution.charAt(i);
            }
        }
        return "";
    }

    private static String processActivities(int[][] x) {
        String s ="";

        int jEnd = 0;
        int cEnd = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i][0] >= jEnd) {
                s += "J";
                jEnd = x[i][1];
                continue;
            }
            if (x[i][0] >= cEnd) {
                s += "C";
                cEnd = x[i][1];
                continue;
            }
            s = "IMPOSSIBLE";
            break;
        }
        return s;
    }
}




