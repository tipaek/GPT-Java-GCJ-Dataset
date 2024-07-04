import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int start, end;
        char assignedTo;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
            this.assignedTo = 0;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                System.out.print("Case #");
                System.out.print(i);
                System.out.print(": ");
                processTestCase(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processTestCase(Scanner scanner) {
        int numActivities = scanner.nextInt();
        Pair[] activities = new Pair[numActivities];
        for (int i = 0; i < numActivities; i++) {
            activities[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }

        ArrayList<Pair> cameronSchedule = new ArrayList<>();
        ArrayList<Pair> jamieSchedule = new ArrayList<>();

        for (Pair activity : activities) {
            if (isValid(cameronSchedule, activity)) {
                activity.assignedTo = 'C';
                cameronSchedule.add(activity);
            } else if (isValid(jamieSchedule, activity)) {
                activity.assignedTo = 'J';
                jamieSchedule.add(activity);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
        
        for (Pair activity : activities) {
            System.out.print(activity.assignedTo);
        }
        System.out.println();
    }

    private static boolean isValid(ArrayList<Pair> schedule, Pair newActivity) {
        for (Pair existingActivity : schedule) {
            if ((existingActivity.end > newActivity.start && existingActivity.start < newActivity.start)
                    || (existingActivity.start < newActivity.end && existingActivity.end > newActivity.start)
                    || (newActivity.start < existingActivity.start && newActivity.end > existingActivity.end)
                    || (existingActivity.start < newActivity.start && existingActivity.end > newActivity.end)) {
                return false;
            }
        }
        return true;
    }
}