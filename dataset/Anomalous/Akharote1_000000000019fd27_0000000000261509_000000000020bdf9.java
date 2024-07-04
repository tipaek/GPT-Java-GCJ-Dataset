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
                    int[] ix = tr.nextIntArray();
                    activities.add(new Activity(ix[0], ix[1]));
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
    int start, end;
    String to;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int sortValue() {
        return start;
    }

    public boolean overlaps(Activity other) {
        return (other.start > start && other.start < end) || (start > other.start && start < other.end);
    }

    @Override
    public String toString() {
        return start + "," + end;
    }
}

class Solver {
    ArrayList<Activity> activities;
    ArrayList<Activity> sortedActivities;
    ArrayList<ArrayList<Activity>> pairs;

    public Solver(ArrayList<Activity> activities) {
        this.activities = activities;
        this.sortedActivities = new ArrayList<>(activities);
        this.pairs = new ArrayList<>();
    }

    public void sortActivities() {
        sortedActivities.sort(Comparator.comparingInt(Activity::sortValue));
    }

    public boolean isImpossible() {
        int size = sortedActivities.size();
        if (size < 3) return false;
        for (int i = 0; i < size - 2; i++) {
            if (sortedActivities.get(i).overlaps(sortedActivities.get(i + 1)) &&
                sortedActivities.get(i).overlaps(sortedActivities.get(i + 2)) &&
                sortedActivities.get(i + 1).overlaps(sortedActivities.get(i + 2))) {
                return true;
            }
        }
        return false;
    }

    public String solve() {
        sortedActivities.get(0).to = "C";
        calculateOverlappingPairs();
        for (int i = 1; i < sortedActivities.size(); i++) {
            ArrayList<Activity> overlappingPartners = getPairPartners(sortedActivities.get(i));
            sortedActivities.get(i).to = overlappingPartners.isEmpty() ? "C" : invert(overlappingPartners.get(0).to);
        }
        StringBuilder output = new StringBuilder();
        for (Activity activity : activities) {
            output.append(activity.to);
        }
        return output.toString();
    }

    private ArrayList<Activity> getPairPartners(Activity activity) {
        ArrayList<Activity> partners = new ArrayList<>();
        for (ArrayList<Activity> pair : pairs) {
            if (pair.get(0) == activity) partners.add(pair.get(1));
            else if (pair.get(1) == activity) partners.add(pair.get(0));
        }
        return partners;
    }

    private void calculateOverlappingPairs() {
        pairs.clear();
        int size = sortedActivities.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (sortedActivities.get(i).overlaps(sortedActivities.get(j))) {
                    ArrayList<Activity> pair = new ArrayList<>();
                    pair.add(sortedActivities.get(i));
                    pair.add(sortedActivities.get(j));
                    pairs.add(pair);
                }
            }
        }
    }

    private static String invert(String s) {
        return s.equals("C") ? "J" : "C";
    }
}

class Transpose {
    private BufferedReader br;
    private StringBuilder outputQueue;
    private int T, TE;

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
        outputQueue = new StringBuilder();
    }

    public static Transpose get() {
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

    public int[] nextIntArray() {
        String[] tokens = nextLine().split(" ");
        int[] array = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
        return array;
    }

    public void start(Test test) {
        int[] ts = nextIntArray();
        T = ts[0];
        TE = (ts.length > 1) ? ts[1] : -1;
        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public Transpose add(String s) {
        outputQueue.append(s);
        return this;
    }

    public Transpose addCase(int i, String s) {
        return addLine("Case #" + i + ": " + s);
    }

    public Transpose addLine(String s) {
        return add(s + "\n");
    }

    public void flush() {
        System.out.print(outputQueue.toString());
        outputQueue.setLength(0);
    }

    static abstract class Test {
        abstract void onTest(int i, int T);
    }
}