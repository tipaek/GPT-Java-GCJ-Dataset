
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

            activities = sortActivitiesStartTime(activities);
            
            solution[c] = processActivities(activities, 0);


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

    private static String processActivities(int[][] x, int index) {
        String s ="";

        if (index == x.length) return s;

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




