import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Transpose tr = Transpose.get();
        tr.start(new Transpose.Test() {
            @Override
            void onTest(int i, int T) {
                int N = tr.nextInt();
                ArrayList<Activity> activities = new ArrayList<>();

                for (int j = 0; j < N; j++) {
                    int[] times = tr.nextIntArray();
                    activities.add(new Activity(times[0], times[1]));
                }

                Solver solver = new Solver(activities);
                solver.sortActivities();

                if (solver.isImpossible()) {
                    tr.addCase(i, "IMPOSSIBLE");
                } else {
                    tr.addCase(i, solver.solve());
                }
            }
        });
        tr.flush();
    }
}

class Activity {
    int start;
    int end;
    String assignedTo;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int sortValue() {
        return start + end;
    }

    public boolean overlaps(Activity other) {
        return (other.start < end && other.start > start) || (start < other.end && start > other.start);
    }
}

class Solver {
    ArrayList<Activity> activities;
    ArrayList<Activity> sortedActivities;

    public Solver(ArrayList<Activity> activities) {
        this.activities = activities;
        this.sortedActivities = new ArrayList<>(activities);
    }

    public void sortActivities() {
        sortedActivities.sort(Comparator.comparingInt(Activity::sortValue));
    }

    public boolean isImpossible() {
        if (sortedActivities.size() < 3) return false;
        for (int i = 0; i < sortedActivities.size() - 2; i++) {
            if (sortedActivities.get(i).overlaps(sortedActivities.get(i + 1)) &&
                sortedActivities.get(i).overlaps(sortedActivities.get(i + 2)) &&
                sortedActivities.get(i + 1).overlaps(sortedActivities.get(i + 2))) {
                return true;
            }
        }
        return false;
    }

    public String solve() {
        ArrayList<ArrayList<Activity>> overlappingPairs = getOverlappingPairs();

        for (ArrayList<Activity> pair : overlappingPairs) {
            pair.get(0).assignedTo = "C";
            pair.get(1).assignedTo = "J";
        }

        int counter = 0;
        for (Activity activity : sortedActivities) {
            if (activity.assignedTo == null) {
                activity.assignedTo = (counter % 2 == 0) ? "C" : "J";
                counter++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.assignedTo);
        }
        return result.toString();
    }

    private ArrayList<ArrayList<Activity>> getOverlappingPairs() {
        ArrayList<ArrayList<Activity>> pairs = new ArrayList<>();
        for (int i = 0; i < sortedActivities.size() - 1; i++) {
            if (sortedActivities.get(i).overlaps(sortedActivities.get(i + 1))) {
                ArrayList<Activity> pair = new ArrayList<>();
                pair.add(sortedActivities.get(i));
                pair.add(sortedActivities.get(i + 1));
                pairs.add(pair);
            }
        }
        return pairs;
    }
}

class Transpose {
    private BufferedReader br;
    private String queue = "";
    private int T = -1;

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static Transpose get() {
        return new Transpose();
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public int[] nextIntArray() {
        String[] parts = nextLine().split(" ");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }
        return result;
    }

    public void start(Test test) {
        T = nextInt();
        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public Transpose add(String s) {
        queue += s;
        return this;
    }

    public Transpose addCase(int i, String s) {
        return addLine("Case #" + i + ": " + s);
    }

    public Transpose addLine(String s) {
        return add(s + "\n");
    }

    public void flush() {
        if (!queue.isEmpty()) {
            System.out.print(queue);
        }
        queue = "";
    }

    static abstract class Test {
        abstract void onTest(int i, int T);
    }
}