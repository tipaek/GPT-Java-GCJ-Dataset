import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            ArrayList<Pair<Integer, Integer>> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new Pair<>(start, end));
            }

            StringBuilder schedule = new StringBuilder();
            ArrayList<Pair<Integer, Integer>> jSchedule = new ArrayList<>();
            ArrayList<Pair<Integer, Integer>> cSchedule = new ArrayList<>();

            jSchedule.add(intervals.get(0));
            schedule.append("J");
            intervals.remove(0);

            boolean overlapJ = false;
            boolean overlapC = false;
            boolean impossible = false;

            for (Pair<Integer, Integer> interval : intervals) {
                overlapJ = false;
                overlapC = false;

                for (Pair<Integer, Integer> jInterval : jSchedule) {
                    if (isOverlap(jInterval, interval)) {
                        overlapJ = true;
                        break;
                    }
                }

                if (!overlapJ) {
                    jSchedule.add(interval);
                    schedule.append("J");
                    continue;
                }

                for (Pair<Integer, Integer> cInterval : cSchedule) {
                    if (isOverlap(cInterval, interval)) {
                        overlapC = true;
                        break;
                    }
                }

                if (!overlapC) {
                    cSchedule.add(interval);
                    schedule.append("C");
                } else {
                    impossible = true;
                    break;
                }
            }

            String result = impossible ? "IMPOSSIBLE" : schedule.toString();
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static boolean isOverlap(Pair<Integer, Integer> interval1, Pair<Integer, Integer> interval2) {
        return (interval1.getKey() < interval2.getValue() && interval1.getValue() > interval2.getKey());
    }
}

class Pair<U, V> {
    private U key;
    private V value;

    public Pair(U key, V value) {
        this.key = key;
        this.value = value;
    }

    public U getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}