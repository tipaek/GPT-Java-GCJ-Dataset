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
            int activitiesCount = Integer.parseInt(sc.nextLine());
            List<Pair<Integer, Integer>> activities = new ArrayList<>();

            for (int j = 0; j < activitiesCount; j++) {
                String[] activity = sc.nextLine().split(" ");
                activities.add(Pair.of(Integer.parseInt(activity[0]), Integer.parseInt(activity[1])));
            }

            activities.sort(Comparator.comparingInt(x -> x.first));
            Map<Pair<Integer, Integer>, String> assignment = new HashMap<>();
            List<Pair<Integer, Integer>> cameronSchedule = new ArrayList<>();
            List<Pair<Integer, Integer>> jamieSchedule = new ArrayList<>();
            boolean isPossible = true;

            for (Pair<Integer, Integer> activity : activities) {
                if (cameronSchedule.isEmpty() || cameronSchedule.get(cameronSchedule.size() - 1).second <= activity.first) {
                    cameronSchedule.add(activity);
                    assignment.put(activity, "C");
                } else if (jamieSchedule.isEmpty() || jamieSchedule.get(jamieSchedule.size() - 1).second <= activity.first) {
                    jamieSchedule.add(activity);
                    assignment.put(activity, "J");
                } else {
                    isPossible = false;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            for (Pair<Integer, Integer> activity : activities) {
                result.append(assignment.get(activity));
            }

            if (isPossible) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
        }

        sc.close();
    }
}