import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int t1 = 0; t1 < t; t1++) {
            int n = sc.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                activities.add(new Activity(start, end, i));
            }
            Collections.sort(activities);
            int jEnd = -1;
            int cEnd = -1;
            boolean impossible = false;
            for (Activity activity : activities) {
                if (activity.getStart() >= jEnd) {
                    jEnd = activity.getEnd();
                    activity.setAssignedTo("J");
                } else if (activity.getStart() >= cEnd) {
                    cEnd = activity.getEnd();
                    activity.setAssignedTo("C");
                } else {
                    impossible = true;
                    break;
                }
            }
            System.out.print("Case #" + (t1 + 1) + ": ");
            if (impossible) {
                System.out.print("IMPOSSIBLE");
            } else {
                String[] result = new String[n];
                for (Activity activity : activities) {
                    result[activity.getIndex()] = activity.getAssignedTo();
                }
                for (String res : result) {
                    System.out.print(res);
                }
            }
            System.out.println();
        }
    }
}

class Activity implements Comparable<Activity> {
    private final int start;
    private final int end;
    private final int index;
    private String assignedTo;

    public Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getIndex() {
        return index;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public int compareTo(Activity other) {
        if (this.start != other.start) {
            return Integer.compare(this.start, other.start);
        }
        return Integer.compare(this.end, other.end);
    }
}