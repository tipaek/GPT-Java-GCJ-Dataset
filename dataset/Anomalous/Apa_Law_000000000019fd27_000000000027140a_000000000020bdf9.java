import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    static class Triplet<U, V, W> {
        public U first;
        public V second;
        public W index;
        public String label;

        public Triplet(U first, V second, W index) {
            this.first = first;
            this.second = second;
            this.index = index;
        }

        public Triplet(U first, V second, W index, String label) {
            this.first = first;
            this.second = second;
            this.index = index;
            this.label = label;
        }

        @Override
        public String toString() {
            return "(" + index + ")";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((first == null) ? 0 : first.hashCode());
            result = prime * result + ((index == null) ? 0 : index.hashCode());
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            result = prime * result + ((second == null) ? 0 : second.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Triplet<?, ?, ?> other = (Triplet<?, ?, ?>) obj;
            if (first == null) {
                if (other.first != null)
                    return false;
            } else if (!first.equals(other.first))
                return false;
            if (index == null) {
                if (other.index != null)
                    return false;
            } else if (!index.equals(other.index))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            if (second == null) {
                if (other.second != null)
                    return false;
            } else if (!second.equals(other.second))
                return false;
            return true;
        }

        public static <U, V, W> Triplet<U, V, W> of(U a, V b, W c) {
            return new Triplet<>(a, b, c);
        }

        public static <U, V, W> Triplet<U, V, W> of(U a, V b, W c, String d) {
            return new Triplet<>(a, b, c, d);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCases; i++) {
            List<Triplet<Integer, Integer, Integer>> activities = new ArrayList<>();
            int numActivities = Integer.parseInt(sc.nextLine());

            for (int j = 0; j < numActivities; j++) {
                String[] activity = sc.nextLine().split(" ");
                activities.add(Triplet.of(Integer.parseInt(activity[0]), Integer.parseInt(activity[1]), j));
            }

            Triplet<Integer, Integer, Integer> cameron = Triplet.of(2000, 2001, 3000);
            Triplet<Integer, Integer, Integer> jamie = Triplet.of(2000, 2001, 3000);
            String result = "";
            boolean impossible = false;

            List<Triplet<Integer, Integer, Integer>> sortedActivities = new ArrayList<>(activities);
            sortedActivities.sort(Comparator.comparing(x -> x.first));

            for (Triplet<Integer, Integer, Integer> activity : sortedActivities) {
                int startTime = activity.first;

                if (cameron.second <= startTime) {
                    cameron = activity;
                    activities.set(activity.index, Triplet.of(activity.first, activity.second, activity.index, "C"));
                } else if (jamie.second == 2001 || jamie.second <= startTime) {
                    jamie = activity;
                    activities.set(activity.index, Triplet.of(activity.first, activity.second, activity.index, "J"));
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                activities.sort(Comparator.comparing(x -> x.index));
                for (Triplet<Integer, Integer, Integer> activity : activities) {
                    result += activity.label;
                }
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }
        sc.close();
    }
}