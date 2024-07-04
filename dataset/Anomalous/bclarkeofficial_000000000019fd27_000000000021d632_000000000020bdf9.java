import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int activityCount = scanner.nextInt();
                scanner.nextLine();

                List<Activity> activities = new ArrayList<>();
                for (int i = 0; i < activityCount; i++) {
                    int start = scanner.nextInt();
                    int end = scanner.nextInt();
                    activities.add(new Activity(i, start, end));
                    scanner.nextLine();
                }

                activities.sort(Comparator.comparingInt(a -> a.start));

                int lastEndJamie = -1;
                int lastEndCameron = -1;
                boolean isImpossible = false;

                for (Activity activity : activities) {
                    if (activity.start >= lastEndJamie) {
                        activity.assignTo("J");
                        lastEndJamie = activity.end;
                    } else if (activity.start >= lastEndCameron) {
                        activity.assignTo("C");
                        lastEndCameron = activity.end;
                    } else {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                } else {
                    activities.sort(Comparator.comparingInt(a -> a.index));
                    StringBuilder result = new StringBuilder();
                    for (Activity activity : activities) {
                        result.append(activity.assignedPerson);
                    }
                    System.out.println("Case #" + caseNumber + ": " + result);
                }
            }
        }
    }

    static class Activity {
        final int index;
        final int start;
        final int end;
        String assignedPerson;

        Activity(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        void assignTo(String person) {
            this.assignedPerson = person;
        }
    }
}