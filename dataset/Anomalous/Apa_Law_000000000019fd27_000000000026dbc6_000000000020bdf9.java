import java.util.*;

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
            return Objects.hash(first, second);
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
            List<Pair<Integer, Integer>> activities = new ArrayList<>();
            int numActivities = Integer.parseInt(sc.nextLine());

            for (int j = 0; j < numActivities; j++) {
                String[] activity = sc.nextLine().split(" ");
                Pair<Integer, Integer> pair = Pair.of(Integer.parseInt(activity[0]), Integer.parseInt(activity[1]));
                activities.add(pair);
            }

            Pair<Integer, Integer> cameron = Pair.of(2000, 2001);
            Pair<Integer, Integer> jamie = Pair.of(2000, 2001);
            StringBuilder result = new StringBuilder();
            boolean impossible = false;

            List<Pair<Integer, Integer>> sortedActivities = new ArrayList<>(activities);
            sortedActivities.sort(Comparator.comparingInt(x -> x.first));
            Map<Pair<Integer, Integer>, String> assignmentMap = new HashMap<>();

            for (Pair<Integer, Integer> activity : sortedActivities) {
                int startTime = activity.first;
                if (cameron.second <= startTime) {
                    cameron = activity;
                    assignmentMap.put(activity, "C");
                } else if (jamie.second == 2001 || jamie.second <= startTime) {
                    jamie = activity;
                    assignmentMap.put(activity, "J");
                } else {
                    impossible = true;
                    break;
                }
            }

            for (Pair<Integer, Integer> activity : activities) {
                result.append(assignmentMap.get(activity));
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