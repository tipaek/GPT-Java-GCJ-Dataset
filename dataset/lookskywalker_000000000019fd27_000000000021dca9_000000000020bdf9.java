import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static class Activity {
        public int start;
        public int end;
        public int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, 'C');
        map.put(1, 'J');

        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            List<Activity> activities = new ArrayList<>(N);
            List<Integer> assign = new ArrayList<>(N);
            for (int n = 0; n < N; n++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end, n));
            }

            activities.sort((o1, o2) -> Integer.compare(o1.start, o2.start));

            Map<Integer, List<Activity>> schedule = new HashMap<>();

            for (int n = 0; n < N; ++n) {
                Activity activity = activities.get(n);
                boolean fit = false;
                int person = 0;
                for (Map.Entry<Integer, List<Activity>> entry : schedule.entrySet()) {
                    person = entry.getKey();
                    List<Activity> activitiesOfPerson = new ArrayList<>(entry.getValue());
                    Activity lastActivity = activitiesOfPerson.get(activitiesOfPerson.size() - 1);
                    if (lastActivity.end <= activity.start) {
                        fit = true;
                        activitiesOfPerson.add(activity);
                        schedule.put(person, activitiesOfPerson);
                        break;
                    }
                }

                if (!fit) {
                    if (schedule.isEmpty())
                        schedule.put(person, Arrays.asList(activity));
                    else
                        schedule.put(++person, Arrays.asList(activity));
                }

                assign.add(person);
            }

            String res = "Case #" + t + ": ";
            if (schedule.size() > 2) {
                res += "IMPOSSIBLE";
            } else {
                char[] assignx = new char[N];
                for (int i = 0; i < N; i++) {
                    Activity activity = activities.get(i);
                    assignx[activity.index] = map.get(assign.get(i));
                }
                for (char item : assignx) {
                    res += item;
                }
            }
            System.out.println(res);
        }
    }
}