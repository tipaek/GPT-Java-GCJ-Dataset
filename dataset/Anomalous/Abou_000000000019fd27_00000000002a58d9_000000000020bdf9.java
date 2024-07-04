import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            scanner.nextLine();
            int activityCount = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();
            List<Intersection> intersections = new ArrayList<>();

            String result = null;

            TEST_CASE: for (int i = 0; i < activityCount; i++) {
                scanner.nextLine();
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());

                for (Activity existingActivity : activities) {
                    Intersection intersection = existingActivity.checkOverlap(activity);
                    if (intersection != null) {
                        for (Intersection existingIntersection : intersections) {
                            if (existingIntersection.overlaps(intersection)) {
                                result = "IMPOSSIBLE";
                                break TEST_CASE;
                            }
                        }
                        intersections.add(intersection);
                        existingActivity.addIntersection(intersection);
                        activity.addIntersection(intersection);
                    }
                }
                activities.add(activity);
            }

            if (result == null) {
                StringBuilder resultBuilder = new StringBuilder();
                for (int i = 0; i < activities.size(); i++) {
                    Activity activity = activities.get(i);
                    char assignee = 'N';
                    if (activity.hasIntersections()) {
                        for (Intersection intersection : activity.getIntersections()) {
                            if (intersection.a2Index == i) {
                                char otherAssignee = activities.get(intersection.a1Index).getAssignedTo();
                                assignee = otherAssignee == 'C' ? 'J' : 'C';
                            }
                        }
                    }
                    if (assignee == 'N') {
                        assignee = 'C';
                    }
                    activity.setAssignedTo(assignee);
                    resultBuilder.append(assignee);
                }
                result = resultBuilder.toString();
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    static class Activity {
        private int start;
        private int end;
        private char assignedTo = 'N';
        private List<Intersection> intersections = new ArrayList<>();

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Intersection checkOverlap(Activity other) {
            boolean intersects = (other.start > start && other.start < end) ||
                                 (other.end > start && other.end < end) ||
                                 (other.start < start && other.end > end);
            if (intersects) {
                return new Intersection(Math.max(start, other.start), Math.min(end, other.end), this, other);
            }
            return null;
        }

        public void addIntersection(Intersection intersection) {
            intersections.add(intersection);
        }

        public boolean hasIntersections() {
            return !intersections.isEmpty();
        }

        public List<Intersection> getIntersections() {
            return intersections;
        }

        public char getAssignedTo() {
            return assignedTo;
        }

        public void setAssignedTo(char assignedTo) {
            this.assignedTo = assignedTo;
        }
    }

    static class Intersection {
        private int start;
        private int end;
        private int a1Index;
        private int a2Index;

        public Intersection(int start, int end, Activity a1, Activity a2) {
            this.start = start;
            this.end = end;
            this.a1Index = a1.hashCode();
            this.a2Index = a2.hashCode();
        }

        public boolean overlaps(Intersection other) {
            return (other.start > start && other.start < end) || (other.end > start && other.end < end);
        }
    }
}