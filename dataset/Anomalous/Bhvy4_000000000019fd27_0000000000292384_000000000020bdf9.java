import java.util.*;

class Activity {
    private int start, finish;

    public Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }
}

public class Solution {

    // Function to select activities
    public static String selectActivities(List<Activity> activities) {
        int jIndex = 0, cIndex = 1;
        StringBuilder assignment = new StringBuilder("JC");

        for (int i = 2, j = 3; i < activities.size() && j < activities.size(); ) {
            if (activities.get(i).getStart() >= activities.get(jIndex).getFinish()) {
                assignment.append("J");
                jIndex = i;
                i = j + 1;
            }
            if (activities.get(j).getStart() >= activities.get(cIndex).getFinish()) {
                assignment.append("C");
                cIndex = j;
                j = i + 1;
            }
        }

        if (assignment.length() < activities.size()) {
            return "IMPOSSIBLE";
        }
        return assignment.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numActivities = scanner.nextInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                activities.add(new Activity(scanner.nextInt(), scanner.nextInt()));
            }

            // Sort activities by their finish time
            activities.sort(Comparator.comparingInt(Activity::getFinish));

            String result = selectActivities(activities);
            System.out.println("Case #" + t + ": " + result);
        }
        scanner.close();
    }
}