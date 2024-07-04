import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {

        Transpose tr = Transpose.getInstance();
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

class Solver {
    private final ArrayList<Activity> activities;
    private final ArrayList<Activity> sortedActivities = new ArrayList<>();
    private ArrayList<ArrayList<Activity>> overlappingPairs = new ArrayList<>();

    public Solver(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public void sortActivities() {
        sortedActivities.clear();
        sortedActivities.addAll(activities);
        sortedActivities.sort(Comparator.comparingInt(Activity::getStart));
    }

    public boolean isImpossible() {
        int size = sortedActivities.size();
        if (size < 3) return false;

        for (int i = 0; i < size - 2; i++) {
            if (sortedActivities.get(i).overlaps(sortedActivities.get(i + 1)) &&
                sortedActivities.get(i).overlaps(sortedActivities.get(i + 2)) &&
                !sortedActivities.get(i + 1).overlaps(sortedActivities.get(i + 2))) {
                return true;
            }
        }
        return false;
    }

    public String solve() {
        if (sortedActivities.isEmpty()) return "";

        sortedActivities.get(0).setTo("C");
        calculateOverlappingPairs();

        for (int i = 1; i < sortedActivities.size(); i++) {
            ArrayList<Activity> overlappingPartners = getOverlappingPartners(sortedActivities.get(i));

            if (!overlappingPartners.isEmpty()) {
                sortedActivities.get(i).setTo(invert(overlappingPartners.get(0).getTo()));
            } else {
                sortedActivities.get(i).setTo("C");
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getTo());
        }
        return result.toString();
    }

    private ArrayList<Activity> getOverlappingPartners(Activity activity) {
        ArrayList<Activity> partners = new ArrayList<>();
        for (ArrayList<Activity> pair : overlappingPairs) {
            Activity first = pair.get(0);
            Activity second = pair.get(1);
            if (first.equals(activity)) {
                partners.add(second);
            } else if (second.equals(activity) && !partners.contains(first)) {
                partners.add(first);
            }
        }
        return partners;
    }

    private void calculateOverlappingPairs() {
        overlappingPairs.clear();
        int size = sortedActivities.size();

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (sortedActivities.get(i).overlaps(sortedActivities.get(j))) {
                    ArrayList<Activity> pair = new ArrayList<>();
                    pair.add(sortedActivities.get(i));
                    pair.add(sortedActivities.get(j));
                    overlappingPairs.add(pair);
                }
            }
        }
    }

    private String invert(String s) {
        return s.equals("C") ? "J" : "C";
    }
}

class Activity {
    private final int start;
    private final int end;
    private String to;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean overlaps(Activity other) {
        return (other.start > start && other.start < end) ||
               (start > other.start && start < other.end) ||
               (other.end > start && other.end < end) ||
               (end > other.start && end < other.end);
    }

    @Override
    public String toString() {
        return start + "," + end;
    }
}

class Transpose {
    private final BufferedReader br;
    private String queue = "";
    private int T = -1;
    private int TE = -1;

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static Transpose getInstance() {
        return new Transpose();
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public double nextDouble() {
        return Double.parseDouble(nextLine());
    }

    public String[] nextStringArray() {
        try {
            return br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[]{};
        }
    }

    public int[] nextIntArray() {
        String[] strings = nextStringArray();
        int[] integers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }

    public void start(Test test) {
        int[] testParams = nextIntArray();
        T = testParams[0];
        if (testParams.length > 1) {
            TE = testParams[1];
        }
        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public Transpose add(String s) {
        queue += s;
        return this;
    }

    public Transpose addCase(int i, String s) {
        addLine("Case #" + i + ": " + s);
        return this;
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