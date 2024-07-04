import java.util.*;
import java.io.*;

class TimeSection {
    int startTime;
    int endTime;
}

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Read number of test cases
        for (int testCase = 1; testCase <= t; ++testCase) {
            int n = in.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            ArrayList<TimeSection> cameronList = new ArrayList<>();
            ArrayList<TimeSection> jamieList = new ArrayList<>();
            TimeSection[] timeSections = new TimeSection[n];
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < n; i++) {
                timeSections[i] = new TimeSection();
                startTimes[i] = in.nextInt();
                endTimes[i] = in.nextInt();
                timeSections[i].startTime = startTimes[i];
                timeSections[i].endTime = endTimes[i];

                if (i == 0) {
                    cameronList.add(timeSections[i]);
                    schedule.append("C");
                } else {
                    boolean canAssignToCameron = true;
                    for (TimeSection section : cameronList) {
                        if (isOverlap(timeSections[i], section)) {
                            canAssignToCameron = false;
                            break;
                        }
                    }

                    if (canAssignToCameron) {
                        cameronList.add(timeSections[i]);
                        schedule.append("C");
                        continue;
                    }

                    boolean canAssignToJamie = true;
                    for (TimeSection section : jamieList) {
                        if (isOverlap(timeSections[i], section)) {
                            canAssignToJamie = false;
                            break;
                        }
                    }

                    if (canAssignToJamie) {
                        jamieList.add(timeSections[i]);
                        schedule.append("J");
                    } else {
                        schedule = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
            }
            System.out.println("Case #" + testCase + ": " + schedule.toString());
        }
    }

    static boolean isOverlap(TimeSection t1, TimeSection t2) {
        if (t1.startTime <= t2.startTime && t1.endTime > t2.startTime) return true;
        if (t1.startTime < t2.endTime && t1.endTime >= t2.endTime) return true;
        if (t1.startTime >= t2.startTime && t1.endTime <= t2.endTime) return true;
        return false;
    }
}