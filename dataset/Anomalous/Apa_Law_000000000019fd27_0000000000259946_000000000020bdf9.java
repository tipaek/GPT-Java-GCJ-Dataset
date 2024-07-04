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
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < testCases; i++) {
            List<Pair<Integer, Integer>> activities = new ArrayList<>();
            int numActivities = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < numActivities; j++) {
                String[] input = scanner.nextLine().split(" ");
                Pair<Integer, Integer> activity = Pair.of(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                activities.add(activity);
            }

            List<Pair<Integer, Integer>> cameron = new ArrayList<>();
            List<Pair<Integer, Integer>> jamie = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            boolean impossible = false;
            Map<Pair<Integer, Integer>, String> assignment = new HashMap<>();

            activities.sort(Comparator.comparingInt(pair -> pair.first));

            for (Pair<Integer, Integer> activity : activities) {
                int startTime = activity.first;

                if (cameron.isEmpty() || cameron.get(cameron.size() - 1).second <= startTime) {
                    cameron.add(activity);
                    assignment.put(activity, "C");
                } else if (jamie.isEmpty() || jamie.get(jamie.size() - 1).second <= startTime) {
                    jamie.add(activity);
                    assignment.put(activity, "J");
                } else {
                    impossible = true;
                    break;
                }
            }

            for (Pair<Integer, Integer> activity : activities) {
                result.append(assignment.get(activity));
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
        scanner.close();
    }
}