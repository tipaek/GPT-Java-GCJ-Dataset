import java.util.*;

public class Solution {

    private enum Assignee {
        C, J
    }

    private static class Activity {
        private int id;
        private int start;
        private int end;
        private Assignee assignee;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Activity{" + "id=" + id + ", start=" + start + ", end=" + end + '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int testNr = 1; testNr <= t; testNr++) {
            int n = scanner.nextInt();
            List<Activity> activities = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                activities.add(new Activity(i, start, end));
            }

            activities.sort(Comparator.comparingInt(o -> o.start));

            int firstTimeAvailableC = 0;
            int firstTimeAvailableJ = 0;
            boolean isPossible = true;

            for (Activity a : activities) {
                if (a.start >= firstTimeAvailableC) {
                    // Assign the activity to C
                    a.assignee = Assignee.C;
                    firstTimeAvailableC = a.end;
                } else if (a.start >= firstTimeAvailableJ) {
                    // Assign the activity to J
                    a.assignee = Assignee.J;
                    firstTimeAvailableJ = a.end;
                } else {
                    // Impossible activity
                    isPossible = false;
                    break;
                }
            }

            System.out.print("Case #" + testNr + ": ");
            if (isPossible) {
                Assignee[] assignees = new Assignee[n];
                for (Activity activity : activities) {
                    assignees[activity.id] = activity.assignee;
                }
                StringBuilder sb = new StringBuilder();
                for (Assignee assignee : assignees) {
                    sb.append(assignee);
                }
                System.out.println(sb.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
