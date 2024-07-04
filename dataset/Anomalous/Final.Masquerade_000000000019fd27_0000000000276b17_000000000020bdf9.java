import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        Solver solver = new Solver();
        for (int i = 1; i <= numberOfTests; i++) {
            solver.solve(i, reader);
        }
    }

    static class Solver {

        public void solve(int testCaseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            ArrayList<Interval> cIntervals = new ArrayList<>();
            ArrayList<Interval> jIntervals = new ArrayList<>();
            int numberOfIntervals = Integer.parseInt(reader.readLine());
            boolean isCBusy = false;
            boolean isImpossible = false;

            for (int i = 0; i < numberOfIntervals; i++) {
                Interval interval = new Interval(reader.readLine().split(" "));
                if (!isImpossible) {
                    for (Interval cInterval : cIntervals) {
                        if (cInterval.overlaps(interval)) {
                            isCBusy = true;
                            break;
                        }
                    }

                    if (isCBusy) {
                        for (Interval jInterval : jIntervals) {
                            if (jInterval.overlaps(interval)) {
                                System.out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                                isImpossible = true;
                                break;
                            }
                        }
                        if (!isImpossible) {
                            jIntervals.add(interval);
                            result.append("J");
                        }
                    } else {
                        cIntervals.add(interval);
                        result.append("C");
                    }

                    isCBusy = false;
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + testCaseNumber + ": " + result);
            }
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval(String[] time) {
        this.start = Integer.parseInt(time[0]);
        this.end = Integer.parseInt(time[1]);
    }

    public boolean overlaps(Interval other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}