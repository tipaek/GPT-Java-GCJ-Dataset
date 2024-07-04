import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Activity {
    int id;
    int start;
    int end;
    String actor;
}

public class Solution {

    public static void main(String[] args) {

        Comparator<Activity> compareByStart = Comparator.comparingInt(activity -> activity.start);
        Comparator<Activity> compareByEnd = Comparator.comparingInt(activity -> activity.end);
        Comparator<Activity> compare = compareByStart.thenComparing(compareByEnd);

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Nb of test cases

        for (int i = 1; i <= t; ++i) {
            System.err.println("Test " + i);
            int n = in.nextInt(); // Nb of activities
            List<Activity> activities = new ArrayList<>();
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                Activity activity = new Activity();
                activity.id = j;
                activity.start = in.nextInt();
                activity.end = in.nextInt();
                System.err.println("Activity " + j);
                activities.add(activity);
            }
            activities.sort(compare);

            activities.get(0).actor = "C";
            for (int j = 1; j < n; j++) {
                Activity previous = activities.get(j-1);
                Activity current = activities.get(j);
                if (previous.end <= current.start) {
                    // cas ideal
                    current.actor = previous.actor;
                } else if (previous.actor.equals("C")) {
                    current.actor = "J";
                } else {
                    current.actor = "C";
                }
            }
            System.err.println("Fin attribution");

            // Check validity
            List<Activity> cameronActivities = activities.stream().filter(activity -> activity.actor.equals("C"))
                    .sorted(compare).collect(Collectors.toList());
            System.err.println("Cameron");
            for (int j = 1; j < cameronActivities.size(); j++) {
                Activity previous = cameronActivities.get(j-1);
                Activity current = cameronActivities.get(j);
                if (previous.end > current.start) {
                    impossible = true;
                    break;
                }
            }
            List<Activity> jamieActivities = activities.stream().filter(activity -> activity.actor.equals("J"))
                    .sorted(compare).collect(Collectors.toList());
            System.err.println("Jamie");
            for (int j = 1; j < jamieActivities.size(); j++) {
                Activity previous = jamieActivities.get(j-1);
                Activity current = jamieActivities.get(j);
                if (previous.end > current.start) {
                    impossible = true;
                    break;
                }
            }

            System.err.println("Impression");
            activities.sort(Comparator.comparingInt(activity -> activity.id));
            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" :
                    activities.stream().map(activity -> activity.actor).collect(Collectors.joining(" "))));
        }
    }
}
