import java.util.*;

class Tracker {
    int start;
    int end;
    int index;

    Tracker(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int k = 0; k < testCases; k++) {
            int n = scanner.nextInt();
            List<Tracker> trackers = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                trackers.add(new Tracker(start, end, i));
            }

            sortTrackers(trackers);

            String[] result = new String[n];
            boolean isPossible = true;
            int endC = 0, endJ = 0;

            for (Tracker tracker : trackers) {
                if (tracker.start >= endC) {
                    endC = tracker.end;
                    result[tracker.index] = "C";
                } else if (tracker.start >= endJ) {
                    endJ = tracker.end;
                    result[tracker.index] = "J";
                } else {
                    isPossible = false;
                    break;
                }
            }

            String output = isPossible ? String.join("", result) : "IMPOSSIBLE";
            System.out.println("Case #" + (k + 1) + ": " + output);
        }
    }

    private static void sortTrackers(List<Tracker> trackers) {
        trackers.sort((t1, t2) -> {
            if (t1.start != t2.start) {
                return Integer.compare(t1.start, t2.start);
            } else {
                return Integer.compare(t1.end, t2.end);
            }
        });
    }
}