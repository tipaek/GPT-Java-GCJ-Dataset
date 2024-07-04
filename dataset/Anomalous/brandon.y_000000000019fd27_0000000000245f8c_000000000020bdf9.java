import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int[][] masterSched = new int[1440][2];
            boolean impossible = false;

            int w = in.nextInt();
            int[][] answerKey = new int[w][2];
            int[][] activitiesList = new int[w][3];

            for (int j = 0; j < w; j++) {
                activitiesList[j][0] = in.nextInt();
                activitiesList[j][1] = in.nextInt();
                activitiesList[j][2] = j;
            }

            Arrays.sort(activitiesList, Comparator.comparingInt(a -> a[0]));

            for (int j = 0; j < w; j++) {
                int startTime = activitiesList[j][0];
                int endTime = activitiesList[j][1];
                int activityReference = activitiesList[j][2];
                boolean cameronAvailable = checkAvailability(masterSched, startTime, endTime, 0);
                boolean jamieAvailable = checkAvailability(masterSched, startTime, endTime, 1);

                if (cameronAvailable) {
                    fillSchedule(masterSched, startTime, endTime, 0);
                    answerKey[j] = new int[]{activityReference, 1};
                } else if (jamieAvailable) {
                    fillSchedule(masterSched, startTime, endTime, 1);
                    answerKey[j] = new int[]{activityReference, 2};
                } else {
                    impossible = true;
                    break;
                }
            }

            String answer = impossible ? "IMPOSSIBLE" : generateAnswer(answerKey);
            System.out.println("Case #" + i + ": " + answer);
        }
    }

    private static boolean checkAvailability(int[][] masterSched, int startTime, int endTime, int person) {
        for (int k = startTime; k < endTime; k++) {
            if (masterSched[k][person] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void fillSchedule(int[][] masterSched, int startTime, int endTime, int person) {
        for (int k = startTime; k < endTime; k++) {
            masterSched[k][person] = 1;
        }
    }

    private static String generateAnswer(int[][] answerKey) {
        Arrays.sort(answerKey, Comparator.comparingInt(a -> a[0]));
        StringBuilder answer = new StringBuilder();
        for (int[] key : answerKey) {
            answer.append(key[1] == 1 ? 'C' : 'J');
        }
        return answer.toString();
    }
}