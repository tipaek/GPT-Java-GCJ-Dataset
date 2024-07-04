import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static class Pair {
        int start, end, index;
        char assignedTo;

        Pair(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
            this.assignedTo = 0;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int i = 1; i <= testCases; ++i) {
                System.out.print("Case #" + i + ": ");
                handleTestCase(scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleTestCase(Scanner scanner) {
        int numActivities = scanner.nextInt();
        Pair[] activities = new Pair[numActivities];
        for (int i = 0; i < numActivities; i++) {
            activities[i] = new Pair(scanner.nextInt(), scanner.nextInt(), i);
        }
        Arrays.sort(activities, (a, b) -> Integer.compare(a.start, b.start));

        ArrayList<Pair> cameron = new ArrayList<>();
        ArrayList<Pair> jamie = new ArrayList<>();

        for (Pair activity : activities) {
            if (!hasConflict(cameron, activity)) {
                activity.assignedTo = 'C';
                cameron.add(activity);
            } else if (!hasConflict(jamie, activity)) {
                activity.assignedTo = 'J';
                jamie.add(activity);
            } else {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        Arrays.sort(activities, (a, b) -> Integer.compare(a.index, b.index));
        for (Pair activity : activities) {
            System.out.print(activity.assignedTo);
        }
        System.out.println();
    }

    private static boolean hasConflict(ArrayList<Pair> list, Pair activity) {
        for (Pair existing : list) {
            if ((existing.end > activity.start && existing.start < activity.start)
                    || (existing.start < activity.end && existing.end > activity.start)
                    || (activity.start < existing.start && activity.end > existing.end)
                    || (existing.start < activity.start && existing.end > activity.end)) {
                return true;
            }
        }
        return false;
    }
}