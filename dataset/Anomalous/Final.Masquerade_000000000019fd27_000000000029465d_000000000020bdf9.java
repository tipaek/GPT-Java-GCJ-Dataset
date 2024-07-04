import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        Solver solver = new Solver();
        for (int i = 1; i <= testCases; i++) {
            solver.solve(i, reader);
        }
    }

    static class Solver {

        public void solve(int caseNumber, BufferedReader reader) throws IOException {
            StringBuilder result = new StringBuilder();
            List<Pair> cSchedule = new ArrayList<>();
            List<Pair> jSchedule = new ArrayList<>();
            int activityCount = Integer.parseInt(reader.readLine());
            boolean isImpossible = false;

            List<Pair> activities = new ArrayList<>();
            for (int i = 0; i < activityCount; i++) {
                activities.add(new Pair(reader.readLine().split(" ")));
            }
            activities.sort(Comparator.comparingInt(pair -> pair.start));

            for (Pair activity : activities) {
                if (isImpossible) break;

                boolean cConflict = cSchedule.stream().anyMatch(pair -> pair.conflictsWith(activity));
                boolean jConflict = jSchedule.stream().anyMatch(pair -> pair.conflictsWith(activity));

                if (cConflict && jConflict) {
                    System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
                    isImpossible = true;
                } else if (!cConflict) {
                    cSchedule.add(activity);
                    result.append("C");
                } else {
                    jSchedule.add(activity);
                    result.append("J");
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + caseNumber + ": " + result);
            }
        }
    }
}

class Pair {
    int start;
    int end;

    public Pair(String[] times) {
        this.start = Integer.parseInt(times[0]);
        this.end = Integer.parseInt(times[1]);
    }

    public boolean conflictsWith(Pair other) {
        return !(this.end <= other.start || this.start >= other.end);
    }
}