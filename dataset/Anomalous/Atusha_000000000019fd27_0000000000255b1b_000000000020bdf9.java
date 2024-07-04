import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static ArrayList<Range> rangeForC = new ArrayList<>();
    static ArrayList<Range> rangeForJ = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (caseNumber <= t) {
            rangeForC.clear();
            rangeForJ.clear();
            ArrayList<Activity> activities = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());

            Parent C = new Parent(1);
            Parent J = new Parent(2);

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                activities.add(new Activity(start, end));
            }

            for (Activity activity : activities) {
                if (isAvailable(C, activity.getStart(), activity.getEnd())) {
                    activity.setAssignedTo("C");
                } else if (isAvailable(J, activity.getStart(), activity.getEnd())) {
                    activity.setAssignedTo("J");
                }
            }

            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            for (Activity activity : activities) {
                if (activity.getAssignedTo() != null) {
                    result.append(activity.getAssignedTo());
                } else {
                    impossible = true;
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    break;
                }
            }

            if (!impossible) {
                System.out.println("Case #" + caseNumber + ": " + result.toString());
            }

            caseNumber++;
        }

        br.close();
    }

    private static boolean isAvailable(Parent parent, int start, int end) {
        ArrayList<Range> ranges = (parent.getId() == 1) ? rangeForC : rangeForJ;

        for (Range range : ranges) {
            if ((end > range.getStart() && start < range.getStart()) ||
                (start < range.getEnd() && end > range.getEnd()) ||
                (start > range.getStart() && end < range.getEnd())) {
                return false;
            }
        }

        ranges.add(new Range(start, end));
        return true;
    }
}

class Activity {
    private int start;
    private int end;
    private String assignedTo;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}

class Parent {
    private int id;

    public Parent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

class Range {
    private int start;
    private int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}