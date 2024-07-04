import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 0;

        while (testCases-- > 0) {
            caseNumber++;
            int activitiesCount = Integer.parseInt(reader.readLine());
            LinkedList<Activity> activities = new LinkedList<>();
            ArrayList<Activity> result = new ArrayList<>();

            for (int i = 0; i < activitiesCount; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                activities.add(new Activity(start, end, i));
            }

            activities.sort(new StartTimeComparator());

            int cEndTime = -1;
            int jEndTime = -1;
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            for (int currentTime = 0; currentTime < 3600; currentTime++) {
                if (cEndTime == currentTime) cEndTime = -1;
                if (jEndTime == currentTime) jEndTime = -1;

                while (!activities.isEmpty() && activities.peekFirst().start == currentTime) {
                    if (cEndTime == -1) {
                        Activity activity = activities.removeFirst();
                        cEndTime = activity.end;
                        activity.assignedTo = 'C';
                        result.add(activity);
                    } else if (jEndTime == -1) {
                        Activity activity = activities.removeFirst();
                        jEndTime = activity.end;
                        activity.assignedTo = 'J';
                        result.add(activity);
                    } else {
                        isImpossible = true;
                        break;
                    }
                }
            }

            result.sort(new IndexComparator());
            for (Activity activity : result) {
                schedule.append(activity.assignedTo);
            }

            if (isImpossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
            }
        }
    }
}

class Activity {
    int start, end, index;
    char assignedTo;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

class StartTimeComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.start, a2.start);
    }
}

class IndexComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Integer.compare(a1.index, a2.index);
    }
}