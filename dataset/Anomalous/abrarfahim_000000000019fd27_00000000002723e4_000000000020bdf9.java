import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();
            ArrayList<Pair<Integer, Integer>> intervals = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new Pair<>(start, end));
            }

            int[] order = new int[n];
            for (int l = 0; l < n; l++) {
                order[l] = l;
            }

            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n - 1; b++) {
                    if (intervals.get(b).getValue() > intervals.get(b + 1).getValue()) {
                        Pair<Integer, Integer> tempInterval = intervals.get(b);
                        intervals.set(b, intervals.get(b + 1));
                        intervals.set(b + 1, tempInterval);

                        int tempOrder = order[b];
                        order[b] = order[b + 1];
                        order[b + 1] = tempOrder;
                    }
                }
            }

            StringBuilder schedule = new StringBuilder();
            ArrayList<Pair<Integer, Integer>> jIntervals = new ArrayList<>();
            ArrayList<Pair<Integer, Integer>> cIntervals = new ArrayList<>();

            jIntervals.add(intervals.get(0));
            schedule.append("J");
            intervals.remove(0);

            boolean overlapJ, overlapC, impossible = false;

            for (Pair<Integer, Integer> interval : intervals) {
                overlapJ = false;
                overlapC = false;

                for (Pair<Integer, Integer> jInterval : jIntervals) {
                    if (isOverlapping(jInterval, interval)) {
                        overlapJ = true;
                        break;
                    }
                }

                if (!overlapJ) {
                    jIntervals.add(interval);
                    schedule.append("J");
                    continue;
                }

                for (Pair<Integer, Integer> cInterval : cIntervals) {
                    if (isOverlapping(cInterval, interval)) {
                        overlapC = true;
                        break;
                    }
                }

                if (!overlapC) {
                    cIntervals.add(interval);
                    schedule.append("C");
                } else {
                    impossible = true;
                    break;
                }
            }

            char[] finalSchedule = new char[n];
            if (!impossible) {
                for (int l = 0; l < n; l++) {
                    finalSchedule[order[l]] = schedule.charAt(l);
                }
            }

            String output = impossible ? "IMPOSSIBLE" : new String(finalSchedule);
            System.out.println("Case #" + (t + 1) + ": " + output);
        }
    }

    private static boolean isOverlapping(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
        return (a.getKey() < b.getValue() && a.getValue() > b.getKey());
    }
}

class Pair<U, V> {
    private final U key;
    private final V value;

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