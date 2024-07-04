import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            scanner.nextLine();
            int activitiesCount = scanner.nextInt();

            List<Activity> activities = new ArrayList<>();
            List<Intersection> intersections = new ArrayList<>();

            String result = null;

            for (int a = 0; a < activitiesCount; a++) {
                scanner.nextLine();
                Activity activity = new Activity(scanner.nextInt(), scanner.nextInt());

                for (int j = 0; j < activities.size(); j++) {
                    Intersection intersection = activities.get(j).findOverlap(activity, j, activities.size());
                    if (intersection != null) {
                        for (Intersection existingIntersection : intersections) {
                            if (existingIntersection.overlaps(intersection)) {
                                result = "IMPOSSIBLE";
                                break;
                            }
                        }
                        if ("IMPOSSIBLE".equals(result)) {
                            break;
                        }
                        intersections.add(intersection);
                        activities.get(j).addIntersection(intersection);
                        activity.addIntersection(intersection);
                    }
                }
                if ("IMPOSSIBLE".equals(result)) {
                    break;
                }
                activities.add(activity);
            }

            if (result == null) {
                result = assignActivities(activities, activitiesCount);
            }

            System.out.println("Case #" + tc + ": " + result);
        }
    }

    private static String assignActivities(List<Activity> activities, int activitiesCount) {
        StringBuilder result = new StringBuilder();
        for (int a = 0; a < activitiesCount; a++) {
            Activity activity = activities.get(a);
            char assignee = 'N';

            if (activity.hasIntersections()) {
                for (Intersection intersection : activity.getIntersections()) {
                    if (intersection.getA2Index() == a) {
                        char otherAssignee = activities.get(intersection.getA1Index()).getAssignedTo();
                        assignee = (otherAssignee == 'C') ? 'J' : 'C';
                    }
                }
            }
            if (assignee == 'N') {
                assignee = 'C';
            }
            activity.setAssignedTo(assignee);
            result.append(assignee);
        }
        return result.toString();
    }
}

class Activity {
    private final int start;
    private final int end;
    private char assignedTo = 'N';
    private List<Intersection> intersections = new ArrayList<>();

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Intersection findOverlap(Activity other, int a1Index, int a2Index) {
        boolean intersects = (other.start > this.start && other.start < this.end) ||
                             (other.end > this.start && other.end < this.end);

        if (intersects) {
            return new Intersection(Math.max(this.start, other.start), Math.min(this.end, other.end), a1Index, a2Index);
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

class Intersection {
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
        return (other.start > this.start && other.start < this.end) ||
               (other.end > this.start && other.end < this.end);
    }

    public int getA1Index() {
        return a1Index;
    }

    public int getA2Index() {
        return a2Index;
    }
}