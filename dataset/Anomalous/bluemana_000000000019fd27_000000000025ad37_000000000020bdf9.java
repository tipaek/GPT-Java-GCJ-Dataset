import java.io.*;
import java.util.Arrays;

public class Solution {
    
    private enum Parent {
        CAMERON,
        JAMIE
    }
    
    private static class Activity {
        private final int index;
        private final int startTime;
        private final int endTime;
        private Parent owner;
        
        public Activity(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             Writer writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            solve(reader, writer);
        }
    }

    private static void solve(BufferedReader reader, Writer writer) throws Exception {
        int testCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCount; i++) {
            solveTestCase(i, reader, writer);
        }
    }

    private static void solveTestCase(int testCaseNumber, BufferedReader reader, Writer writer) throws Exception {
        Activity[] activities = parseActivities(reader);
        activities = scheduleActivities(activities);
        printResult(testCaseNumber, activities, writer);
    }

    private static Activity[] parseActivities(BufferedReader reader) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            int startTime = Integer.parseInt(tokens[0]);
            int endTime = Integer.parseInt(tokens[1]);
            activities[i] = new Activity(i, startTime, endTime);
        }
        return activities;
    }
    
    private static Activity[] scheduleActivities(Activity[] activities) {
        Activity[] sortedActivities = Arrays.copyOf(activities, activities.length);
        Arrays.sort(sortedActivities, (a1, a2) -> {
            if (a1.startTime != a2.startTime) {
                return Integer.compare(a1.startTime, a2.startTime);
            }
            if (a1.endTime != a2.endTime) {
                return Integer.compare(a1.endTime, a2.endTime);
            }
            return Integer.compare(a1.index, a2.index);
        });
        
        int cameronBusyUntil = 0;
        int jamieBusyUntil = 0;
        
        for (Activity activity : sortedActivities) {
            if (cameronBusyUntil <= activity.startTime) {
                activity.owner = Parent.CAMERON;
                cameronBusyUntil = activity.endTime;
            } else if (jamieBusyUntil <= activity.startTime) {
                activity.owner = Parent.JAMIE;
                jamieBusyUntil = activity.endTime;
            } else {
                return null;
            }
        }
        
        return activities;
    }

    private static void printResult(int testCaseNumber, Activity[] activities, Writer writer) throws Exception {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Case #%d: ", testCaseNumber + 1));
        
        if (activities == null) {
            result.append("IMPOSSIBLE");
        } else {
            for (Activity activity : activities) {
                result.append(activity.owner.name().charAt(0));
            }
        }
        
        writer.write(result.toString());
        writer.write("\n");
        writer.flush();
    }
}