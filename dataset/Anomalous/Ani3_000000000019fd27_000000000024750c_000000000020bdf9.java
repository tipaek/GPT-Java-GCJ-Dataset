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
                boolean cameronAvailable = true;
                boolean jamieAvailable = true;

                for (int k = startTime; k < endTime; k++) {
                    if (masterSched[k][0] == 1) {
                        cameronAvailable = false;
                        break;
                    }
                }

                if (cameronAvailable) {
                    for (int k = startTime; k < endTime; k++) {
                        masterSched[k][0] = 1;
                    }
                    answerKey[j] = new int[] {activityReference, 1};
                } else {
                    for (int k = startTime; k < endTime; k++) {
                        if (masterSched[k][1] == 1) {
                            jamieAvailable = false;
                            break;
                        }
                    }

                    if (jamieAvailable) {
                        for (int k = startTime; k < endTime; k++) {
                            masterSched[k][1] = 1;
                        }
                        answerKey[j] = new int[] {activityReference, 2};
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            if (impossible) {
                answer.append("IMPOSSIBLE");
            } else {
                Arrays.sort(answerKey, Comparator.comparingInt(a -> a[0]));

                for (int[] key : answerKey) {
                    answer.append(key[1] == 1 ? "C" : "J");
                }
            }

            System.out.println("Case #" + i + ": " + answer);
        }
    }
}