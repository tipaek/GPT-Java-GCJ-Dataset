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

class Solver {
    private ArrayList<Activity> activities;
    private ArrayList<Activity> sortedActivities = new ArrayList<>();
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
        if (sortedActivities.size() < 3) return false;

        for (int i = 0; i < sortedActivities.size() - 2; i++) {
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

        sortedActivities.get(0).setAssignedTo("C");
        calculateOverlappingPairs();

        for (int i = 1; i < sortedActivities.size(); i++) {
            ArrayList<Activity> overlappingActivities = getOverlappingPartners(sortedActivities.get(i));
            if (!overlappingActivities.isEmpty()) {
                sortedActivities.get(i).setAssignedTo(invert(overlappingActivities.get(0).getAssignedTo()));
            } else {
                sortedActivities.get(i).setAssignedTo("C");
            }
        }

        StringBuilder result = new StringBuilder();
        for (Activity activity : activities) {
            result.append(activity.getAssignedTo());
        }
        return result.toString();
    }

    private ArrayList<Activity> getOverlappingPartners(Activity activity) {
        ArrayList<Activity> partners = new ArrayList<>();
        for (ArrayList<Activity> pair : overlappingPairs) {
            if (pair.get(0).equals(activity)) {
                partners.add(pair.get(1));
            } else if (pair.get(1).equals(activity) && !partners.contains(pair.get(0))) {
                partners.add(pair.get(0));
            }
        }
        return partners;
    }

    private void calculateOverlappingPairs() {
        overlappingPairs.clear();
        for (int i = 0; i < sortedActivities.size(); i++) {
            for (int j = i + 1; j < sortedActivities.size(); j++) {
                if (sortedActivities.get(i).overlaps(sortedActivities.get(j))) {
                    ArrayList<Activity> pair = new ArrayList<>();
                    pair.add(sortedActivities.get(i));
                    pair.add(sortedActivities.get(j));
                    overlappingPairs.add(pair);
                }
            }
        }
    }

    private static String invert(String assignedTo) {
        return assignedTo.equals("C") ? "J" : "C";
    }
}

class Activity {
    private int start;
    private int end;
    private String assignedTo;

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

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
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
    private BufferedReader br;
    private StringBuilder queue = new StringBuilder();
    private int T = -1;

    public static Transpose get() {
        return new Transpose();
    }

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
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
        T = nextInt();
        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public Transpose addCase(int i, String result) {
        queue.append("Case #").append(i).append(": ").append(result).append("\n");
        return this;
    }

    public void flush() {
        System.out.print(queue.toString());
        queue.setLength(0);
    }

    static abstract class Test {
        abstract void onTest(int i, int T);
    }
}