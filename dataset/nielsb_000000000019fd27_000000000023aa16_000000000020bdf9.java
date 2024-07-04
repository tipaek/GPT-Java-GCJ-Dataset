import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            String solution = new Solution(scanner).solve();
            System.out.println("Case #" + t + ": " + solution);
        }
    }

    final String Jamie = "J", Cameron = "C";

    final int N;
    final List<Activity> activities = new ArrayList<>();

    public Solution(Scanner scanner) {
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            activities.add(new Activity(i, scanner.nextInt(), scanner.nextInt()));
        }
    }

    private String solve() {
        activities.sort(new ActivityByStart());

        int JamieAvailableFrom = 0, CameronAvailableFrom = 0;
        for(Activity activity : activities) {
            if (JamieAvailableFrom <= activity.S) {
                activity.assignedTo = Jamie;
                JamieAvailableFrom = activity.E;
            } else if (CameronAvailableFrom <= activity.S) {
                activity.assignedTo = Cameron;
                CameronAvailableFrom = activity.E;
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        activities.sort(new ActivityByIndex());
        String output = activities.stream()
                .map(a -> a.assignedTo)
                .collect(Collectors.joining());

        return output;
    }

    class Activity {
        final int i, S, E;
        String assignedTo = "";

        public Activity(int i, int s, int e) {
            this.i = i;
            S = s;
            E = e;
        }

    }

    class ActivityByIndex implements Comparator<Activity> {

        @Override
        public int compare(Activity one, Activity other) {
            return one.i - other.i;
        }
    }

    class ActivityByStart implements Comparator<Activity> {

        @Override
        public int compare(Activity one, Activity other) {
            return one.S - other.S;
        }
    }

}
