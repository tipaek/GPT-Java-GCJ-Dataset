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
    boolean ok;
}

public class Solution {

    public static void main(String[] args) {

        Comparator<Activity> compareByStart = Comparator.comparingInt(activity -> activity.start);
        Comparator<Activity> compareByEnd = Comparator.comparingInt(activity -> activity.end);
        Comparator<Activity> compare = compareByStart.thenComparing(compareByEnd);

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Nb of test cases

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Nb of activities
            List<Activity> activities = new ArrayList<>();
            boolean impossible = false;

            for (int j = 0; j < n; j++) {
                Activity activity = new Activity();
                activity.id = j;
                activity.start = in.nextInt();
                activity.end = in.nextInt();
                activities.add(activity);
            }
            activities.sort(compare);

            while (activities.stream().anyMatch(act -> act.actor == null)) {
                Activity activity = activities.stream().filter(act -> !act.ok)
                        .filter(act -> act.actor != null)
                        .min(compare)
                        .orElse(activities.stream().filter(act -> !act.ok).min(compare).orElse(null));
                List<Activity> overlaps = activities.stream().filter(act -> act.id != activity.id)
                        .filter(act -> (act.start > activity.start && act.start < activity.end)
                                || (act.end > activity.start && act.end < activity.end))
                        .collect(Collectors.toList());
                List<String> authors = overlaps.stream().filter(act -> act.actor != null)
                        .map(act -> act.actor).distinct().collect(Collectors.toList());
                if ((activity.actor == null || activity.actor.equals("C")) && authors.isEmpty()) {
                    activity.actor = "C";
                    for (Activity act : overlaps) {
                        act.actor = "J";
                    }
                } else if (authors.isEmpty() && activity.actor.equals("J")) {
                    for (Activity act : overlaps) {
                        act.actor = "C";
                    }
                } else if (authors.size() == 2) {
                    impossible = true;
                    break;
                } else if (authors.size() == 1 && activity.actor == null) {
                    if (authors.get(0).equals("C")) {
                        activity.actor = "J";
                    } else {
                        activity.actor = "C";
                    }
                    for (Activity act : overlaps) {
                        act.actor = authors.get(0);
                    }
                } else if (authors.size() == 1 && activity.actor != null && authors.get(0).equals(activity.actor)) {
                    impossible = true;
                    break;
                }
                activity.ok = true;
            }

            if (!impossible) {
                // Check validity
                List<Activity> cameronActivities = activities.stream().filter(activity -> activity.actor.equals("C"))
                        .sorted(compare).collect(Collectors.toList());
                for (int j = 1; j < cameronActivities.size(); j++) {
                    Activity previous = cameronActivities.get(j - 1);
                    Activity current = cameronActivities.get(j);
                    if (previous.end > current.start) {
                        impossible = true;
                        break;
                    }
                }
                List<Activity> jamieActivities = activities.stream().filter(activity -> activity.actor.equals("J"))
                        .sorted(compare).collect(Collectors.toList());
                for (int j = 1; j < jamieActivities.size(); j++) {
                    Activity previous = jamieActivities.get(j - 1);
                    Activity current = jamieActivities.get(j);
                    if (previous.end > current.start) {
                        impossible = true;
                        break;
                    }
                }
            }

            activities.sort(Comparator.comparingInt(activity -> activity.id));
            System.out.println("Case #" + i + ": " + (impossible ? "IMPOSSIBLE" :
                    activities.stream().map(activity -> activity.actor).collect(Collectors.joining(" "))));
        }
    }
}