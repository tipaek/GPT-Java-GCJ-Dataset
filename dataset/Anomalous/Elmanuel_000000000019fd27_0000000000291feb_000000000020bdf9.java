import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt(), i));
            }
            
            String result = scheduleActivities(activities, N);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
        
        scanner.close();
    }

    public static String scheduleActivities(List<Activity> activities, int N) {
        activities.sort(Comparator.comparingInt(Activity::getStart));
        String[] schedule = new String[N];
        List<Activity> cameron = new LinkedList<>();
        List<Activity> jamie = new LinkedList<>();
        
        for (Activity activity : activities) {
            if (cameron.isEmpty()) {
                cameron.add(activity);
                schedule[activity.getPosition()] = "C";
            } else if (jamie.isEmpty()) {
                jamie.add(activity);
                schedule[activity.getPosition()] = "J";
            } else {
                int currentStart = activity.getStart();
                
                if (currentStart >= cameron.get(cameron.size() - 1).getEnd()) {
                    cameron.add(activity);
                    schedule[activity.getPosition()] = "C";
                } else if (currentStart >= jamie.get(jamie.size() - 1).getEnd()) {
                    jamie.add(activity);
                    schedule[activity.getPosition()] = "J";
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String s : schedule) {
            result.append(s);
        }
        
        return result.toString();
    }

    static class Activity {
        private final int start;
        private final int end;
        private final int position;
        
        Activity(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
        
        public int getStart() {
            return start;
        }
        
        public int getEnd() {
            return end;
        }
        
        public int getPosition() {
            return position;
        }
    }
}