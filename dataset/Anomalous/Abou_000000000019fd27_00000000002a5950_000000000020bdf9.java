import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int tc = 1; tc <= t; ++tc) {
            in.nextLine();
            int activitiesCount = in.nextInt();

            List<Activity> activities = new ArrayList<>();
            List<Intersection> intersections = new ArrayList<>();
            String result = null;

            for (int a = 0; a < activitiesCount; a++) {
                in.nextLine();
                Activity activity = new Activity(in.nextInt(), in.nextInt());

                for (Activity other : activities) {
                    Intersection intersection = other.overlaps(activity, activities.indexOf(other), a);
                    if (intersection != null) {
                        for (Intersection existing : intersections) {
                            if (existing.overlaps(intersection)) {
                                result = "IMPOSSIBLE";
                                break;
                            }
                        }
                        if ("IMPOSSIBLE".equals(result)) break;
                        intersections.add(intersection);
                        other.addIntersection(intersection);
                        activity.addIntersection(intersection);
                    }
                }
                if ("IMPOSSIBLE".equals(result)) break;
                activities.add(activity);
            }

            if (result == null) {
                result = "";
                for (Activity activity : activities) {
                    char assignee = 'N';
                    if (activity.hasIntersections()) {
                        for (Intersection intersection : activity.getIntersections()) {
                            if (intersection.getA2Index() == activities.indexOf(activity)) {
                                char otherAssignee = activities.get(intersection.getA1Index()).getAssignedTo();
                                assignee = (otherAssignee == 'C') ? 'J' : 'C';
                            }
                        }
                    }
                    if (assignee == 'N') assignee = 'C';
                    activity.setAssignedTo(assignee);
                    result += assignee;
                }
            }

            System.out.println("Case #" + tc + ": " + result);
        }
    }

    static class Activity {
        private final int start;
        private final int end;
        private char assignedTo = 'N';
        private final List<Intersection> intersections = new ArrayList<>();

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Intersection overlaps(Activity other, int a1Index, int a2Index) {
            boolean intersects = (other.start > start && other.start < end) ||
                                 (other.end > start && other.end < end) ||
                                 (other.start < start && other.end > end);

            if (intersects) {
                return new Intersection(Math.max(start, other.start), Math.min(end, other.end), a1Index, a2Index);
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
        private final int start;
        private final int end;
        private final int a1Index;
        private final int a2Index;

        public Intersection(int start, int end, int a1Index, int a2Index) {
            this.start = start;
            this.end = end;
            this.a1Index = a1Index;
            this.a2Index = a2Index;
        }

        public boolean overlaps(Intersection other) {
            return (other.start > start && other.start < end) ||
                   (other.end > start && other.end < end) ||
                   (other.start < start && other.end > end);
        }

        public int getA1Index() {
            return a1Index;
        }

        public int getA2Index() {
            return a2Index;
        }
    }
}