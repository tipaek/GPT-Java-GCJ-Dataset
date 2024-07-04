import java.util.*;
import java.io.*;

public class ParentingPartneringReturns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int test = 1; test <= testCases; ++test) {
            int activityCount = scanner.nextInt();
            int[] minutes = new int[24 * 60];
            char[] schedule = new char[activityCount];
            boolean cameronBusy = false, jamieBusy = false;
            LinkedHashMap<Integer, Integer> activities = new LinkedHashMap<>();

            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.put(start, end);
                for (int j = start; j < end; j++) {
                    minutes[j]++;
                }
            }

            List<Integer> startTimes = new ArrayList<>(activities.keySet());
            boolean isImpossible = false;
            int ongoingActivities = 0, cameronEnd = -1, jamieEnd = -1;

            for (int minute = 0; minute < 24 * 60; minute++) {
                if (minute == cameronEnd) {
                    cameronBusy = false;
                    ongoingActivities--;
                }
                if (minute == jamieEnd) {
                    jamieBusy = false;
                    ongoingActivities--;
                }
                if (minutes[minute] > 2) {
                    isImpossible = true;
                    break;
                } else if (minutes[minute] > 0) {
                    if (ongoingActivities == 0) {
                        ongoingActivities = 1;
                        cameronBusy = true;
                        cameronEnd = activities.get(minute);
                        schedule[startTimes.indexOf(minute)] = 'C';
                    } else if (ongoingActivities == 1 && minutes[minute] == 2) {
                        ongoingActivities = 2;
                        if (cameronBusy) {
                            jamieBusy = true;
                            jamieEnd = activities.get(minute);
                            schedule[startTimes.indexOf(minute)] = 'J';
                        } else {
                            cameronBusy = true;
                            cameronEnd = activities.get(minute);
                            schedule[startTimes.indexOf(minute)] = 'C';
                        }
                    }
                }
            }

            String result = new String(schedule);
            if (isImpossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + test + ": " + result);
            }
        }
    }
}