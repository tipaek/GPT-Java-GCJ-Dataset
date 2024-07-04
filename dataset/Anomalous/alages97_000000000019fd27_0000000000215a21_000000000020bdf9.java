import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<TimeSchedule> activities = new ArrayList<>();
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new TimeSchedule(start, end, i));
            }
            
            Collections.sort(activities);
            List<AssignedActivity> assignedActivities = new ArrayList<>();
            StringBuilder schedule = new StringBuilder();
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (TimeSchedule activity : activities) {
                if (activity.startTime >= cEnd) {
                    assignedActivities.add(new AssignedActivity(activity.id, "C"));
                    cEnd = activity.endTime;
                } else if (activity.startTime >= jEnd) {
                    assignedActivities.add(new AssignedActivity(activity.id, "J"));
                    jEnd = activity.endTime;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (!possible) {
                System.out.println("Case #" + (testCase + 1) + ": IMPOSSIBLE");
            } else {
                Collections.sort(assignedActivities);
                for (AssignedActivity assignedActivity : assignedActivities) {
                    schedule.append(assignedActivity.person);
                }
                System.out.println("Case #" + (testCase + 1) + ": " + schedule.toString());
            }
        }
        
        scanner.close();
    }
}

class TimeSchedule implements Comparable<TimeSchedule> {
    int startTime;
    int endTime;
    int id;
    
    TimeSchedule(int startTime, int endTime, int id) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
    }
    
    @Override
    public int compareTo(TimeSchedule other) {
        if (this.startTime == other.startTime) {
            return this.endTime - other.endTime;
        }
        return this.startTime - other.startTime;
    }
}

class AssignedActivity implements Comparable<AssignedActivity> {
    int id;
    String person;
    
    AssignedActivity(int id, String person) {
        this.id = id;
        this.person = person;
    }
    
    @Override
    public int compareTo(AssignedActivity other) {
        return this.id - other.id;
    }
}