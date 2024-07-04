import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int k = 1; k <= t; k++) {
            int n = scan.nextInt();
            List<Tracker> tList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                tList.add(new Tracker(start, end, i));
            }

            tList.sort(Comparator.comparingInt((Tracker t) -> t.start)
                                  .thenComparingInt(t -> t.end));

            String[] res = new String[n];
            boolean isPossible = true;
            int cEnd = 0, jEnd = 0;

            for (Tracker tracker : tList) {
                if (tracker.start >= cEnd) {
                    cEnd = tracker.end;
                    res[tracker.index] = "C";
                } else if (tracker.start >= jEnd) {
                    jEnd = tracker.end;
                    res[tracker.index] = "J";
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? String.join("", res) : "IMPOSSIBLE";
            System.out.println("Case #" + k + ": " + result);
        }
    }
}

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