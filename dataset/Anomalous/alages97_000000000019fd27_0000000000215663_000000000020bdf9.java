import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numberOfActivities = scanner.nextInt();
            List<TimeSchedule> schedules = new ArrayList<>();
            
            for (int i = 0; i < numberOfActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                schedules.add(new TimeSchedule(start, end, i));
            }
            
            Collections.sort(schedules);
            
            int cEndTime = 0;
            int jEndTime = 0;
            boolean possible = true;
            StringBuilder result = new StringBuilder();
            char[] assignments = new char[numberOfActivities];
            
            for (TimeSchedule schedule : schedules) {
                if (schedule.startTime >= cEndTime) {
                    assignments[schedule.id] = 'C';
                    cEndTime = schedule.endTime;
                } else if (schedule.startTime >= jEndTime) {
                    assignments[schedule.id] = 'J';
                    jEndTime = schedule.endTime;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                for (char assignment : assignments) {
                    result.append(assignment);
                }
                System.out.println("Case #" + testCase + ": " + result.toString());
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
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
            return Integer.compare(this.endTime, other.endTime);
        }
        return Integer.compare(this.startTime, other.startTime);
    }
}