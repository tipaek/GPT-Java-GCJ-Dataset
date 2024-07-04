import java.util.*;

public class Solution {

    static class Pair<U, V> {
        public final U first;    // first field of a Pair
        public final V second;   // second field of a Pair

        // Constructs a new Pair with specified values
        private Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        // Factory method for creating a Typed Pair instance
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
                Pair<Integer, Integer> p = Pair.of(Integer.parseInt(activity[0]), Integer.parseInt(activity[1]));
                activities.add(p);
            }

            activities.sort(Comparator.comparingInt(x -> x.first));
            List<Pair<Integer, Integer>> cameron = new ArrayList<>();
            List<Pair<Integer, Integer>> jamie = new ArrayList<>();
            Map<Pair<Integer, Integer>, String> assignment = new HashMap<>();
            boolean impossible = false;

            for (Pair<Integer, Integer> activity : activities) {
                if (cameron.isEmpty() || cameron.get(cameron.size() - 1).second <= activity.first) {
                    cameron.add(activity);
                    assignment.put(activity, "C");
                } else if (jamie.isEmpty() || jamie.get(jamie.size() - 1).second <= activity.first) {
                    jamie.add(activity);
                    assignment.put(activity, "J");
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Pair<Integer, Integer> activity : activities) {
                    result.append(assignment.get(activity));
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
        sc.close();
    }
}