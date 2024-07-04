import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int activityCount = scanner.nextInt();
            List<int[]> activities = new ArrayList<>();
            
            for (int i = 0; i < activityCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new int[]{start, end});
            }

            Partner cameron = new Partner();
            Partner jamie = new Partner();
            StringBuilder schedule = new StringBuilder();

            for (int[] activity : activities) {
                int start = activity[0];
                int end = activity[1];

                if (cameron.isAvailable(start, end)) {
                    cameron.assign(start, end);
                    schedule.append('C');
                } else if (jamie.isAvailable(start, end)) {
                    jamie.assign(start, end);
                    schedule.append('J');
                } else {
                    schedule.setLength(0);
                    schedule.append("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
        }
        scanner.close();
    }
}

class Partner {
    private int startTime;
    private int endTime;

    public Partner() {
        this.startTime = 0;
        this.endTime = 0;
    }

    public boolean isAvailable(int start, int end) {
        return this.endTime <= start || this.startTime >= end;
    }

    public void assign(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }
}