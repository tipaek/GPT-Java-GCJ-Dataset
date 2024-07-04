import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int loops = 1; loops <= t; ++loops) {
            //Input
            int n = in.nextInt();
//            int m = in.nextInt();

            //Solution
            int[][] activities = new int[n][2];
            boolean[] assignedCameron = new boolean[n];
            boolean[] assignedJamie = new boolean[n];
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                activities[i][0] = in.nextInt();
                activities[i][1] = in.nextInt();
            }


            int min = 360000, minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (activities[i][0] < min) {
                    min = activities[i][0];
                    minIndex = i;
                }

            }

            do {
                int lastActivityEnd = activities[minIndex][1];
                assignedCameron[minIndex] = true;

                min = 360000;
                minIndex = -1;
                for (int i = 0; i < n; i++) {
                    if (assignedCameron[i])
                        continue;

                    if (activities[i][0] >= lastActivityEnd && activities[i][0] < min) {
                        min = activities[i][0];
                        minIndex = i;
                    }
                }
            } while (minIndex != -1);


            //Jamie
            min = 360000;
            minIndex = -1;
            for (int i = 0; i < n; i++) {
                if (assignedCameron[i])
                    continue;

                if (activities[i][0] < min) {
                    min = activities[i][0];
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                do {
                    int lastActivityEnd = activities[minIndex][1];
                    assignedJamie[minIndex] = true;

                    min = 360000;
                    minIndex = -1;
                    for (int i = 0; i < n; i++) {
                        if (assignedCameron[i] || assignedJamie[i])
                            continue;

                        if (activities[i][0] >= lastActivityEnd && activities[i][0] < min) {
                            min = activities[i][0];
                            minIndex = i;
                        }
                    }
                } while (minIndex != -1);
            }

            for (int i = 0; i < n; i++) {
                if (assignedCameron[i] ^ assignedJamie[i]) {
                    result.append(assignedCameron[i] ? "C" : "J");
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            //Result
            System.out.println("Case #" + loops + ": " + result.toString());
        }
    }
}