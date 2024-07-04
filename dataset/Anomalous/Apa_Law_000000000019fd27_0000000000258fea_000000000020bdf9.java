import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static class Pair<U, V> {
        public final U first;
        public final V second;

        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return 31 * first.hashCode() + second.hashCode();
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        public static <U, V> Pair<U, V> of(U a, V b) {
            return new Pair<>(a, b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCases; i++) {
            int activitiesCount = Integer.parseInt(sc.nextLine());
            List<Pair<Integer, Integer>> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                String[] activity = sc.nextLine().split(" ");
                activities.add(Pair.of(Integer.parseInt(activity[0]), Integer.parseInt(activity[1])));
            }

            activities.sort(Comparator.comparingInt(pair -> pair.first));

            List<Pair<Integer, Integer>> cameron = new ArrayList<>();
            List<Pair<Integer, Integer>> jamie = new ArrayList<>();
            Map<Pair<Integer, Integer>, String> assignment = new HashMap<>();
            boolean impossible = false;

            for (int j = 0; j < activities.size(); j++) {
                Pair<Integer, Integer> currentActivity = activities.get(j);
                int startTime = currentActivity.first;

                if (j == 0) {
                    cameron.add(currentActivity);
                    assignment.put(currentActivity, "C");
                } else if (j == 1) {
                    jamie.add(currentActivity);
                    assignment.put(currentActivity, "J");
                } else {
                    Pair<Integer, Integer> lastCameronActivity = cameron.get(cameron.size() - 1);
                    Pair<Integer, Integer> lastJamieActivity = jamie.get(jamie.size() - 1);

                    if (lastCameronActivity.second <= startTime) {
                        cameron.add(currentActivity);
                        assignment.put(currentActivity, "C");
                    } else if (lastJamieActivity.second <= startTime) {
                        jamie.add(currentActivity);
                        assignment.put(currentActivity, "J");
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (Pair<Integer, Integer> activity : activities) {
                result.append(assignment.get(activity));
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }

        sc.close();
    }
}