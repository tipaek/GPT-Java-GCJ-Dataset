import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int test = 1; test <= t; ++test) {
            int n = in.nextInt(); // Number of activities during the day
            int[] dayMinutes = new int[24 * 60]; // Array for each minute of the day
            char[] output = new char[n]; // Output array for each activity
            boolean isCameronBusy = false, isJamieBusy = false;
            LinkedHashMap<Integer, Integer> activities = new LinkedHashMap<>();

            final int INVALID_MINUTE = 24 * 60 + 1; // Invalid minute value
            int stopCameron = INVALID_MINUTE, stopJamie = INVALID_MINUTE;

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.put(start, end);

                // Mark the minutes of the activity
                for (int j = start; j < end; j++) {
                    dayMinutes[j]++;
                }
            }

            List<Integer> startTimes = new ArrayList<>(activities.keySet());
            boolean impossible = false;
            int ongoingActivities = 0;

            for (int minute = 0; minute < 24 * 60; minute++) {
                if (minute == stopCameron) {
                    isCameronBusy = false;
                    ongoingActivities--;
                }
                if (minute == stopJamie) {
                    isJamieBusy = false;
                    ongoingActivities--;
                }
                if (dayMinutes[minute] > 2) {
                    impossible = true;
                    break;
                } else if (dayMinutes[minute] > 0) {
                    if (ongoingActivities == 0) {
                        ongoingActivities = 1;
                        isCameronBusy = true;
                        stopCameron = activities.get(minute);
                        output[startTimes.indexOf(minute)] = 'C';
                    } else if (ongoingActivities == 1 && dayMinutes[minute] == 2) {
                        ongoingActivities = 2;
                        if (isCameronBusy) {
                            isJamieBusy = true;
                            stopJamie = activities.get(minute);
                            output[startTimes.indexOf(minute)] = 'J';
                        } else {
                            isCameronBusy = true;
                            stopCameron = activities.get(minute);
                            output[startTimes.indexOf(minute)] = 'C';
                        }
                    }
                }
            }

            String result = new String(output);
            if (impossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + result);
            }
        }
    }
}