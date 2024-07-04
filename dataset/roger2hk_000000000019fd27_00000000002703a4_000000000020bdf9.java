import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int[][] timeline = new int[24 * 60][2];

            int totalActivityCount = in.nextInt();
            int[][] answerKey = new int[totalActivityCount][2];
            int activityCount = 0;

            int[][] activitiesList = new int[totalActivityCount][3];
            for (int j = 0; j < totalActivityCount; j++) {
                activitiesList[j][0] = in.nextInt();
                activitiesList[j][1] = in.nextInt();
                activitiesList[j][2] = activityCount++;
            }

            Arrays.sort(activitiesList, Comparator.comparingInt(a -> a[0]));

            boolean impossible = false;
            for (int j = 0; j < totalActivityCount; j++) {
                int startTime = activitiesList[j][0];
                int endTime = activitiesList[j][1];
                int activityReference = activitiesList[j][2];
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                for (int k = startTime; k < endTime; k++) {
                    if (timeline[k][0] == 1) {
                        cameronAvailable = false;
                    }
                }

                if (cameronAvailable) {
                    for (int k = startTime; k < endTime; k++) {
                        timeline[k][0] = 1;
                    }

                    answerKey[j] = new int[]{activityReference, 1};
                } else {
                    for (int k = startTime; k < endTime; k++) {
                        if (timeline[k][1] == 1) {
                            jamieAvailable = false;
                        }
                    }

                    if (jamieAvailable) {
                        for (int k = startTime; k < endTime; k++) {
                            timeline[k][1] = 1;
                        }
                        answerKey[j] = new int[]{activityReference, 2};
                    } else {
                        impossible = true;
                    }
                }
            }

            Arrays.sort(answerKey, Comparator.comparingInt(a -> a[0]));

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < answerKey.length; j++) {
                if (answerKey[j][1] == 1) {
                    sb.append("C");
                } else if (answerKey[j][1] == 2) {
                    sb.append("J");
                }
            }

            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" : sb.toString()));
        }
    }
}