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

            TEST_CASE: for (int a = 0; a < activitiesCount; a++) {
                in.nextLine();
                Activity activity = new Activity(in.nextInt(), in.nextInt());

                for (int j = 0; j < activities.size(); j++) {
                    Intersection intersection = activities.get(j).overlaps(activity, j, activities.size());
                    if (intersection != null) {
                        for (Intersection existingIntersection : intersections) {
                            if (existingIntersection.overlaps(intersection)) {
                                result = "IMPOSSIBLE";
                                break TEST_CASE;
                            }
                        }
                        intersections.add(intersection);
                        activities.get(j).addIntersection(intersection);
                        activity.addIntersection(intersection);
                    }
                }
                activities.add(activity);
            }

            if (result == null) {
                result = buildResult(activities);
            }

            System.out.println("Case #" + tc + ": " + result);
        }
    }

    private static String buildResult(List<Activity> activities) {
        StringBuilder result = new StringBuilder();
        for (int a = 0; a < activities.size(); a++) {
            Activity activity = activities.get(a);
            char assignee = 'N';
            if (activity.hasIntersections()) {
                for (Intersection intersection : activity.intersections) {
                    if (intersection.a2Index == a) {
                        char otherAssignee = activities.get(intersection.a1Index).assignedTo;
                        assignee = (otherAssignee == 'C') ? 'J' : 'C';
                    }
                }
            }
            if (assignee == 'N') {
                assignee = 'C';
            }
            activity.assignedTo = assignee;
            result.append(assignee);
        }
        return result.toString();
    }

    static class Activity {
        int start;
        int end;
        char assignedTo = 'N';
        List<Intersection> intersections = new ArrayList<>();

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        Intersection overlaps(Activity other, int a1Index, int a2Index) {
            boolean intersects = (other.start < end && other.end > start);
            if (intersects) {
                return new Intersection(Math.max(start, other.start), Math.min(end, other.end), a1Index, a2Index);
            }
            return null;
        }

        void addIntersection(Intersection intersection) {
            intersections.add(intersection);
        }

        boolean hasIntersections() {
            return !intersections.isEmpty();
        }
    }

    static class Intersection {
        int start;
        int end;
        int a1Index;
        int a2Index;

        Intersection(int start, int end, int a1Index, int a2Index) {
            this.start = start;
            this.end = end;
            this.a1Index = a1Index;
            this.a2Index = a2Index;
        }

        boolean overlaps(Intersection other) {
            return (other.start < end && other.end > start);
        }
    }
}