import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = scanner.nextInt();
            List<TimeSlot> timeSlots = new ArrayList<>();
            
            for (int i = 0; i < numActivities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                timeSlots.add(new TimeSlot(start, end, i));
            }

            Collections.sort(timeSlots);
            StringBuilder result = new StringBuilder();
            List<AssignedTask> assignedTasks = new ArrayList<>();
            int cEndTime = 0;
            int jEndTime = 0;
            boolean isPossible = true;
            
            for (TimeSlot timeSlot : timeSlots) {
                if (timeSlot.start >= cEndTime) {
                    assignedTasks.add(new AssignedTask(timeSlot.id, "C"));
                    cEndTime = timeSlot.end;
                } else if (timeSlot.start >= jEndTime) {
                    assignedTasks.add(new AssignedTask(timeSlot.id, "J"));
                    jEndTime = timeSlot.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                Collections.sort(assignedTasks);
                for (AssignedTask task : assignedTasks) {
                    result.append(task.person);
                }
                System.out.println("Case #" + testCase + ": " + result);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }
}

class TimeSlot implements Comparable<TimeSlot> {
    int start;
    int end;
    int id;

    TimeSlot(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    @Override
    public int compareTo(TimeSlot other) {
        if (this.start == other.start) {
            return Integer.compare(this.end, other.end);
        }
        return Integer.compare(this.start, other.start);
    }
}

class AssignedTask implements Comparable<AssignedTask> {
    int id;
    String person;

    AssignedTask(int id, String person) {
        this.id = id;
        this.person = person;
    }

    @Override
    public int compareTo(AssignedTask other) {
        return Integer.compare(this.id, other.id);
    }
}